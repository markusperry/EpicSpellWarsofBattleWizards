package scottie.cs301.EpicActuals.Resources.Cards;

import java.util.ArrayList;

import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.Ballsy;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.Bedazzlement;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.BenVoodoo;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.Boulderiffic;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.BrainSuck;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.Chicken;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.ConeOfAcid;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.DeathWish;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.Devilicious;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.DrRootyBark;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.DragonHoard;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.Explodifying;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.FistONature;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.Gorenado;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.Impatient;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.KingOberon;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.LighteningBolt;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.MagmaGog;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.MeatierSwarm;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.MercyKilling;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.MidnightMerlin;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.MightyGro;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.MindAltering;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.MuzzleSnap;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.OldScratch;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.ProfessorPresto;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.Scorchia;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.ThaiFoon;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.TheDeathFairy;
import scottie.cs301.EpicActuals.Resources.Cards.CardActuals.TwoFaced;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * Deck object as a simple container for Card objects.
 * Done so that LocalGameActual can have a static final array of cards.
 * So a card may be accessed by LocalGameActual.DECK.theDeck[cardID].
 */
public class Deck
{
    public static final ArrayList<Card> theDeck = new ArrayList<Card>();

    public Deck() {
        //myID, myInit, myPlace, myImage
        theDeck.add(new Ballsy());
        theDeck.add(new Bedazzlement());
        theDeck.add(new BenVoodoo());
        theDeck.add(new Boulderiffic());
        theDeck.add(new BrainSuck());
        theDeck.add(new Chicken());
        theDeck.add(new ConeOfAcid());
        theDeck.add(new DeathWish());
        theDeck.add(new Devilicious());
        theDeck.add(new DragonHoard());
        theDeck.add(new DrRootyBark());
        theDeck.add(new Explodifying());
        theDeck.add(new FistONature());
        theDeck.add(new Gorenado());
        theDeck.add(new Impatient());
        theDeck.add(new KingOberon());
        theDeck.add(new LighteningBolt());
        theDeck.add(new MagmaGog());
        theDeck.add(new MeatierSwarm());
        theDeck.add(new MercyKilling());
        theDeck.add(new MidnightMerlin());
        theDeck.add(new MightyGro());
        theDeck.add(new MindAltering());
        theDeck.add(new MuzzleSnap());
        theDeck.add(new OldScratch());
        theDeck.add(new ProfessorPresto());
        theDeck.add(new Scorchia());
        theDeck.add(new ThaiFoon());
        theDeck.add(new TheDeathFairy());
        theDeck.add(new TwoFaced());

        theDeck.add(new Ballsy());
        theDeck.add(new Bedazzlement());
        theDeck.add(new BenVoodoo());
        theDeck.add(new Boulderiffic());
        theDeck.add(new BrainSuck());
        theDeck.add(new Chicken());
        theDeck.add(new ConeOfAcid());
        theDeck.add(new DeathWish());
        theDeck.add(new Devilicious());
        theDeck.add(new DragonHoard());
        theDeck.add(new DrRootyBark());
        theDeck.add(new Explodifying());
        theDeck.add(new FistONature());
        theDeck.add(new Gorenado());
        theDeck.add(new Impatient());
        theDeck.add(new KingOberon());
        theDeck.add(new LighteningBolt());
        theDeck.add(new MagmaGog());
        theDeck.add(new MeatierSwarm());
        theDeck.add(new MercyKilling());
        theDeck.add(new MidnightMerlin());
        theDeck.add(new MightyGro());
        theDeck.add(new MindAltering());
        theDeck.add(new MuzzleSnap());
        theDeck.add(new OldScratch());
        theDeck.add(new ProfessorPresto());
        theDeck.add(new Scorchia());
        theDeck.add(new ThaiFoon());
        theDeck.add(new TheDeathFairy());
        theDeck.add(new TwoFaced());

        theDeck.add(new Ballsy());
        theDeck.add(new Bedazzlement());
        theDeck.add(new BenVoodoo());
        theDeck.add(new Boulderiffic());
        theDeck.add(new BrainSuck());
        theDeck.add(new Chicken());
        theDeck.add(new ConeOfAcid());
        theDeck.add(new DeathWish());
        theDeck.add(new Devilicious());
        theDeck.add(new DragonHoard());
        theDeck.add(new DrRootyBark());
        theDeck.add(new Explodifying());
        theDeck.add(new FistONature());
        theDeck.add(new Gorenado());
        theDeck.add(new Impatient());
        theDeck.add(new KingOberon());
        theDeck.add(new LighteningBolt());
        theDeck.add(new MagmaGog());
        theDeck.add(new MeatierSwarm());
        theDeck.add(new MercyKilling());
        theDeck.add(new MidnightMerlin());
        theDeck.add(new MightyGro());
        theDeck.add(new MindAltering());
        theDeck.add(new MuzzleSnap());
        theDeck.add(new OldScratch());
        theDeck.add(new ProfessorPresto());
        theDeck.add(new Scorchia());
        theDeck.add(new ThaiFoon());
        theDeck.add(new TheDeathFairy());
        theDeck.add(new TwoFaced());
    }


}
