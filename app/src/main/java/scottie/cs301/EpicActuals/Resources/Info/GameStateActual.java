package scottie.cs301.EpicActuals.Resources.Info;

import android.util.Log;

import java.util.Random;

import scottie.cs301.EpicActuals.LocalProtect.STATIC;
import scottie.cs301.EpicActuals.Resources.Actions.CHOICE;
import scottie.cs301.EpicActuals.Resources.Cards.Deck;
import scottie.cs301.Imports.GameFramework.infoMsg.GameState;

import static java.util.Arrays.copyOf;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * GameState subclass that contains all of current game information.
 * Basic methods provided, although most action taken in LocalGameActual.
 */
public class GameStateActual extends GameState {
    public int[] playerHealths;
    public LOCATION[] spellCardLocation;
    public STAGE curStage;
    public STAGE[] playerStages;
    public int[] focusedCards;
    public int focusedPlayer;
    public CHOICE[] curChoices;

    private void init(int numPlayers) {
        playerHealths = new int[numPlayers];
        spellCardLocation = new LOCATION[Deck.theDeck.length];
        playerStages = new STAGE[numPlayers];
        focusedCards = new int[]{0, 0, 0};
        curChoices = new CHOICE[]{CHOICE.Debug};
        curStage = STAGE.SelectingCards;
    }

    public GameStateActual(int numPlayers) {
        init(numPlayers);
        //or (LOCATION in : spellCardLocation) {
        //    in = LOCATION.DrawPile;
        //}
        for (int itter = 0; itter < Deck.theDeck.length; itter++) {
            spellCardLocation[itter] = LOCATION.DrawPile;
        }

        for(int itter = 0; itter < numPlayers; itter++)
        {
            playerHealths[itter] = 25;
        }
        curStage = STAGE.SelectingCards;

        for (int itter3 = 0; itter3 < numPlayers; itter3++) {
            playerStages[itter3] = STAGE.SelectingCards;
        }

        for (int pItter = 0; pItter < numPlayers; pItter++)
            for (int cItter = 0; cItter < 8; cItter++) {
                spellCardLocation[randomCardFrom(LOCATION.DrawPile, spellCardLocation)] = STATIC.locOf(pItter, LOCATION.Hand);
            }
        int debugMark = 0;
    } //starting constructor

    public GameStateActual(int PlayerNum,
                           GameStateActual masterState) {
        playerHealths = masterState.playerHealths.clone();
        spellCardLocation = masterState.spellCardLocation.clone(); //full copy currently. will need to limit.
        playerStages = masterState.playerStages.clone();
        focusedCards = masterState.focusedCards.clone();
        focusedPlayer = masterState.focusedPlayer;
        curChoices = masterState.curChoices.clone();

    }

    public void shuffle(LOCATION[] thisDeck) {
        for (LOCATION in : thisDeck) {
            if (in == LOCATION.DiscardPile) {
                in = LOCATION.DrawPile;
            }
        }
    }

    public void addSpell(int PlayerNum, int[] spell) {
        for (int in : spell) {
            if (spellCardLocation[in] == STATIC.locOf(PlayerNum, LOCATION.Hand)) {
                spellCardLocation[in] = STATIC.locOf(PlayerNum,
                        LOCATION.Spell);
            }
        }
    }

    public int[] allCardsFrom(LOCATION startLoc, LOCATION[] thisDeck) {
        int slider = 0;
        int[] forBuffer = new int[thisDeck.length];
        for (int itter = 1; itter < thisDeck.length; itter++) {
            if (thisDeck[itter] == startLoc) {
                forBuffer[slider] = itter;
                slider++;
            }
        }
        int[] forReturn;
        forReturn = copyOf(forBuffer, slider);
        return forReturn;


    }

    public int randomCardFrom(LOCATION startLoc, LOCATION[] thisDeck) {
        int[] forBuffer = allCardsFrom(startLoc, thisDeck);
        Log.i("", "" + forBuffer.toString());
        Random RRR = new Random();
        return forBuffer[RRR.nextInt(forBuffer.length)];
    }

    public
    void damage(int player, int damageVal)
    {
        playerHealths[player] -= damageVal;
    }

    public void deal(int player)
    {
        if(allCardsFrom(LOCATION.DrawPile, spellCardLocation).length < 9)
        {
            this.shuffle(spellCardLocation);
            this.deal(player);
        }

        int handSize = allCardsFrom(STATIC.locOf(player, LOCATION.Hand), spellCardLocation).length;
        while (handSize < 9) {
            spellCardLocation[randomCardFrom(LOCATION.DrawPile, spellCardLocation)] = STATIC.locOf(player, LOCATION.Hand);
            handSize = allCardsFrom(STATIC.locOf(player, LOCATION.Hand), spellCardLocation).length;
        }

    }
}
