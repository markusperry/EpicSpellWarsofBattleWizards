package scottie.cs301.EpicActuals.Players;

import android.util.Log;

import java.util.ArrayList;

import scottie.cs301.EpicActuals.Resources.Actions.SendSpell;
import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.GameComputerPlayer;
import scottie.cs301.Imports.GameFramework.infoMsg.GameInfo;
import scottie.cs301.Imports.GameFramework.infoMsg.IllegalMoveInfo;
import scottie.cs301.Imports.GameFramework.infoMsg.NotYourTurnInfo;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * This is the smarter AI.
 * Uses all functionality of its super, but overrides decision making methods.
 */
public class ComputerActualSmartyPants extends GameComputerPlayer {

    /**
     * default constructor
     *
     * @param name  name of random computer player
     */
    public ComputerActualSmartyPants(String name) {
        super(name);
    } //default constructor

    GameStateActual myRecentState; // gamestateactual object

    /**
     * overrides the recieveInfo method from the super class
     * assigns value to Recent State and dispatches helper methods
     *
     * @param info  GameInfo object passed in
     */
    protected void receiveInfo(GameInfo info) {
        if (info instanceof NotYourTurnInfo)
        {
            return;
        }

        if (info instanceof GameStateActual) //only react if info is a full state
        {
            myRecentState = (GameStateActual) info;
            if (myRecentState.playerHealths[playerNum]==0)
            {
                myRecentState.incrementTurn(playerNum);
                return;
            }
            this.sleep(1000);
            game.sendAction(new SendSpell(this, selectNextSpell()));
            Log.i("Computer Player: ", "" + this);//cast it and store
        }

        if (info instanceof IllegalMoveInfo)
        {
            ArrayList<Card> newSpell = this.selectNextSpell();
            game.sendAction(new SendSpell(this, newSpell));
        }
    }


    /**
     * selects the spell components based on the highest initiative of the cards in hand
     *
     * @return  spell
     */
    public ArrayList<Card> selectNextSpell() {
        ArrayList<Card> spellToSend = new ArrayList<Card>(); // arraylists of cards in spell
        Card firstCard = null;
        Card secondCard = null;
        Card thirdCard = null;
        for (Card a :myRecentState.playerHands.get(playerNum))
        {
            switch (a.placement)
            {
                case 1: firstCard=a;break;
                case 2: secondCard=a;break;
                case 3: thirdCard=a;break;
            }
        }
        if (firstCard != null)
        {
            spellToSend.add(firstCard);
        }
        if (secondCard != null)
        {
            spellToSend.add(secondCard);
        }
        if (thirdCard != null)
        {
            spellToSend.add(thirdCard);
        }

        return spellToSend;
    }
}
