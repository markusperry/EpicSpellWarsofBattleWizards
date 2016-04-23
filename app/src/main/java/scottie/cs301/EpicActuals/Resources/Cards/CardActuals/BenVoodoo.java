package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals out damage to each foe based on number rolled on die
 */
public class BenVoodoo extends CardNode implements Serializable {
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected BenVoodoo() {
        super(17, 0, 1, R.drawable.benvoodoo, SCHOOL.DARK);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        //finds foe to the left of current player
        int foe = returnLeft(myCasterNum, currentState);
        int roll;

        // deals out damage to each foe based on the number rolled
        while(foe != myCasterNum) {
            foe = returnLeft(foe,currentState);
            roll = rollDie();
            damage(foe, roll, currentState);

        }
    }
}
