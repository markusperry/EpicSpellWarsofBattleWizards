package scottie.cs301.EpicActuals.Resources.Cards;

import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.SCHOOL;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;

/**
 * Created by zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * This is the highest level super for each CardActual.
 * It contains public variables for easy dot access elsewhere.
 */
public abstract
class Card
    {
        public final int idNum; //number reference and DECK index
        public final int initiative; //gameplay attribute
        public final int placement; //gameplay attribute
        public final int imageRef; //gameplay attribute
        public final SCHOOL schoolType; //gameplay attribute

        protected
        Card(int myID,
             int myInit,
             int myPlace,
             int myImage,
             SCHOOL mySchool) //basic constructor
        {
            idNum = myID;
            initiative = myInit;
            placement = myPlace;
            imageRef = myImage;
            schoolType = mySchool;
        }

        public abstract
        void resolve(GameStateActual currentState, int[] mySpell, int myCasterID); //abstract method to be built in each CardActual
    }
