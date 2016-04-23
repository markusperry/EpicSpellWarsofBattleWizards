package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals 3 damage to the strongest
 */
public class ThaiFoon extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected ThaiFoon() {
        super(10, 0, 1, R.drawable.thaifoon, SCHOOL.ELEMENTAL);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // finds strongest player and deals 3 damage
        int strongest = returnStrongest(currentState);
        damage(strongest,3, currentState);
    }
}
