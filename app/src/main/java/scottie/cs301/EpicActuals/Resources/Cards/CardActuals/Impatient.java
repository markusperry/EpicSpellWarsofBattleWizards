package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals 1 damage to each player
 */
public class Impatient extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public Impatient() {
        super(3, 100, 2, R.drawable.impatient);
    }

    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        currentState.damageAll(1,myCasterID);
    }
}
