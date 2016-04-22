package scottie.cs301.EpicActuals.Players;

import java.util.Random;

import scottie.cs301.EpicActuals.LocalProtect.STATIC;
import scottie.cs301.EpicActuals.Resources.Actions.CHOICE;
import scottie.cs301.EpicActuals.Resources.Actions.SendSpell;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.EpicActuals.Resources.Info.LOCATION;
import scottie.cs301.EpicActuals.Resources.Info.STAGE;
import scottie.cs301.Imports.GameFramework.infoMsg.GameInfo;

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
public class ComputerActualRandy
        extends ComputerAbstract {

    protected GameStateActual myRecentState;//full copy of most recently received Game State for easier access
    protected boolean playedCardsAlready =false;

    public ComputerActualRandy(String name) {
        super(name);
    } //default constructor

    public void forceId(int id) {
        playerNum = id;
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof GameStateActual) //only react if info is a full state
        {
            myRecentState = (GameStateActual) info; //cast it and store
            if (myRecentState != null) {
                if (myRecentState.playerStages[playerNum] == STAGE.SelectingCards) //val 1 = time to pick cards
                {
                    if (!playedCardsAlready) {
                        this.game.sendAction(new SendSpell(this,
                                selectNextSpell()));
                        playedCardsAlready=true;
                    }
                }
                if(myRecentState.playerStages[playerNum] == STAGE.DoneCasting)
                {
                    playedCardsAlready=false;
                }
            }
        }

    } //assign value to Recent State and dispatch helper methods

    public int[] selectNextSpell() {


        Random rand = new Random();
        int numCardsInSpell = 1 + rand.nextInt(3);
        //select a random number of 1, 2, or 3 of cards to pick
        //pulled from java doc for inclusive or exclusive question

        int[] spell = new int[numCardsInSpell];

        for (int i = 0; i < numCardsInSpell; i++) {
            spell[i] = myRecentState.randomCardFrom(STATIC.locOf(this, LOCATION.Hand), myRecentState.spellCardLocation);
            //first card = go to game state, get random card from my hand

            myRecentState.spellCardLocation[spell[i]] = LOCATION.DiscardPile;
            //tell (my) game state which card was pulled
        }

        return spell;
    } //use Recent State and pick cards

    public CHOICE respondToQuestion(CHOICE[] validAnswers) {
        Random rand = new Random();
        return validAnswers[rand.nextInt(validAnswers.length)]; //pick a random return from the given
    } //contextual response
}
