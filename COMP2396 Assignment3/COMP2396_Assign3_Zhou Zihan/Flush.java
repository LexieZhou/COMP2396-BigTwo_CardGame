
/**
 * Flush is a subclass of the Hand class 
 * and is used to model a hand of flush
 * 
 * @author zhouzihan
 *
 */
public class Flush extends Hand{
	private static final long serialVersionUID = -3711761437629470849L;
	/**
	 * a constructor for building a hand of flush
	 * with the specified player and list of cards
	 * 
	 * @param player
	 * @param cards
	 */
	public Flush(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}
	
	/**
	 * a method for retrieving the top card of this hand
	 * @return the top card
	 */
	public Card getTopCard() {
		return this.getCard(4);
	}
	
	/**
	 * a method for checking if this is a valid hand
	 * @return true if their suits are the same
	 * 	       false otherwise
	 */
	public boolean isValid() {
		//firstly check the size of the card
		if (this.size() != 5 ) {
			return false;
		}
		else {
			if (this.getCard(0).getSuit()==this.getCard(1).getSuit() 
					&& this.getCard(0).getSuit()==this.getCard(2).getSuit()
					&& this.getCard(0).getSuit()==this.getCard(3).getSuit()
					&& this.getCard(0).getSuit()==this.getCard(4).getSuit()) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	
	/**
	 * returning a string specifying the flush type
	 * @return flush type
	 */
	public String getType() {
		return "Flush";
	}
}

