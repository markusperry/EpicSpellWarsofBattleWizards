package scottie.cs301.EpicActuals.Players;

import scottie.cs301.Imports.GameFramework.GameHumanPlayer;

/**
 * Created by zimmerms18 on 4/11/2016.
 */
public abstract
class HumanAbstract extends GameHumanPlayer
    {
        public
        HumanAbstract(String name)
            {
                super(name);
            }
        public
        int id()
            {
                return playerNum;
            }
    }
