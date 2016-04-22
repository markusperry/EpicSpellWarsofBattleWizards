package scottie.cs301.EpicActuals;

import java.util.ArrayList;

import scottie.cs301.EpicActuals.LocalProtect.LocalGameActual;
import scottie.cs301.EpicActuals.Players.ComputerActualRandy;
import scottie.cs301.EpicActuals.Players.ComputerActualSmartyPants;
import scottie.cs301.EpicActuals.Players.HumanActual;
import scottie.cs301.Imports.GameFramework.GameMainActivity;
import scottie.cs301.Imports.GameFramework.GamePlayer;
import scottie.cs301.Imports.GameFramework.LocalGame;
import scottie.cs301.Imports.GameFramework.config.GameConfig;
import scottie.cs301.Imports.GameFramework.config.GamePlayerType;

/**
 * Created by zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * Main Activity to run Epic Spell Wars.
 */
public class MainActivity extends GameMainActivity {

    private static final int PORT_NUMBER = 2269;

    @Override
    public GameConfig createDefaultConfig() {
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();

        playerTypes.add(new GamePlayerType("Local Human Player") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new HumanActual(name);
            }
        });

        playerTypes.add(new GamePlayerType("Dumb Computer Player") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new ComputerActualRandy(name);
            }
        });

        playerTypes.add(new GamePlayerType("Smart Computer Player") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new ComputerActualSmartyPants(name);
            }
        });

        GameConfig defaultConfig = new GameConfig(playerTypes, 4, 4, "Epic Spell Wars!", PORT_NUMBER);

        defaultConfig.addPlayer("Human",0);
        defaultConfig.addPlayer("Computer 1",1);
        defaultConfig.addPlayer("Computer 2", 1);
        defaultConfig.addPlayer("Computer 3",1);

        defaultConfig.setRemoteData("Remote Player","",0);

        return defaultConfig;
    } //inherits and builds

    @Override
    public LocalGame createLocalGame() {
        return new LocalGameActual(4);
    } //inheritted method to launch game
}
