package scottie.cs301.EpicActuals.Resources.Actions;

import java.util.ArrayList;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.Imports.GameFramework.GamePlayer;
import scottie.cs301.Imports.GameFramework.actionMsg.GameAction;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * The main player action.
 * Sending three cards as int indices that refer to the DECK element.
 */
public class SendSpell extends GameAction{
    public ArrayList<Card> theSpell; //the three cards being sent

    public SendSpell(GamePlayer player, ArrayList<Card> inComingSpell) //basic constructor
    {
        super(player);
        theSpell = inComingSpell;
    }
}
