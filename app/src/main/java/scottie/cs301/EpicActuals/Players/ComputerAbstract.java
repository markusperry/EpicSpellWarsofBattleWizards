package scottie.cs301.EpicActuals.Players;

import scottie.cs301.Imports.GameFramework.GameComputerPlayer;

/**
 * Created by zimmerms18 on 4/11/2016.
 */
public abstract
class ComputerAbstract
        extends GameComputerPlayer
    {
        public
        ComputerAbstract(String name)
            {
                super(name);
            }
        public
        int id()
            {
                return playerNum;
            }
    }
