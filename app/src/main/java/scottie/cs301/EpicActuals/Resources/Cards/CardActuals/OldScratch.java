package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * rolls die and either heals or damages caster accordinly
 */
public class OldScratch extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected OldScratch() {
        super(13, 0, 1, R.drawable.oldscratch, SCHOOL.DARK);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // rolls the die and heals or damage the caster
        int roll = rollDie();

        if(roll <= 3) {
            damage(myCasterNum, roll, currentState);
        }
        else {
            heal(myCasterNum, roll, currentState);
        }
    }
}
