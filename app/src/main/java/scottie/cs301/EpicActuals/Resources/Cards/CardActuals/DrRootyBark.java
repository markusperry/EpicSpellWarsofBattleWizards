package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * heals the player casting it, all the foes roll and if they roll a 6, they will heal 3
 */
public class DrRootyBark extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public DrRootyBark() {
        super(54, 0, 1, R.drawable.drrootybark);
    }


    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        currentState.playerHealths[myCasterID] +=3;

        Random gen = new Random();
        int roll = 0;

        for (int i = 0; i < currentState.playerHealths.length; i++)
        {
            roll = gen.nextInt(6)+1;
            if (roll==6)
            {
                currentState.playerHealths[i] +=3;
            }
        }

    }
}
