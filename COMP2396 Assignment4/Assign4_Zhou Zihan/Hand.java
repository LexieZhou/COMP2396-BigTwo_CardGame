/**
 * The Hand class is a subclass of the CardList class 
 * and is used to model a hand of cards. 
 * It has a private instance variable for storing the player who plays this hand. 
 * It also has methods for getting the player of this hand, 
 * checking if it is a valid hand, getting the type of this hand, 
 * getting the top card of this hand, and checking if it beats a specified hand.
 * 
 * @author zhouzihan
 *
 */
public class Hand extends CardList{
	private static final long serialVersionUID = -3711761437629470849L;
	private CardGamePlayer player;
	
	/**
	 * a constructor for building a hand 
	 * with the specified player and list of cards.
	 * 
	 * @param player
	 * @param cards
	 */
	public Hand (CardGamePlayer player, CardList cards) {
		this.player = new CardGamePlayer();
		this.player = player;
		for (int i = 0; i < cards.size(); i++) {
			this.addCard(cards.getCard(i));
		}
	}
	
	/**
	 * a method for retrieving the player of this hand
	 * @return the player
	 */
	public CardGamePlayer getPlayer() {
		return this.player;
	}
	
	/**
	 * a method for retrieving the top card of this hand
	 * @return the top card of this hand
	 */
	public Card getTopCard() {
		return this.getTopCard();
	}
	
	/**
	 * a method for checking if this hand beats a specified hand
	 * @param the hand that needs to be compared
	 * @return true if the hand beats a specified hand, false if not
	 */
	public boolean beats(Hand hand) {
		//adjust the rank in Card class
		//Since this.rank and card.rank are protected, create this_card and card_rank to denote the rank of the two comparing cards
		//temporarily change 'A' from rank 0 to rank 13
		//temporarily change '2' from rank 1 to rank 14
		int this_rank = this.getTopCard().getRank();
		int hand_rank = hand.getTopCard().getRank();
				
		if (this_rank == 0) {
			this_rank = 13;
		}
		if (this_rank == 1) {
					this_rank = 14;
		}
		if (hand_rank == 0) {
			hand_rank = 13;
		}
		if (hand_rank == 1) {
			hand_rank = 14;
		}
		if (hand.size() == 5) {
			if (this.getType()== "StraightFlush"
					&& hand.getType() != "StraightFlush") {
				return true;
			}
			else if (this.getType()== "Quad"
					&& hand.getType() != "Quad"
					&& hand.getType() != "StraightFlush") {
				return true;
			}
			else if (this.getType()== "FullHouse"
					&& hand.getType() != "FullHouse"
					&& hand.getType() != "Quad"
					&& hand.getType() != "StraightFlush") {
				return true;
			}
			else if (this.getType() == "Flush"
					&& hand.getType() != "Flush"
					&& hand.getType() != "FullHouse"
					&& hand.getType() != "Quad"
					&& hand.getType() != "StraightFlush") {
				return true;
			}
			else {
				if (this_rank == hand_rank) {
					if (this.getTopCard().getSuit() > hand.getTopCard().getSuit()) {
						return true;
					}
					else {
						return false;
					}
				}
				else if (this_rank > hand_rank) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		//if the two ranks are the same
		//then compare the suit
		if (this_rank == hand_rank) {
			if (this.getTopCard().getSuit() > hand.getTopCard().getSuit()) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (this_rank > hand_rank) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * a method for checking if this is a valid hand
	 * @return whether it is a valid hand
	 */
	public boolean isValid() {
		return false;
	}
	
	/**
	 * a method for returning a string specifying the type of this hand
	 * @return type
	 */
	public String getType() {
		return "";
	}
	

}
