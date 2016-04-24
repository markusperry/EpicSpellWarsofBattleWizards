package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals damage to foe based on die roll
 */
public class Devilicious extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public Devilicious() {
        super(23, 0, 2, R.drawable.devilicious);
    }


    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        Random gen = new Random();
        int foe = gen.nextInt(4);

        int roll = (gen.nextInt(6)+1)+(gen.nextInt(6)+1);

        if (roll<=4)
        {
            currentState.damage(2,foe);
        }

        else if (roll<=9)
        {
            currentState.damage(4,foe);
            currentState.damage(1,myCasterID);
        }

        else
        {
            currentState.damage(5,foe);
            currentState.damage(2,myCasterID);
        }
    }
}
