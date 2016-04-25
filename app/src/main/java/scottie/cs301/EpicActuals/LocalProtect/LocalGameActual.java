package scottie.cs301.EpicActuals.LocalProtect;

import java.io.Serializable;
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
 * Later rewritten and improved by Markus Perry
 */
public class LocalGameActual extends LocalGame implements Serializable{

    private static final long serialVersionUID = -6396033535328393791L;
    protected GameStateActual masterState = null; // gamestate object

    /**
     * constructor
     */
    public LocalGameActual() {
        masterState = new GameStateActual();
    }

    /**
     * takes the state and passes it along
     *
     * @param p gameplayer object
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        GameStateActual stateForPlayer = new GameStateActual(masterState);
        p.sendInfo(stateForPlayer);

    }

    /**
     * checks to see of the player can move
     *
     * @param playerIdx the player's player-number (ID)
     * @return  true if player can move
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if (playerIdx==masterState.getWhoseTurn())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * method called when new action arrives from player
     *
     * @param action action recieved from the player
     * @return true if action was taken, false otherwise
     */
    @Override
    public boolean makeMove(GameAction action) {
        if (action == null) {
            return false;
        }

        // if action is sendSpell
        else if (action instanceof SendSpell) {
            SendSpell theSpellAction = (SendSpell) action;
            int spellLength = theSpellAction.theSpell.size();
            ArrayList<Card> castedSpell = theSpellAction.theSpell;
            int playerTurn = masterState.getWhoseTurn();
            if (spellLength == 0)
            {
                return false;
            }

            // resolves the cards in order of selection
            else
            {
                boolean firstCard = false;
                boolean secondCard = false;
                boolean thirdCard = false;

                boolean validHand = true;

                for (Card a :castedSpell)
                {
                    // enforces legal move- order of the cards
                    if (a.placement==1 && !firstCard)
                    {
                       firstCard = true;
                    }
                    else if (a.placement==1 && firstCard)
                    {
                        validHand = false;
                        break;
                    }

                    if (a.placement==2 &&!secondCard)
                    {
                       secondCard = true;
                    }

                    else if (a.placement==2 && secondCard)
                    {
                        validHand = false;
                        break;
                    }

                    if (a.placement==3 && !thirdCard)
                    {
                        thirdCard = true;
                    }
                    else if (a.placement==3 && thirdCard)
                    {
                        validHand = false;
                        break;
                    }
                }
                if (validHand)
                {
                    for (Card a :castedSpell)
                    {
                        a.resolve(masterState, playerTurn);
                    }
                }
                else
                {
                    return false;
                }

                // deals new hand
                masterState.dealNewHandTo(playerTurn, castedSpell);

                //sets whose turn it is
                if (playerTurn+1==4)
                {
                    masterState.setWhoseTurn(0);
                }
                else
                {
                    masterState.setWhoseTurn(playerTurn+1);
                }

                return true;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * checks if the game is over
     *
     * @return  message proclaiming the winner
     */
    @Override
    protected String checkIfGameOver() {
        int numAlive = 0; // ID number of last wizards alive
        int numOfLastPlayer = 0; // number of players left alive
        int numDead=0;

        //finds number of players still alive
        for (int itter = 0; itter < masterState.playerHealths.length; itter++)
        {
            if (masterState.playerHealths[itter]>0)
            {
                numAlive++;
                numOfLastPlayer = itter;
            }
            else
            {
                numDead++;
            }
        }

        // proclaims winner when only 1 is left alive
        if (numAlive==1)
        {
            numOfLastPlayer++;
            return "Player "+numOfLastPlayer+" has won!";
        }
        if (numDead==4)
        {
            return "IT'S A TIE!!";
        }
        else
        {
            return null;
        }
    } //end game string

}
