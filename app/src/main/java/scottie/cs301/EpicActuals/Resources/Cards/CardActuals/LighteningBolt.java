package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals damage to two left foes based on a dice roll
 */
public class LighteningBolt extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected LighteningBolt() {
        super(29, 9, 3, R.drawable.lightningbolt, SCHOOL.ELEMENTAL);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // finds two foes to the left
        int foeL = returnLeft(myCasterNum, currentState);
        int foeLL = returnLeft(foeL, currentState);

        // rolls dice and deals damage accordingly
        int roll = rollDie() * 2;

        if(roll <= 4) {
            damage(foeL, 1, currentState);
            damage(foeLL, 1, currentState);
        }
        else if(roll <= 9) {
            damage(foeL, 2, currentState);
            damage(foeLL, 2, currentState);
        }
        else {
            damage(foeL,4, currentState);
            damage(foeLL, 4,currentState);
        }
    }
}
