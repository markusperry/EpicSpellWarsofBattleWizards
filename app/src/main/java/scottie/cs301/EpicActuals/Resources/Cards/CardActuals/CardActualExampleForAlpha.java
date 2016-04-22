package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import scottie.cs301.EpicActuals.LocalProtect.STATIC;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by zimmerms18 on 4/12/2016.
 */
public class CardActualExampleForAlpha extends CardNode {


    public CardActualExampleForAlpha(int myID, int myInit, int myPlace, int myImage, SCHOOL mySchool) {
        super(myID, myInit, myPlace, myImage, mySchool);
    }

    @Override
    public void resolve(GameStateActual currentState, int[] mySpell, int myCasterID) {
        currentState.damage(STATIC.returnLeft(myCasterID) , initiative);
    }
}
