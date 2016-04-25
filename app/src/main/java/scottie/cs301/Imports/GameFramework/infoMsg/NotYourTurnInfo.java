package scottie.cs301.Imports.GameFramework.infoMsg;

import java.io.Serializable;

/**
 * The a message from the game to a player that the move just attempted
 * was made at a time when they were not allowed to move.
 *
 * @author Steven R. Vegdahl 
 * @version July 2013
 */
public class NotYourTurnInfo extends GameInfo implements Serializable {

	// to satisfy the Serializable interface
	private static final long serialVersionUID = 3417491177980351323L;

}
