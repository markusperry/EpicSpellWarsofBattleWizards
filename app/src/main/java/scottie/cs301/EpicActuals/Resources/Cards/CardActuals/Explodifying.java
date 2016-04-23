package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * chooses a foe and deals damage based on die roll
 */
public class Explodifying extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected Explodifying() {
        super(26, 0, 2, R.drawable.explodifying, SCHOOL.ELEMENTAL);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // chooses foe, rolls die, and deals damage accordingly
        int foe = chooseFoe(myCasterNum, currentState);

        int roll = rollDie() * 2;

        if(roll <= 4) {
            damage(foe, 1, currentState);
        }
        else if(roll <= 9) {
            damage(foe, 3, currentState);
            damage(myCasterNum, 1, currentState);
        }
        else {
            damage(foe,4, currentState);
        }
    }
}
