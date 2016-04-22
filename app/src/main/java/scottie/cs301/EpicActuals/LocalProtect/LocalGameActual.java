package scottie.cs301.EpicActuals.LocalProtect;

import scottie.cs301.EpicActuals.Players.ComputerActualRandy;
import scottie.cs301.EpicActuals.Resources.Actions.OVRD;
import scottie.cs301.EpicActuals.Resources.Actions.SendChoice;
import scottie.cs301.EpicActuals.Resources.Actions.SendOverride;
import scottie.cs301.EpicActuals.Resources.Actions.SendSpell;
import scottie.cs301.EpicActuals.Resources.Cards.Deck;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.EpicActuals.Resources.Info.LOCATION;
import scottie.cs301.EpicActuals.Resources.Info.PlayerDataNode;
import scottie.cs301.EpicActuals.Resources.Info.STAGE;
import scottie.cs301.Imports.GameFramework.GamePlayer;
import scottie.cs301.Imports.GameFramework.LocalGame;
import scottie.cs301.Imports.GameFramework.actionMsg.GameAction;

import static java.util.Arrays.copyOf;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * Local Game subclass that will be the main driver for gameplay.
 * Contains static Deck reference.
 * Receives actions and dispatches changes to Game State.
 */
public class LocalGameActual
        extends LocalGame {
    public static LocalGameActual theGame;
    protected GameStateActual masterState = null;

    public static PlayerDataNode[] playerDataNodes;
    public final static Deck DECK = new Deck(); //static reference array

    private ComputerActualRandy dummy = new ComputerActualRandy("Dummy");


    public LocalGameActual(int numPlayers) {
        theGame = this;
        masterState = new GameStateActual(numPlayers);
        dummy.forceId(5);
    }

    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        p.sendInfo(new GameStateActual
                (STATIC.idOf(p),
                        masterState
                ));
    } //takes state and passes it along

    @Override
    protected boolean canMove(int playerIdx) {
        if (playerIdx == -1) {
            return true;
        }
        return masterState.playerStages[playerIdx] == masterState.curStage;
    }

    @Override
    public boolean makeMove(GameAction action) {
        if (action == null) {
            return true;
        }
        return STATIC.convertSendMake(action);
    }

    @Override
    protected String checkIfGameOver() {
        int numAlive = 0;
        String lastAlive = "Error";
        for (int itter = 0; itter < masterState.playerHealths.length; itter++) {
            int cur = masterState.playerHealths[itter];
            if (cur != 0) {
                lastAlive = "" + itter;
                numAlive++;
            } else {
                masterState.playerStages[itter - 1] = STAGE.LockedDead;
            }
        }
        if (numAlive <= 1) {
            return lastAlive + " has won the game.";
        }
        else {

            return null;
        }
    } //end game string

    protected boolean makeMove(SendChoice action) {
        return false;
    }

    protected boolean makeMove(SendOverride action) {
        if (action.theOVRDAction == OVRD.AdvanceToCasting) {
            masterState.curStage = STAGE.WaitingToCast;
            int[] cardsToResolve = masterState.allCardsFrom(STATIC.locOf(1,LOCATION.Spell),masterState.spellCardLocation);
            for(int i =0; i<cardsToResolve.length;i++)
            {
                DECK.theDeck[cardsToResolve[i]].resolve(masterState,cardsToResolve,1);
            }

        }
        if (action.theOVRDAction == OVRD.AdvanceToSelecting) {

            for (int itter = 0; itter < masterState.playerHealths.length; itter++) {
                if (masterState.playerStages[itter] != STAGE.LockedDead) {
                    masterState.deal(itter);
                    masterState.playerStages[itter] = STAGE.SelectingCards;

                }
            }
            masterState.curStage = STAGE.SelectingCards;
        }
        return true;
    }

    protected boolean makeMove(SendSpell action) {
        masterState.addSpell(action.playerID, action.theSpell);
        masterState.playerStages[action.playerID] = STAGE.DoneSelecting;
        if (masterState.curStage == STAGE.SelectingCards) {
            boolean escapeSelectionPhase = false;
            for (int itter = 0; itter < masterState.playerHealths.length; itter++) {
                if (masterState.playerStages[itter] != STAGE.LockedDead) {
                    escapeSelectionPhase = escapeSelectionPhase && (masterState.playerStages[itter] == STAGE.DoneSelecting);
                }
            }
            if (escapeSelectionPhase) {
                this.sendAction(new SendOverride(dummy, OVRD.AdvanceToCasting));
                //checkIfGameOver()
            }
        }

        return true;
    }
}
