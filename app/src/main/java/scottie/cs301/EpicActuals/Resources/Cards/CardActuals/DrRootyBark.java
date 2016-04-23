package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * heals the player casting it, all the foes roll and if they roll a 6, they will heal 3
 */
public class DrRootyBark extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected DrRootyBark() {
        super(54, 0, 1, R.drawable.drrootybark, SCHOOL.PRIMAL);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // heal yourself
        heal(myCasterNum, 3, currentState);

        // initialize foe to the left
        int foe = returnLeft(myCasterNum, currentState);

        // cycle through all foes
        while(foe != myCasterNum) {
            // all foes roll and if they roll 6- heals 3 hp
            int roll = rollDie();
            if (roll == 6) {
                heal(foe, 3, currentState);
            }
            foe = returnLeft(foe, currentState);
        }
    }
}
