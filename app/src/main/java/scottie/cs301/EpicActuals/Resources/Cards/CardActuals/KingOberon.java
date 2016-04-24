package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * heals caster 2 points
 */
public class KingOberon extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public KingOberon() {
        super(56, 0, 1, R.drawable.kingoberon);
    }

    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        currentState.playerHealths[myCasterID] +=2;
    }
}
