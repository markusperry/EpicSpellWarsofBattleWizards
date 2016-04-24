package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * rolls a die(s) and deals damage based on the number rolled
 */
public class Bedazzlement extends Card implements Serializable {
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;


    public Bedazzlement() {
        super(16, 19, 3, R.drawable.bedazzlement);
    }


    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        Random gen = new Random();
        int nextFoe = gen.nextInt(4);

        int diceRoll = (gen.nextInt(6)+1)+(gen.nextInt(6)+1);

        if (diceRoll<=4)
        {
            currentState.damage(1,nextFoe);
        }
        else if (diceRoll<=9)
        {
            currentState.damage(3,nextFoe);
        }
        else
        {
            currentState.damage(4,nextFoe);
        }
    }
}
