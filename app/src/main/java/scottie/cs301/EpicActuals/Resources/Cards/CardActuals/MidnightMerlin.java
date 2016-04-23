package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals damage to strongest player equal to number of players left alive
 */
public class MidnightMerlin extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected MidnightMerlin() {
        super(5, 0, 1, R.drawable.midnightmerlin, SCHOOL.DARK);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // finds number of players left alive and deals equal damage to strongest player
        int strongest = returnStrongest(currentState);
        int alive = returnAlive(currentState);

        damage(strongest, alive, currentState);

    }
}
