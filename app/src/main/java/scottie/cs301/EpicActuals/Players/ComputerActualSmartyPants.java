package scottie.cs301.EpicActuals.Players;

import scottie.cs301.EpicActuals.Resources.Actions.CHOICE;
import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.SCHOOL;
import scottie.cs301.EpicActuals.Resources.Cards.Deck;
import scottie.cs301.EpicActuals.Resources.Info.LOCATION;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * This is the smarter AI.
 * Uses all functionality of its super, but overrides decision making methods.
 */
public
class ComputerActualSmartyPants
        extends ComputerActualRandy
    {
        public
        ComputerActualSmartyPants(String name)
            {
                super(name);
            } //default constructor

        @Override
        public
        int[] selectNextSpell()
            {
                int[] spell = new int[3]; // array to hold card IDs
                int maxInitiative = 0;
                Card[] hand = Deck.theDeck;
                //myRecentState.allCardsFrom(STATIC.locOf(playerNum, LOCATION.Hand), LOCATION.);

                // finds and selects card with highest initiative
                for(int i = 0; i < hand.length; i++) {
                    if(hand[i].placement == 3) {
                        if(hand[i].initiative > maxInitiative) {
                            spell[2] = hand[i].idNum;
                        }
                    }
                }

                SCHOOL glyph = hand[maxInitiative].schoolType;// glyph of card with max initiative

                // finds and selects source and quality cards with same glyph as initiative
                for(int i = 0; i < hand.length; i++) {
                    if(hand[i].placement == 1) {
                        if(hand[i].schoolType == glyph) {
                            spell[0] = hand[i].idNum;
                        }
                    }
                }

                for(int i = 0; i < hand.length; i++) {
                    if(hand[i].placement == 2) {
                        if(hand[i].schoolType == glyph) {
                            spell[1] = hand[i].idNum;
                        }
                    }
                }

                return spell;
            } //override the random method from super with smart choices

        @Override
        public
        CHOICE respondToQuestion(CHOICE[] validAnswers)
            {
                return null;
            } //override the random method from super with smart choices
    }
