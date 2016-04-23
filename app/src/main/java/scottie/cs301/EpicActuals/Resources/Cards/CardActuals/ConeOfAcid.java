package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals out damage based on die roll to player to the left and his left
 */
public class ConeOfAcid extends CardNode implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    protected ConeOfAcid() {
        super(21, 4, 3, R.drawable.coneofacid, SCHOOL.ARCANE);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] spell, int myCasterNum) {
        // finds the two foes to the left
        int foeL = returnLeft(myCasterNum, currentState);
        int foeR = returnRight(myCasterNum, currentState);

        // rolls die and deals damage based on die roll
        int roll = rollDie() * 2;

        if(roll <= 4) {
            damage(foeL, 1, currentState);
            damage(foeR, 1, currentState);
        }
        else if(roll <= 9) {
            damage(foeL, 2, currentState);
            damage(foeR, 2, currentState);
        }
        else {
            damage(foeL, 4, currentState);
            damage(foeR, 4, currentState);
        }
    }
}
