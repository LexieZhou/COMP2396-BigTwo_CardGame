import java.net.Socket;
import java.io.ObjectOutputStream;
/**
 * The BigTwoClient class implements the NetworkGame interface.
 * This class is used for establishing a connection to the Big Two game server 
 * and handling the communications with the game server.
 * 
 * @author zhouzihan
 *
 */
public class BigTwoClient implements NetworkGame{
	private BigTwo game;       //a BigTwo object for the Big Two card game.
	private BigTwoGUI gui;     //a BigTwoGUI object for the Big Two card game.
	private Socket sock;       //a socket connection to the game server.
	private ObjectOutputStream oos; //an ObjectOutputStream for sending messages to the server.
	private int playerID;      //an integer specifying the playerID (i.e., index) of the local player.
	private String playerName; //a string specifying the name of the local player.
	private String serverIP;   //a string specifying the IP address of the game server.
	private int serverPort;    //an integer specifying the TCP port of the game server.
	/**
	 * a constructor for creating a Big Two client.
	 * 
	 * @param game a reference to a BigTwo object associated with this client
	 * @param gui a reference to a BigTwoGUI object associated the BigTwo object
	 */
	public BigTwoClient(BigTwo game, BigTwoGUI gui) {
		this.game = game;
		this.gui = gui;
		playerID = game.getCurrentPlayerIdx();
		playerName = game.getPlayerList().get(playerID).getName();
		
		
	}
	
	/**
	 * Returns the playerID (index) of the local player.
	 * 
	 * @return the playerID (index) of the local player
	 */
	public int getPlayerID() {
		playerID = game.getCurrentPlayerIdx();
		return playerID;
	}
	
	/**
	 * Sets the playerID (index) of the local player.
	 * Should be called from the parseMessage() method.
	 * 
	 * @param playerID
	 *            the playerID (index) of the local player.
	 */
	public void setPlayerID(int playerID) {
		
	}
}
