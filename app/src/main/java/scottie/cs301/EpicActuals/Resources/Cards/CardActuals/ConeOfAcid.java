package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals out damage based on die roll to player to the left and his left
 */
public class ConeOfAcid extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public ConeOfAcid() {
        super(21, 4, 3, R.drawable.coneofacid);
    }

    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        Random gen = new Random();
        int foe = gen.nextInt(4);

        int roll = (gen.nextInt(6)+1)+(gen.nextInt(6)+1);

        if (roll<=4)
        {
            currentState.damage(1,foe);
        }

        else if (roll<=9)
        {
            currentState.damage(2,foe);
        }

        else
        {
            currentState.damage(4,foe);
        }
    }
}
