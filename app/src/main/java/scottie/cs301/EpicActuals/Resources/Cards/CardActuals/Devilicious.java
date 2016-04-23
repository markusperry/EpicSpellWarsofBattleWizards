package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals damage to foe based on die roll
 */
public class Devilicious extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected Devilicious() {
        super(23, 0, 2, R.drawable.devilicious, SCHOOL.DARK);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // chooses foe, rolls die, and deals damage based on die(s) roll
        int foe = chooseFoe(myCasterNum, currentState);

        int roll = rollDie() * 2;

        if(roll <= 4) {
            damage(foe, 2, currentState);
        }
        else if(roll <= 9) {
            damage(foe, 4, currentState);
            damage(myCasterNum, 1, currentState);
        }
        else {
            damage(foe,5, currentState);
            damage(myCasterNum, 2, currentState);
        }
    }
}
