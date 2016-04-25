package scottie.cs301.EpicActuals.Players;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import scottie.cs301.EpicActuals.Resources.Actions.SendSpell;
import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.GameMainActivity;
import scottie.cs301.Imports.GameFramework.R;
import scottie.cs301.Imports.GameFramework.infoMsg.GameInfo;
import scottie.cs301.Imports.GameFramework.infoMsg.IllegalMoveInfo;
import scottie.cs301.Imports.GameFramework.infoMsg.NotYourTurnInfo;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * This is the HumanActual Player class for Epic.
 * Receive info and build the GUI.
 * Handle UI and send actions back to Local.
 */
public class HumanActual extends HumanAbstract implements View.OnClickListener {
    protected GameStateActual myRecentState; //full copy of most recently received Game State for easier access
    private GameMainActivity myActivity;


    private ImageButton[] myHandImages;
    private ImageButton[] myFocus;


    protected ImageButton playerCard1;
    protected ImageButton playerCard2;
    protected ImageButton playerCard3;
    protected ImageButton playerCard4;
    protected ImageButton playerCard5;
    protected ImageButton playerCard6;
    protected ImageButton playerCard7;
    protected ImageButton playerCard8;

    private ArrayList<Card> myHand;

    protected ImageButton fieldCard1;
    protected ImageButton fieldCard2;
    protected ImageButton fieldCard3;

    protected TextView healthOne;
    protected TextView healthTwo;
    protected TextView healthThree;
    protected TextView healthFour;
    protected TextView[] healths;

    TextView player1Name;
    TextView player2Name;
    TextView player3Name;
    TextView player4Name;
    TextView[] playerNames;



    public HumanActual(String name) {
        super(name);
    } //default constructor

    @Override
    public View getTopView() {
        return myActivity.findViewById(R.id.cardsToPlay);
    } //inherited from Game Framework

    @Override
    public void receiveInfo(GameInfo info) {
        if (info instanceof NotYourTurnInfo || info instanceof IllegalMoveInfo)
        {
            flash(Color.RED,500);
            return;
        }
        else if (info instanceof GameStateActual) {
            myRecentState = (GameStateActual) info;
            myHand = myRecentState.playerHands.get(playerNum);
            int playerTurn = myRecentState.getWhoseTurn();
            setTurnSign(playerTurn);
            populateHand();
            setName();
            Log.i("Player Turn",""+myRecentState.getWhoseTurn());
        }

    } //inherited from Game Framework

    public void setAsGui(GameMainActivity activity) {
        myActivity = activity;

        myActivity.setContentView(R.layout.epic_gui_4);
        playerCard1 = (ImageButton) activity.findViewById(R.id.playerCard1);
        playerCard2 = (ImageButton) activity.findViewById(R.id.playerCard2);
        playerCard3 = (ImageButton) activity.findViewById(R.id.playerCard3);
        playerCard4 = (ImageButton) activity.findViewById(R.id.playerCard4);
        playerCard5 = (ImageButton) activity.findViewById(R.id.playerCard5);
        playerCard6 = (ImageButton) activity.findViewById(R.id.playerCard6);
        playerCard7 = (ImageButton) activity.findViewById(R.id.playerCard7);
        playerCard8 = (ImageButton) activity.findViewById(R.id.playerCard8);

        healthOne = (TextView) activity.findViewById(R.id.player1Health);
        healthTwo = (TextView) activity.findViewById(R.id.player2Health);
        healthThree = (TextView) activity.findViewById(R.id.player3Health);
        healthFour = (TextView) activity.findViewById(R.id.player4Health);
        healths = new TextView[]{healthOne, healthTwo, healthThree, healthFour};

        myHandImages = new ImageButton[] {
                playerCard1,
                playerCard2,
                playerCard3,
                playerCard4,
                playerCard5,
                playerCard6,
                playerCard7,
                playerCard8,

        };
        playerCard1.setOnClickListener(this);
        playerCard2.setOnClickListener(this);
        playerCard3.setOnClickListener(this);
        playerCard4.setOnClickListener(this);
        playerCard5.setOnClickListener(this);
        playerCard6.setOnClickListener(this);
        playerCard7.setOnClickListener(this);
        playerCard8.setOnClickListener(this);

        fieldCard1 = (ImageButton)activity.findViewById(R.id.playedCard1);
        fieldCard2 = (ImageButton)activity.findViewById(R.id.playedCard2);
        fieldCard3 = (ImageButton)activity.findViewById(R.id.playedCard3);
        myFocus = new ImageButton[]{fieldCard1, fieldCard2, fieldCard3};


        Button readyButton = (Button) activity.findViewById(R.id.readyButton);
        readyButton.setOnClickListener(this);

        Button killButton = (Button)activity.findViewById(R.id.killButton);
        killButton.setOnClickListener(this);

        player1Name = (TextView)activity.findViewById(R.id.player1Callout);
        player2Name = (TextView)activity.findViewById(R.id.player2Callout);
        player3Name = (TextView)activity.findViewById(R.id.player3Callout);
        player4Name = (TextView)activity.findViewById(R.id.player4Callout);

        playerNames = new TextView[]{player1Name,player2Name,player3Name,player4Name};

        if (myRecentState != null) {
            receiveInfo(myRecentState);
            populateHand();
        }

    } //parse through Recent State and set up GUI elements

    public void onClick(View v) {
        if (myRecentState != null) {

            if (v.getId() == R.id.readyButton)
            {
                this.onReadyClicked();
                //Log.i("After Send", "" + myHand.toString());
            }

            else if (v.getId()==R.id.killButton)
            {
                System.exit(0);
            }
            else
            {
                ImageButton clickedCard = (ImageButton) myActivity.findViewById(v.getId());
                clickedCard.setImageAlpha(382 - clickedCard.getImageAlpha());
            }
        }
    } //handle various UI actions


    public boolean onReadyClicked() {
            ArrayList<Card> mySpell = new ArrayList<Card>();
            for (int itter = 0; itter < 8; itter++) {
                if (myHandImages[itter].getImageAlpha() <= 250) {
                    mySpell.add(myHand.get(itter));
                    if (mySpell.size()==3)
                    {
                        break;
                    }
                }
            }
        displaySpell(mySpell);
        game.sendAction(new SendSpell(this, mySpell));
        Log.i("Human Player Spell",""+this);

            return true;


    } //visual feedback for card selection

    public void populateHand() {
        Thread newThread = new Thread(new Runnable() {
            public void run() {
                playerCard1.setImageResource(myHand.get(0).imageRef);
                playerCard2.setImageResource(myHand.get(1).imageRef);
                playerCard3.setImageResource(myHand.get(2).imageRef);
                playerCard4.setImageResource(myHand.get(3).imageRef);
                playerCard5.setImageResource(myHand.get(4).imageRef);
                playerCard6.setImageResource(myHand.get(5).imageRef);
                playerCard7.setImageResource(myHand.get(6).imageRef);
                playerCard8.setImageResource(myHand.get(7).imageRef);

                for (int i = 0; i < myHandImages.length; i++) {
                    myHandImages[i].setImageAlpha(255);
                }

                for (int itter = 0; itter < 4; itter++) {
                    healths[itter].setText("" + myRecentState.playerHealths[itter]);
                }

            }


        });
        newThread.run();
    }
    public void setTurnSign(int playerTurn) {
        View stats1 = myActivity.findViewById(R.id.player1stats);
        View stats2 = myActivity.findViewById(R.id.player2stats);
        View stats3 = myActivity.findViewById(R.id.player3stats);
        View stats4 = myActivity.findViewById(R.id.player4stats);


        if (playerTurn == 0) {
            stats1.setBackgroundColor(Color.rgb(140, 140, 140));
            stats2.setBackgroundColor(Color.BLACK);
            stats3.setBackgroundColor(Color.BLACK);
            stats4.setBackgroundColor(Color.BLACK);
        } else if (playerTurn == 1) {
            stats1.setBackgroundColor(Color.BLACK);
            stats2.setBackgroundColor(Color.rgb(140, 140, 140));
            stats3.setBackgroundColor(Color.BLACK);
            stats4.setBackgroundColor(Color.BLACK);
        } else if (playerTurn == 2) {
            stats1.setBackgroundColor(Color.BLACK);
            stats2.setBackgroundColor(Color.BLACK);
            stats3.setBackgroundColor(Color.rgb(140, 140, 140));
            stats4.setBackgroundColor(Color.BLACK);
        } else if (playerTurn == 3) {
            stats1.setBackgroundColor(Color.BLACK);
            stats2.setBackgroundColor(Color.BLACK);
            stats3.setBackgroundColor(Color.BLACK);
            stats4.setBackgroundColor(Color.rgb(140, 140, 140));
        }
    }

    public void setName()
    {
        for (int i = 0; i < allPlayerNames.length; i++)
        {
            playerNames[i].setText(allPlayerNames[i]);
        }
    }

    public void displaySpell(ArrayList<Card> theSpell)
    {
        int counter = 0;
        Card firstCard = null;
        Card secondCard = null;
        Card thirdCard = null;
        for (Card a :theSpell)
        {
            switch (a.placement)
            {
                case 1: firstCard=a;break;
                case 2: secondCard=a;break;
                case 3: thirdCard=a;break;
            }
        }
        if (firstCard == null)
        {
            myFocus[0].setImageResource(R.drawable.cardback);
        }
        else
        {
            myFocus[0].setImageResource(firstCard.imageRef);
        }
        if (secondCard == null)
        {
            myFocus[1].setImageResource(R.drawable.cardback);
        }
        else
        {
            myFocus[1].setImageResource(secondCard.imageRef);
        }
        if (thirdCard == null)
        {
            myFocus[2].setImageResource(R.drawable.cardback);
        }
        else
        {
            myFocus[2].setImageResource(thirdCard.imageRef);
        }
    }

}
