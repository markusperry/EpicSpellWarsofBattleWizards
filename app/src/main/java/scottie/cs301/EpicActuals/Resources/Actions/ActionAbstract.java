package scottie.cs301.EpicActuals.Resources.Actions;

import scottie.cs301.EpicActuals.LocalProtect.STATIC;
import scottie.cs301.Imports.GameFramework.GamePlayer;
import scottie.cs301.Imports.GameFramework.actionMsg.GameAction;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * This is a middle management layer to insert an additional method.
 * To return an int ID for the player rather than a GamePlayer object.
 */
public abstract
class ActionAbstract extends GameAction
    {
        public final int playerID;
        public final ACTION actionID;
        public
        ActionAbstract(GamePlayer player, ACTION action)
            {
                super(player);
                playerID = STATIC.idOf(player);
                actionID = action;
            }
    }
