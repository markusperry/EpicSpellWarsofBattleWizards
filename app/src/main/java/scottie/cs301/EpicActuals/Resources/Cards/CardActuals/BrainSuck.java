package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals out damage to player based on die roll
 */
public class BrainSuck extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected BrainSuck() {
        super(18, 15, 3, R.drawable.brainsuck, SCHOOL.ILLUSION);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        int foe = chooseFoe(myCasterNum, currentState);

        int roll = rollDie() * 2;

        if (roll <= 4) {
            damage(foe, 1, currentState);
        }
        else if (roll <= 9) {
            damage(foe, 3, currentState);
        }
        else {
            damage(foe, 4, currentState);
        }
    }
}
