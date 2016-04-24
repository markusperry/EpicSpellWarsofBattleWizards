package scottie.cs301.EpicActuals.Players;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Actions.SendSpell;
import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.GameComputerPlayer;
import scottie.cs301.Imports.GameFramework.infoMsg.GameInfo;
import scottie.cs301.Imports.GameFramework.infoMsg.GameState;
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
        if (info instanceof IllegalMoveInfo || info instanceof NotYourTurnInfo)
        {
            return;
        }

        else if (info instanceof GameStateActual) //only react if info is a full state
        {
            myRecentState = (GameStateActual) info;
            this.sleep(2000);
            game.sendAction(new SendSpell(this, selectNextSpell()));
            Log.i("Computer Player: ", "" + this);//cast it and store
        }
    }


    /**
     * selects the spell components based on the highest initiative of the cards in hand
     *
     * @return  spell
     */
    public ArrayList<Card> selectNextSpell() {
        ArrayList<Card> spellToSend = new ArrayList<Card>(); // arraylists of cards in spell
        int cardSelector = 0; //
        int strongestInit=0;
        Card thirdCard = null;
        for (Card a :myRecentState.playerHands.get(playerNum))
        {
            if (a.placement==3)
            {
                if (a.initiative>=strongestInit)
                {
                    strongestInit = a.initiative;
                    thirdCard = a;
                }
            }
        }

        Random gen = new Random();
        int firstCard = gen.nextInt(myRecentState.playerHands.get(playerNum).size());
        int secondCard = gen.nextInt(myRecentState.playerHands.get(playerNum).size());

        spellToSend.add(0,myRecentState.playerHands.get(playerNum).get(firstCard));
        spellToSend.add(1,myRecentState.playerHands.get(playerNum).get(secondCard));
        spellToSend.add(2,thirdCard);

        return spellToSend;
    }
}
