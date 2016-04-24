package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals damage to foe on left based on die roll
 */
public class FistONature extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public FistONature() {
        super(27, 14, 3, R.drawable.fistonature);
    }

    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        Random gen = new Random();

        int foe = gen.nextInt(currentState.playerHealths.length);

        int roll = (gen.nextInt(6)+1)+(gen.nextInt(6)+1);

        if (roll<=4)
        {
            currentState.damage(4,foe);
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
