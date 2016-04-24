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
public class Ballsy extends Card implements Serializable{

    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public Ballsy() {
        super(1, 0, 2, R.drawable.ballsy);
    }


    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        //heal 5 points of damage
        currentState.playerHealths[myCasterID] +=5;
    }
}
