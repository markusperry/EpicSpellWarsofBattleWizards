package scottie.cs301.Imports.GameFramework.infoMsg;

import java.io.Serializable;

/**
 * The a message from the game to a player that the move just attempted
 * was illegal.
 *
 * @author Steven R. Vegdahl 
 * @version July 2013
 */
public class IllegalMoveInfo extends GameInfo implements Serializable {

	// to satisfy Serializable interface
	private static final long serialVersionUID = 7165334825841353190L;

}
