package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals 3 damage to a random foe
 */
public class MindAltering extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected MindAltering() {
        super(6, 0, 2, R.drawable.mindaltering, SCHOOL.ILLUSION);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // finds number of players and deals 3 damage to random one
        int numPlayers = returnNumPlayers(currentState);

        Random rand = new Random();
        int foe = rand.nextInt(numPlayers) - 1;

        damage(foe, 3, currentState);

    }
}
