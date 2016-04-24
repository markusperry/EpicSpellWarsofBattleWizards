package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals a random foe 3 damage
 */
public class ProfessorPresto extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public ProfessorPresto() {
        super(8, 0, 1, R.drawable.professorpresto);
    }

    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        Random gen = new Random();
        int foe = gen.nextInt(currentState.playerHealths.length);

        currentState.damage(3,foe);
    }
}
