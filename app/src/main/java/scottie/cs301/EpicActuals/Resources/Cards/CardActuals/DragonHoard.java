package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals damage to weakest player based on die roll
 */
public class DragonHoard extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected DragonHoard() {
        super(24, 6, 3, R.drawable.dragonhoard, SCHOOL.ARCANE);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // finds the weakest foe, rolls die, and deals damage accordingy
        int foe = returnWeakest(currentState);

        int roll = rollDie() * 2;

        if(roll <= 4) {
            damage(foe, 1, currentState);
        }
        else if(roll <= 9) {
            damage(foe, 2, currentState);
        }
        else {
            damage(foe,3, currentState);
        }
    }
}
