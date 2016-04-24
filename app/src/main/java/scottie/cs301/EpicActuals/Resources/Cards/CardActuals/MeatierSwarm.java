package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals damage based on dice roll to strongest player
 */
public class MeatierSwarm extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public MeatierSwarm() {
        super(30, 20, 3, R.drawable.meatierswarm);
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

        Random gen = new Random();

        int roll = (gen.nextInt(6)+1)+(gen.nextInt(6)+1);

        if (roll<=4)
        {
            currentState.damage(1,foeID);
        }

        else if (roll<=9)
        {
            currentState.damage(3,foeID);
        }

        else
        {
            currentState.damage(4,foeID);
        }
    }
}
