package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals out damage to each foe based on number rolled on die
 */
public class BenVoodoo extends Card implements Serializable {
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public BenVoodoo() {
        super(17, 0, 1, R.drawable.benvoodoo);
    }

    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        Random gen = new Random();
        int damageRoll = gen.nextInt(6)+1;

        currentState.damageAll(damageRoll, myCasterID);

    }
}
