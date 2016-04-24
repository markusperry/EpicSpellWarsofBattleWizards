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
public class MagmaGog extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public MagmaGog() {
        super(4, 0, 1, R.drawable.magmagog);
    }

    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        int foe = myCasterID--;
        if (foe<0)
        {
            foe=3;
        }

        currentState.damage(3,foe);
    }
}
