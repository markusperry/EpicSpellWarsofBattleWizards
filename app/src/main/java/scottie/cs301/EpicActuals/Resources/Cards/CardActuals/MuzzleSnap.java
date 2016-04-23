package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals damage to strongest foe based on die roll
 */
public class MuzzleSnap extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected MuzzleSnap() {
        super(14, 0, 1, R.drawable.muzzlesnaps, SCHOOL.PRIMAL);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // finds the strongest player and rolls the die
        int roll = rollDie() * 2;
        int foe = returnStrongest(currentState);

        // adds addtional dice roll and deals damage accordingly
        roll = roll + rollDie();

        if (roll <= 4) {
            damage(foe, 2, currentState);
        }
        else if (roll <= 9) {
            damage(foe, 4, currentState);
        }
        else {
            damage(foe, 7, currentState);
        }


    }
}
