package scottie.cs301.EpicActuals.LocalProtect;

import java.util.ArrayList;

import scottie.cs301.EpicActuals.Resources.Actions.SendSpell;
import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.GamePlayer;
import scottie.cs301.Imports.GameFramework.LocalGame;
import scottie.cs301.Imports.GameFramework.actionMsg.GameAction;

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

    protected GameStateActual masterState = null;

    public LocalGameActual() {
        masterState = new GameStateActual();
    }

    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        GameStateActual stateForPlayer = new GameStateActual(masterState);
        p.sendInfo(stateForPlayer);

    } //takes state and passes it along

    @Override
    protected boolean canMove(int playerIdx) {

        return playerIdx==masterState.getWhoseTurn();
    }

    @Override
    public boolean makeMove(GameAction action) {
        if (action == null) {
            return true;
        }
        else if (action instanceof SendSpell) {
            SendSpell theSpellAction = (SendSpell) action;
            int spellLength = theSpellAction.theSpell.size();
            ArrayList<Card> castedSpell = theSpellAction.theSpell;

            int playerTurn = masterState.getWhoseTurn();
            if (spellLength == 0)
            {
                return false;
            }

            else
            {
                for (Card a :castedSpell)
                {
                    a.resolve(masterState,playerTurn);
                }
                masterState.dealNewHandTo(playerTurn);
                playerTurn++;
                if (playerTurn>=masterState.playerHealths.length)
                {
                    masterState.setWhoseTurn(0);
                }
                else
                {
                    masterState.setWhoseTurn(playerTurn);
                }

                return true;
            }


        }
        else
        {
            return false;
        }
    }

    @Override
    protected String checkIfGameOver() {
        int numAlive = 0;
        int numOfLastPlayer = 0;
        for (int itter = 0; itter < masterState.playerHealths.length; itter++)
        {
            if (masterState.playerHealths[itter]<=0)
            {
                numAlive++;
                numOfLastPlayer = itter;

            }
        }
        if (numAlive==1)
        {
            return "Player "+numOfLastPlayer+" has won!";
        }
        else
        {
            return null;
        }
    } //end game string
}
