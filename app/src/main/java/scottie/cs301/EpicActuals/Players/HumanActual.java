package scottie.cs301.EpicActuals.Players;

import android.media.Image;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.apache.http.auth.NTUserPrincipal;

import scottie.cs301.EpicActuals.LocalProtect.STATIC;
import scottie.cs301.EpicActuals.Resources.Actions.CHOICE;
import scottie.cs301.EpicActuals.Resources.Actions.SendSpell;
import scottie.cs301.EpicActuals.Resources.Cards.Deck;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.EpicActuals.Resources.Info.LOCATION;
import scottie.cs301.EpicActuals.Resources.Info.STAGE;
import scottie.cs301.Imports.GameFramework.Game;
import scottie.cs301.Imports.GameFramework.GameHumanPlayer;
import scottie.cs301.Imports.GameFramework.GameMainActivity;
import scottie.cs301.Imports.GameFramework.R;
import scottie.cs301.Imports.GameFramework.infoMsg.GameInfo;

import static java.util.Arrays.copyOf;

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
public class HumanActual extends HumanAbstract implements View.OnClickListener, View.OnLongClickListener {
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
    private int[] myHand;

    protected ImageButton fieldCard1;
    protected ImageButton fieldCard2;
    protected ImageButton fieldCard3;

    protected TextView healthOne;
    protected TextView healthTwo;
    protected TextView healthThree;
    protected TextView healthFour;
    protected TextView[] healths;



    public HumanActual(String name) {
        super(name);
    } //default constructor

    @Override
    public View getTopView() {
        return myActivity.findViewById(R.id.top_view);
    } //inherited from Game Framework

    @Override
    public void receiveInfo(GameInfo info) {
        if (info instanceof GameStateActual) {
            myRecentState = (GameStateActual) info;
        }
        populateHand();
    } //inherited from Game Framework

    public void setAsGui(GameMainActivity activity) {
        myActivity = activity;


//
//
//        if (myRecentState==null)
//        {
//            return;
//        }
//        else if (myRecentState.playerHealths.length==3)
//        {
//            myActivity.setContentView(R.layout.epic_gui_3);
//        }
//        else
//        {
        // myActivity.setContentView(R.layout.epic_gui_4);
        // }

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

        if (myRecentState != null) {
            receiveInfo(myRecentState);
            populateHand();
        }

    } //parse through Recent State and set up GUI elements

    public void onClick(View v) {
        if(myRecentState != null)
        {

        if (v.getId() == R.id.readyButton) {
            this.onReadyClicked();
            //Log.i("After Send", "" + myHand.toString());
        } else {
            ImageButton clickedCard = (ImageButton) myActivity.findViewById(v.getId());
            clickedCard.setImageAlpha(382 - clickedCard.getImageAlpha());
        }
        }
    } //handle various UI actions

    public boolean onLongClick(View v) {
        return false;
    } //for use in zoom-in on element

    public boolean onReadyClicked() {
        if(myRecentState.playerStages[playerNum] == STAGE.SelectingCards) {
            int[] spell = new int[3];
            int slider = 0;
            for (int itter = 0; itter < 8; itter++) {
                if (myHandImages[itter].getImageAlpha() <= 250) {
                    spell[slider] = itter;
                    slider++;

                    if (slider == 3) {
                        break;
                    }
                }
            }

            //Log.i("Before Send", "" + myHand.toString());
            game.sendAction(new SendSpell(this, new int[]{myHand[spell[0]], myHand[spell[1]], myHand[spell[2]]}));
            return true;
        }
        else
        {
            return false;
        }


    } //visual feedback for card selection

    public CHOICE respondToQuestion(CHOICE[] validAnswers) {
        return null;
    } // contextual response

    public void populateHand() {
        myHand = myRecentState.allCardsFrom(STATIC.locOf(playerNum, LOCATION.Hand), myRecentState.spellCardLocation);

        int[] myHandBuffered = copyOf(myHand, 8);
        myHand = myHandBuffered;

        playerCard1.setImageResource(Deck.theDeck[myHandBuffered[0]].imageRef);
        playerCard2.setImageResource(Deck.theDeck[myHandBuffered[1]].imageRef);
        playerCard3.setImageResource(Deck.theDeck[myHandBuffered[2]].imageRef);
        playerCard4.setImageResource(Deck.theDeck[myHandBuffered[3]].imageRef);
        playerCard5.setImageResource(Deck.theDeck[myHandBuffered[4]].imageRef);
        playerCard6.setImageResource(Deck.theDeck[myHandBuffered[5]].imageRef);
        playerCard7.setImageResource(Deck.theDeck[myHandBuffered[6]].imageRef);
        playerCard8.setImageResource(Deck.theDeck[myHandBuffered[7]].imageRef);

        for(int itter = 0; itter < 4; itter++)
        {
            healths[itter].setText("" + myRecentState.playerHealths[itter]);
        }

        if(myRecentState.focusedCards != null)
        {
            int lengthBuffer = myRecentState.focusedCards.length;
            if (lengthBuffer != 0) {
                if (lengthBuffer > 3) {
                    lengthBuffer = 3;
                }
                for (int itter = 0; itter < lengthBuffer; itter++) {
                    myFocus[itter].setImageResource(Deck.theDeck[myRecentState.focusedCards[itter]].imageRef);
                }
            }
        }
    }


}
