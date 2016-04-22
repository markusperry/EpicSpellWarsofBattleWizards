package scottie.cs301.EpicActuals.Resources.Actions;

import scottie.cs301.Imports.GameFramework.GamePlayer;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * A catch-all action that produces a single CHOICE response.
 * Should be passed as a result of an ask from Local/ State.
 */
public
class SendChoice extends ActionAbstract
    {
        public final CHOICE theChoice; //the choice being sent

        public
        SendChoice(GamePlayer player,
                   CHOICE myChoice) //basic constructor
        {
            super(player, ACTION.Choice);
            theChoice = myChoice;
        }
    }
