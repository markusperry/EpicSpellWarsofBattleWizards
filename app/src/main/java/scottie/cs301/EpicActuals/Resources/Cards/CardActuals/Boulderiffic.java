package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals out damage to each player based on how far away from the current player they are going counterclockwise
 */
public class Boulderiffic extends CardNode implements Serializable {
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected Boulderiffic() {
        super(2, 0, 2, R.drawable.boulderiffic, SCHOOL.PRIMAL);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // finds player to left and initializes count
        int count = 0;
        int curPlayer = returnLeft(myCasterNum, currentState);

        // deals out damage to players in the circuit based on the number of spaces away from the current player they are
       while (curPlayer != myCasterNum) {
           curPlayer = returnLeft(curPlayer, currentState);
           count++;

           damage(curPlayer, count, currentState);
       }
    }
}
