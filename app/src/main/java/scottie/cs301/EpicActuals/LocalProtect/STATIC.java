package scottie.cs301.EpicActuals.LocalProtect;

import scottie.cs301.EpicActuals.Players.ComputerAbstract;
import scottie.cs301.EpicActuals.Players.HumanAbstract;
import scottie.cs301.EpicActuals.Resources.Actions.ActionAbstract;
import scottie.cs301.EpicActuals.Resources.Actions.SendChoice;
import scottie.cs301.EpicActuals.Resources.Actions.SendOverride;
import scottie.cs301.EpicActuals.Resources.Actions.SendSpell;
import scottie.cs301.EpicActuals.Resources.Info.LOCATION;
import scottie.cs301.Imports.GameFramework.GamePlayer;
import scottie.cs301.Imports.GameFramework.actionMsg.GameAction;

/**
 * Created by zimmerms18 on 4/11/2016.
 */
public class STATIC {
    public static int idOf(GamePlayer player) {
        if (player instanceof HumanAbstract) {
            return ((HumanAbstract) player).id();
        }
        if (player instanceof ComputerAbstract) {
            return ((ComputerAbstract) player).id();
        }
        return -1;
    }

    public static LOCATION locOf(GamePlayer player,
                                 LOCATION search) {
        int shift = -100; //force crash if value not valid
        if (search == LOCATION.Hand) {
            shift = 0;
        }
        if (search == LOCATION.Spell) {
            shift = 1;
        }
        if (search == LOCATION.Treasure) {
            shift = 2;
        }
        return LOCATION.values()[STATIC.idOf(player) * 3 + shift];
    }

    public static LOCATION locOf(int player,
                                 LOCATION search) {
        int shift = -100; //force crash if value not valid
        if (search == LOCATION.Hand) {
            shift = 0;
        }
        if (search == LOCATION.Spell) {
            shift = 1;
        }
        if (search == LOCATION.Treasure) {
            shift = 2;
        }
        return LOCATION.values()[player * 3 + shift];
    }

    protected static boolean convertSendMake(GameAction action) {
        GameAction myAction = action;
        if (action instanceof ActionAbstract) {
            switch (((ActionAbstract) action).actionID) {
                case Choice: {
                    SendChoice forReturn = (SendChoice) action;
                    return LocalGameActual.theGame.makeMove(forReturn);
                }
                case Override: {
                    SendOverride forReturn = (SendOverride) action;
                    return LocalGameActual.theGame.makeMove(forReturn);
                }
                case Spell: {
                    SendSpell forReturn = (SendSpell) action;
                    return LocalGameActual.theGame.makeMove(forReturn);
                }
            }
        }
        return false;
    }

    public static int returnLeft(int player) {
        int numPlayers = LocalGameActual.theGame.masterState.playerHealths.length;

        if (player == 0) {
            return numPlayers - 1;
        }
        return player - 1;
    }

}