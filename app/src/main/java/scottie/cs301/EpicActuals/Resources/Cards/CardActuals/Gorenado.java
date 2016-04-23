package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals damage to strongest player based die roll
 */
public class Gorenado extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected Gorenado() {
        super(28, 2, 3, R.drawable.gorenado, SCHOOL.PRIMAL);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // finds strongest player, rolls die, and deals damage accordingly
        int foe = returnStrongest(currentState);

        int roll = rollDie() * 2;

        if(roll <= 4) {
            damage(foe, 2, currentState);
        }
        else if(roll <= 9) {
            damage(foe, 3, currentState);
        }
        else {
            damage(foe,6, currentState);
        }
    }
}
