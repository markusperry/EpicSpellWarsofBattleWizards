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
public class ThaiFoon extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public ThaiFoon() {
        super(10, 0, 1, R.drawable.thaifoon);
    }

    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        int strongest = 0;
        int foeID = 0;
        for (int i = 0; i < currentState.playerHealths.length; i++)
        {
            if (currentState.playerHealths[i]>=strongest)
            {
                strongest = currentState.playerHealths[i];
                foeID = i;
            }
        }

        currentState.damage(3,foeID);
    }
}
