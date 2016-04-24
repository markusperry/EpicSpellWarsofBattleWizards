package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * This is a middleman layer object.
 * Common methods or effort saving methods may be added here.
 */
public abstract class CardNode extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    /**
     * constructor
     * @param myID  cardID number
     * @param myInit    card initiative
     * @param myPlace   card position
     * @param myImage   image resource associated with card
     */
    protected CardNode(int myID,
                       int myInit,
                       int myPlace,
                       int myImage) {
        super(myID,
                myInit,
                myPlace,
                myImage);


    } //Move along; move along.

    /**
     * decreases health bar of specific player
     * @param player    player to deal damage to
     * @param damageVal amount of damage
     * @param masterState gamestate object
     */
    public void damage(int player, int damageVal, GameStateActual masterState)
    {
        masterState.playerHealths[player] -= damageVal;
    }

    /**
     * inbcreases health bar of specific player
     * @param player    player to heal
     * @param healVal   amount to heal
     * @param masterState   gamestate object
     */
    public void heal(int player, int healVal, GameStateActual masterState)
    {
        masterState.playerHealths[player] += healVal;
    }

    /**
     * returns the player to the right of a given player
     *
     * @param playerID given player
     * @param masterState gamestate object
     * @return ID number of player to right
     */
    public int returnRight(int playerID, GameStateActual masterState) {
        // finds number of players and finds playerID number of to right
        int numPlayers = masterState.playerHealths.length;

        if (playerID == numPlayers) {
            return 0;
        }
        return playerID + 1;
    }

    /**
     * returns the player to the left of a given player
     *
     * @param player given player
     * @param masterState gamestate object
     * @return ID number of player to left
     */
    public static
    int returnLeft(int player, GameStateActual masterState)
    {
        int numPlayers = masterState.playerHealths.length;

        if(player == 0)
        {
            return numPlayers - 1;
        }
        return player - 1;
    }

    /**
     * returns ID number of player with least health
     *
     * @param masterState game state
     * @return weakest  player ID of weakest player
     */
    public int returnWeakest(GameStateActual masterState) {
        int weakest = 0;

        // goes through the playerHealths array to find lowest health score
        for (int i = 0; i < masterState.playerHealths.length; i++) {
            if (masterState.playerHealths[i] < masterState.playerHealths[i + 1]) {
                weakest = i;
            }
        }
        return weakest;
    }

    /**
     * returns ID number of player with most health
     *
     * @param masterState game state
     * @return weakest  player ID of strongest player
     */
    public int returnStrongest(GameStateActual masterState) {
        int strongest = 0;

        // goes through the playerHealths array to find lowest health score
        for (int i = 0; i < masterState.playerHealths.length; i++) {
            if (masterState.playerHealths[i] > masterState.playerHealths[i + 1]) {
                strongest = i;
            }
        }
        return strongest;
    }

    /**
     * returns number of players left alive
     *
     * @param masterState gamestate object
     * @return alive   number of wizards left alive
     */
    public int returnAlive(GameStateActual masterState) {
        int alive = 0;

        // goes through the playerHealths array to find number of players with health > 0
        for (int i = 0; i < masterState.playerHealths.length; i++) {
            if (masterState.playerHealths[i] > 0) {
                alive++;
            }
        }
        return alive;
    }

    /**
     * finds number of players
     *
     * @param masterState gamestate object
     * @return number of players
     */
    public int returnNumPlayers(GameStateActual masterState) {
        return masterState.playerHealths.length;
    }

    /**
     * chooses foe for player
     *
     * @param playerID  ID of player looking for foe
     * @param masterState gamestate object
     * @return ID number of foe
     */
    public int chooseFoe(int playerID, GameStateActual masterState) {

        // randomly chooses foe for given player based on number of players
        int numPlayers = masterState.playerHealths.length;
        int foe = playerID;
        while (foe == playerID) {
            Random random = new Random();
            foe = random.nextInt(numPlayers);
        }
        return foe;
    }

    /**
     * calculates a random number between 1 and 6
     *
     * @return number "rolled"
     */
    public int rollDie() {
        return (int) Math.random() * 6 + 1;

        /*
         * External Citation
         *  Date: 4/17/16
         *  Problem: could not remember how to generate a random using the Math class
         *  Resource: http://www.tutorialspoint.com/java/lang/math_random.htm
         *  Solution: used the Math.random() method from post
         */
    }





}