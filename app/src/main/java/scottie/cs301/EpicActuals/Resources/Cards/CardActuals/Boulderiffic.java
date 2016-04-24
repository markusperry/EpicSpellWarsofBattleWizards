package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.ArrayList;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals out damage to each player based on how far away from the current player they are going counterclockwise
 */
public class Boulderiffic extends Card implements Serializable {
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public Boulderiffic() {
        super(2, 0, 2, R.drawable.boulderiffic);
    }


    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        ArrayList<Integer> players = new ArrayList<Integer>();
        players.add(0);
        players.add(1);
        players.add(2);
        players.add(3);
        players.remove(myCasterID);

        for (int i = 1; i <=3; i++)
        {
            currentState.damageMultiple(1*i,players);
        }
    }
}
