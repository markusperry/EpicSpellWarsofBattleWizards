package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals damage to strongest player equal to number of players left alive
 */
public class MidnightMerlin extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public MidnightMerlin() {
        super(5, 0, 1, R.drawable.midnightmerlin);
    }

    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        int strongest = 0;
        int foeID = 0;
        int numAlive= 0;
        for (int i = 0; i < currentState.playerHealths.length; i++)
        {
            if (currentState.playerHealths[i]>=strongest)
            {
                strongest = currentState.playerHealths[i];
                foeID = i;
            }
            if (currentState.playerHealths[i]>0)
            {
                numAlive++;
            }
        }

        Random gen = new Random();

        int roll = (gen.nextInt(6)+1)+(gen.nextInt(6)+1);

        if (roll<=4)
        {
            currentState.damage(2*numAlive,foeID);
        }

        else if (roll<=9)
        {
            currentState.damage(3*numAlive,foeID);
        }

        else
        {
            currentState.damage(4*numAlive,foeID);
        }
    }
}
