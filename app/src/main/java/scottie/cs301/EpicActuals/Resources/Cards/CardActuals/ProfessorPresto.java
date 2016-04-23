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
public class ProfessorPresto extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected ProfessorPresto() {
        super(8, 0, 1, R.drawable.professorpresto, SCHOOL.ARCANE);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // finds a random foe and deals 3 damage
        int numPlayers = returnNumPlayers(currentState);

        Random rand = new Random();
        int foe = rand.nextInt(numPlayers) - 1;

        damage(foe, 3, currentState);
    }
}
