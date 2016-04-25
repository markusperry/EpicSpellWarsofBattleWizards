package scottie.cs301.EpicActuals.Resources.Info;

import java.util.ArrayList;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Cards.Deck;
import scottie.cs301.Imports.GameFramework.infoMsg.GameState;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * GameState subclass that contains all of current game information.
 * Basic methods provided, although most action taken in LocalGameActual.
 */
public class GameStateActual extends GameState {
    public int[] playerHealths;
    private int whoseTurn;
    public ArrayList<ArrayList<Card>> playerHands;

    public int getWhoseTurn() {
        return whoseTurn;
    }

    public void setWhoseTurn(int whoseTurn) {
        this.whoseTurn = whoseTurn;
    }

    public GameStateActual() {
        playerHealths = new int[4];
        playerHands = new ArrayList<ArrayList<Card>>();

        for(int itter = 0; itter < 4; itter++)
        {
            playerHealths[itter] = 15;
            playerHands.add(itter,deal(8));
        }
        whoseTurn=0;


    } //starting constructor

    public GameStateActual(GameStateActual original) {
        playerHealths = new int[4];
        playerHands = new ArrayList<ArrayList<Card>>();
        for (int i = 0; i < 4; i++) {
            playerHealths[i]=original.playerHealths[i];
           playerHands.add(i,original.playerHands.get(i));
        }
        whoseTurn = original.whoseTurn;
    }

    public Card randomCardFrom() {
        Random RRR = new Random();
        Card randomCard = Deck.theDeck.get(RRR.nextInt(Deck.theDeck.size()));
        return randomCard;
    }

    public void damage(int damageVal, int playerToDamage)
    {
        if (playerHealths[playerToDamage] - damageVal >= 0) {
            playerHealths[playerToDamage] -= damageVal;
        }
        else {
            return;
        }
    }

    public void damageMultiple(int damageVal, ArrayList<Integer>playersToDamage)
    {
        for (int a: playersToDamage)
        {
            if (playerHealths[a] - damageVal >= 0) {
                playerHealths[a] -= damageVal;
            }
        }
    }

    public void damageAll(int damageVal, int playerNoDamage)
    {
        for (int i = 0; i < playerHealths.length; i++)
        {
            if (i!=playerNoDamage)
            {
                if (playerHealths[i] - damageVal >= 0) {
                    playerHealths[i] -= damageVal;
                }
            }
        }
    }

    public ArrayList<Card> deal(int numCards)
    {
        Deck myDeck = new Deck();
        ArrayList<Card> toDeal = new ArrayList<Card>();
        for (int i = 0; i < 8; i++) {
            toDeal.add(randomCardFrom());
        }
        return toDeal;
    }

    public void dealNewHandTo(int playerNum, ArrayList<Card> theCastedSpell)
    {
        ArrayList<Card> newHand;
        for (Card a :theCastedSpell)
        {
            playerHands.get(playerNum).remove(a);
        }

        newHand = this.deal(theCastedSpell.size());
        playerHands.get(playerNum).addAll(newHand);

    }

    public void incrementTurn(int playerNum)
    {
        if (playerNum+1==4)
        {
            setWhoseTurn(0);
        }
        else
        {
            setWhoseTurn(playerNum+1);
        }
    }
}
