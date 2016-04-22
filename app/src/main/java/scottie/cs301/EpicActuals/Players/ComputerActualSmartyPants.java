package scottie.cs301.EpicActuals.Players;

import scottie.cs301.EpicActuals.Resources.Actions.CHOICE;
import scottie.cs301.EpicActuals.Resources.Info.LOCATION;

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
        public
        int[] selectNextSpell()
            {
                return null;
            } //override the random method from super with smart choices

        @Override
        public
        CHOICE respondToQuestion(CHOICE[] validAnswers)
            {
                return null;
            } //override the random method from super with smart choices
    }
