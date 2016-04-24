package scottie.cs301.EpicActuals.Players;

import java.util.ArrayList;

import scottie.cs301.EpicActuals.Resources.Cards.Card;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * This is the smarter AI.
 * Uses all functionality of its super, but overrides decision making methods.
 */
public
class ComputerActualSmartyPants
        extends ComputerActualRandy
    {
        public
        ComputerActualSmartyPants(String name)
            {
                super(name);
            } //default constructor

        @Override
        public ArrayList<Card> selectNextSpell()
        {
            return null;
        }
    }
