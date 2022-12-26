/**
 * FullHouse is a subclass of the Hand class 
 * and is used to model a hand of FullHouse
 * 
 * @author zhouzihan
 *
 */
public class FullHouse extends Hand{
	private static final long serialVersionUID = -3711761437629470849L;
	/**
	 * a constructor for building a hand of FullHouse
	 * with the specified player and list of cards
	 * 
	 * @param player
	 * @param cards
	 */
	public FullHouse(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}
	
	/**
	 * a method for retrieving the top card of this hand
	 * @return the top card
	 */
	public Card getTopCard() {
		this.sort();
		
		//the circumstance that the first three cards have the same number
		//and the last two cards have the same number
		//return the top card that denotes one of the same three cards
		if (this.getCard(0).getRank() == this.getCard(1).getRank()
				&& this.getCard(0).getRank() == this.getCard(2).getRank()) {
			return this.getCard(0);
		}
		//the circumstance that the first two cards have the same number
		//and the last three cards have the same number
		//return the last card that denotes one of the same three cards
		else {
			return this.getCard(4);
		}	
	}
	
	/**
	 * a method for checking if this is a valid hand
	 * @return true if any three cards of the same number or face value
	 * 			plus any other two cards of the same number or face value
	 * 	       false otherwise
	 */
	public boolean isValid() {
		//firstly check the size of the card
		if (this.size() != 5 ) {
			return false;
		}
		else {
			//sort the card
			this.sort();
			//the circumstance that the first three cards have the same number
			//and the last two cards have the same number
			if (this.getCard(0).getRank() == this.getCard(1).getRank()
					&& this.getCard(0).getRank() == this.getCard(2).getRank()) {
				if (this.getCard(3).getRank() == this.getCard(4).getRank()) {
					return true;
				}
				else {
					return false;
				}
			}
			//the circumstance that the first two cards have the same number
			//and the last three cards have the same number
			else if (this.getCard(2).getRank() == this.getCard(3).getRank()
						&& this.getCard(2).getRank() == this.getCard(3).getRank()) {
				if (this.getCard(0).getRank() == this.getCard(1).getRank()) {
					return true;
				}
				else {
					return false;
				}	
			}
			else {
				return false;
			}
		}
	}

	
	/**
	 * returning a string specifying the FullHouse type
	 * @return FullHouse type
	 */
	public String getType() {
		return "FullHouse";
	}

}
