package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * This card heals the current player by 5 health points
 */
public class Ballsy extends CardNode implements Serializable{

    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected Ballsy() {
        super(1, 0, 2, R.drawable.ballsy, SCHOOL.ILLUSION);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // heal myself 5 points
        heal(myCasterNum, 5, currentState);
    }
}
