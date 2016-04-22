package scottie.cs301.EpicActuals.Resources.Actions;

import scottie.cs301.Imports.GameFramework.GamePlayer;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * Similar to SendChoice, but for actions that are not internal gameplay. (Quit, Save, etc.)
 */
public
class SendOverride extends ActionAbstract
    {
        public final OVRD theOVRDAction; //the menu choice being sent

        public
        SendOverride(GamePlayer player,
                     OVRD myOVRDSelection) //basic constructor
        {
            super(player, ACTION.Override);
            theOVRDAction = myOVRDSelection;
        }
    }
