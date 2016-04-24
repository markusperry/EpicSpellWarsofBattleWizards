package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * heals caster by 2. if caster is the weakest player, he heals additional 1 health point
 */
public class MightyGro extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public MightyGro() {
        super(57, 0, 2, R.drawable.mightygro);
    }

    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        int weakest = 0;
        int foeID = 0;
        for (int i = 0; i < currentState.playerHealths.length; i++)
        {
            if (currentState.playerHealths[i]<=weakest)
            {
                weakest = currentState.playerHealths[i];
                foeID = i;
            }
        }

        currentState.playerHealths[myCasterID] +=2;
        if (foeID==myCasterID)
        {
            currentState.playerHealths[myCasterID]+=1;
        }
    }
}
