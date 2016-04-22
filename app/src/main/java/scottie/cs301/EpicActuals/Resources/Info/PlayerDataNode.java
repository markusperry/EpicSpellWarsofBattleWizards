package scottie.cs301.EpicActuals.Resources.Info;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * This is just a data container. Passed inside of the GameStateActual.
 * New node built for each update.
 */
public
class PlayerDataNode
    {
        public final int ID;
        public final String Name;
        public final int PictureInt;

        public
        PlayerDataNode(int myID,
                       String myName,
                       int myPic) //basic constructor
        {
            ID = myID;
            Name = myName;
            PictureInt = myPic;
        }
    }
