package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals out damage to foe on right based on die roll
 */
public class DeathWish extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected DeathWish() {
        super(22, 8, 3, R.drawable.deathwish, SCHOOL.DARK);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // finds foe to the right and deals damage based on die roll
        int foe = returnRight(myCasterNum, currentState);

        int roll = rollDie();

        if(roll <= 4) {
            damage(foe, 2, currentState);
            damage(myCasterNum, 1, currentState);
        }
        else if(roll <= 9) {
            damage(foe, 3, currentState);
            damage(myCasterNum, 1, currentState);
        }
        else {
            damage(foe,5, currentState);
            damage(myCasterNum, 1, currentState);
        }
    }
}
