package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals 3 damage to player to the left
 */
public class MagmaGog extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected MagmaGog() {
        super(4, 0, 1, R.drawable.magmagog, SCHOOL.ELEMENTAL);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // deals 3 damage to player on left
        int left = returnLeft(myCasterNum, currentState);
        damage(left, 3, currentState);

    }
}
