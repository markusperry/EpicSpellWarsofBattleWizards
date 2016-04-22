package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import android.util.Log;

import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * This is an example class. There will be 52 subclasses of CardNode.
 * Each contains its initial values and its resolve method.
 */
public
class Placeholder extends CardNode
    {
        public Placeholder()
            {
                super(0,
                      0,
                      200,
                        R.drawable.cardback,
                      null);
            } //basic constructor. values hardcoded per subclass

        @Override
        public
        void resolve(GameStateActual currentState, int[] mySpell, int myCasterID)
            {
                Log.i("resolve", "called on empty slot by player #" + myCasterID);
            } //the reason for a mess of subclasses. each card unique method.
    }
