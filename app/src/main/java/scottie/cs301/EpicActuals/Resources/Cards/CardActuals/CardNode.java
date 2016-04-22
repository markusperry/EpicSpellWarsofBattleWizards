package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import scottie.cs301.EpicActuals.Resources.Cards.Card;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * This is a middleman layer object.
 * Common methods or effort saving methods may be added here.
 */
public abstract
class CardNode extends Card
    {
        protected
        CardNode(int myID,
                 int myInit,
                 int myPlace,
                 int myImage,
                 SCHOOL mySchool)
            {
                super(myID,
                      myInit,
                      myPlace,
                      myImage,
                      mySchool);
            } //Move along; move along.

    }
