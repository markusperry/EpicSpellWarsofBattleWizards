package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.LocalProtect.LocalGameActual;
import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals 2 damage to a foe. If that foe dies, deal 2 damage to another foe, and so on
 */
public class TheDeathFairy extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected TheDeathFairy() {
        super(11, 0, 1, R.drawable.thedeathfairy, SCHOOL.DARK);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // chooses a foe and deals 2 damage
        int foe = chooseFoe(myCasterNum, currentState);

        damage(foe, 2, currentState);

        // if that foe dies, repeat
        if (currentState.playerHealths[foe] <= 0) {
            foe = chooseFoe(myCasterNum, currentState);
            damage(foe, 2, currentState);
        }
    }
}
