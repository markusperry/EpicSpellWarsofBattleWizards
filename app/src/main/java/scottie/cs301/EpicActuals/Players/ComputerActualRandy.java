package scottie.cs301.EpicActuals.Players;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

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
 * This is the basic AI player.
 * It receives info, stores, and responds when asked.
 * This AI will be random. "Smarter" AI(s) will be subclasses of this.
 */
public class ComputerActualRandy extends GameComputerPlayer {

    protected GameStateActual myRecentState;//full copy of most recently received Game State for easier access

    public ComputerActualRandy(String name) {
        super(name);
    } //default constructor

    @Override
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

    } //assign value to Recent State and dispatch helper methods

    public ArrayList<Card> selectNextSpell() {

        Random rand = new Random();
        int numCardsInSpell = 1 + rand.nextInt(3);
        //select a random number of 1, 2, or 3 of cards to pick
        //pulled from java doc for inclusive or exclusive question

        ArrayList<Card> spellToSend = new ArrayList<Card>();
        int cardSeletor = 0;
        for (int i = 0; i < numCardsInSpell; i++) {
            cardSeletor = rand.nextInt(8);
            spellToSend.add(myRecentState.playerHands.get(playerNum).get(cardSeletor));
        }
        myRecentState.dealNewHandTo(playerNum);
        return spellToSend;
    } //use Recent State and pick cards

}
