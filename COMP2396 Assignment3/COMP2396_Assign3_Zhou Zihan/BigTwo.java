import java.util.ArrayList;

/**
 * The BigTwo class implements the CardGame interface 
 * and is used to model a Big Two card game
 * 
 * @author zhouzihan
 * @version 1.8.301.09
 */

public class BigTwo implements CardGame{
	
	//an integer specifying the number of players
	private int numOfPlayers;
	//a deck of cards
	private Deck deck;
	//a list of players
	private ArrayList<CardGamePlayer> playerList;
	//a list of hands played on the table
	private ArrayList<Hand> handsOnTable;
	//an integer specifying the index of the current player
	private int currentPlayerIdx;
	//a BigTwoUI object for providing the user interface
	private BigTwoUI ui;
	
	/**
	 * a constructor for creating a Big Two card game
	 * create 4 players and add them to the player list
	 * create a BigTwoUI object for providing the user interface
	 */
	public BigTwo() {
		playerList = new ArrayList<CardGamePlayer>();
		numOfPlayers = 4;
		for (int i = 0; i < numOfPlayers; i++) {
			CardGamePlayer player = new CardGamePlayer();
			playerList.add(i, player);
		}
		handsOnTable = new ArrayList<Hand>();
		ui = new BigTwoUI(this);
		
	}
	
	/**
	 * a method for getting the number of players
	 * @return number of players
	 */
	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	
	/**
	 * a method for retrieving the deck of cards being used
	 * @return get the deck of cards being used
	 */
	public Deck getDeck() {
		return deck;
	}
	
	/**
	 * a method for retrieving the list of players
	 * @return the list of players
	 */
	public ArrayList<CardGamePlayer> getPlayerList(){
		return playerList;
	}
	
	/**
	 * a method for retrieving the list of hands played on the table
	 * @return the list of hands played on the table
	 */
	public ArrayList<Hand> getHandsOnTable(){
		return handsOnTable;
	}
	
	/**
	 * a method for retrieving the index of the current player
	 * @return the index of the current player
	 */
	public int getCurrentPlayerIdx() {
		return currentPlayerIdx;
	}
	
	/**
	 * a method for starting/restarting the game with a given shuffled deck of cards
	 * remove all the cards from the players as well as from the table;
	 * distribute the cards to the players;
	 * identify the player who holds the Three of Diamonds;
	 * reset both the currentPlayerIdx of the BigTwo object and the activePlayer
	 * show the cards on the table;
	 * prompt user to select cards and make his/her move
	 * 
	 * @param deck
	 */
	public void start(Deck deck) {

		//clear players' hands
		for (int i = 0; i < numOfPlayers; i++) {
			playerList.get(i).removeAllCards();
		}
		//clear table
		handsOnTable.clear();
		//reset ui
		ui.reset();
		//reset current player index
		currentPlayerIdx = 0;
		//take the shuffled deck
		deck.shuffle();
		//distribute cards to the players
		for (int k = 0; k < numOfPlayers; k++) {
			for (int h = 0; h < 13; h++) {
				playerList.get(k).addCard(deck.getCard(h+k*13));
			}
		}
		//find out who takes the Three of Diamonds
		//And set the current player index to him
		//Also reset the active player
		for (int k = 0; k < numOfPlayers; k++) {
			for (int h = 0; h < 13; h++) {
				if (playerList.get(k).getCardsInHand().getCard(h).getRank() == 2
						&& playerList.get(k).getCardsInHand().getCard(h).getSuit() == 0) {
					currentPlayerIdx =  k;
					ui.setActivePlayer(k);
					break;
				}
			}
			//sort players' hands for better display
			playerList.get(k).sortCardsInHand();
		}
		//reset the ui	
		ui.repaint();
		//wait for player's input
		ui.promptActivePlayer();
	}
	
	/**
	 * compose a hand using player and his/her cards
	 * 
	 * @param player
	 * @param cards
	 * 
	 * @return hand
	 */
	public static Hand composeHand(CardGamePlayer player, CardList cards) {
		//if the input cards is null
		if (cards == null) {
			return null;
		}
		else {
			cards.sort();
			//single
			if (cards.size() == 1) {
				Hand single = new Single(player, cards);
				return single;
			}
			//pair
			else if (cards.size() == 2) {
				Hand pair = new Pair(player, cards);
				if (pair.isValid()) {
					return pair;
				}
			}
			//triple
			else if (cards.size() == 3) {
				Hand triple = new Triple(player, cards);
				if (triple.isValid()) {
					return triple;
				}
			}
			//when the cards size is five
			//it has five possibilities
			else if (cards.size() == 5){
				Hand fullHouse = new FullHouse(player, cards);
				Hand flush = new Flush(player, cards);
				Hand straight = new Straight(player, cards);
				Hand quad = new Quad(player, cards);
				Hand straightflush = new StraightFlush(player, cards);
				
				//return the valid hand
				if (fullHouse.isValid() == true) {
					return fullHouse;
				}
				else if (flush.isValid() == true) {
					return flush;
				}
				else if (straight.isValid() == true) {
					return straight;
				}
				else if (quad.isValid()== true) {
					return quad;
				}
				else if (straightflush.isValid() == true) {
					return straightflush;
				}
				else {
					return null;
				}
			}
			return null;
		}
	}
	/**
	 * a method for making a move by a player with the specified index 
	 * using the cards specified by the list of indices
	 * call the checkmove function
	 * 
	 * @param playerIdx
	 * @param cardIdx
	 */
	public void makeMove(int playerIdx, int[] cardIdx) {
		checkMove(playerIdx, cardIdx);
	}
	
	/**
	 * a method for checking a move made by a player.
	 * This method should be called from the makeMove() method.
	 * 
	 * @param playerIdx
	 * @param cardIdx
	 */
	public void checkMove(int playerIdx, int[] cardIdx) {
		//use isValid to detect whether the input is valid
		boolean isValid = false;
		//use passFlag to denote whether the player has passed this turn
		int passFlag;
		if (cardIdx == null) {
			passFlag = 0;  //the player passed this turn
		}
		else {
			passFlag = 1;  //the player didn't pass this turn
		}
		
		//create the playerHand
		Hand playerHand = composeHand(playerList.get(playerIdx), playerList.get(playerIdx).play(cardIdx));
		
		//first move
		if(handsOnTable.isEmpty()) {
			//first move contains diamonds 3 and valid hand, the player cannot pass
			//if the player pass this turn, the program would output the invalid signal
			if(playerHand != null
					&& playerHand.getCard(0).getRank() == 2
					&& playerHand.getCard(0).getSuit() == 0) {
				isValid = true;
			}
		}
		
		//other moves
		else {
			//if he wins the turn
			//which means everyone except him passed this round
			if(handsOnTable.get(handsOnTable.size() - 1).getPlayer() == playerList.get(playerIdx)) {
				//valid hand, cannot pass
				//if the player want to pass this turn, update isValid to false
				if (passFlag == 1) {
					isValid = false;
				}
				if(playerHand != null) {
					isValid = true;
				}
			}
			//there are other players who played the card in this turn
			else{
				//if he needs to beat or pass
				//if he passed this round
				if (passFlag == 0) {
					isValid = true;
				}
				//if he beat other players
				else if(playerHand != null && playerHand.beats(handsOnTable.get(handsOnTable.size() - 1))) {
					isValid = true;
				}
				else {
					isValid = false;
				}
			}
		}
		
		
		//if the move not valid
		if(!isValid) {
			System.out.println("Not a legal move!!!");
			//the player plays again
			ui.repaint();
			ui.promptActivePlayer();
		}
		//the move is valid
		else {
			if (passFlag == 1) { //not pass
				//play the hand
				playerList.get(currentPlayerIdx).removeCards(playerHand);
				//add the player hand to table
				handsOnTable.add(playerHand);
				System.out.print("{"+playerHand.getType()+"} ");
				playerHand.print();
				System.out.println();
			}
			//pass this turn
			else {
				System.out.println("{Pass}");
				System.out.println();
			}
			
			//check whether the game comes to an end
			if (endOfGame()) {
				System.out.println("Game ends");
				for (int i = 0; i < numOfPlayers; i++) {
					//other player
					if (i != currentPlayerIdx) {
						System.out.println("Player "+ i +" has "+ playerList.get(i).getCardsInHand().size() +" in hand.");
					}
					//the winner
					else {
						System.out.println("Player "+ currentPlayerIdx +" wins the game.");
					}
					
				}
				return;
			}
			else {
				//next player
				currentPlayerIdx = (currentPlayerIdx + 1) % 4;
				//reset the active player
				ui.setActivePlayer(currentPlayerIdx);
				//repaint the ui
				ui.repaint();
				//wait for the player's input
				ui.promptActivePlayer();
			}
			return;
		}
	}
	
	/**
	 * function that tests whether it is the end of game
	 * 
	 * @return true if the hand of current player is null
	 *  false otherwise
	 */
	public boolean endOfGame() {
		if (playerList.get(currentPlayerIdx).getCardsInHand().size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * the main function to call the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BigTwo bigTwo = new BigTwo();
		BigTwoDeck bigTwoDeck = new BigTwoDeck();
		bigTwo.start(bigTwoDeck);
	}
}
