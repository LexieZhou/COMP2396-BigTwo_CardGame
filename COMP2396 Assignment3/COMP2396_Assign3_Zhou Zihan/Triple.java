/**
 * Triple is a subclass of the Hand class 
 * and is used to model a hand of triple
 * 
 * @author zhouzihan
 *
 */
public class Triple extends Hand{
	private static final long serialVersionUID = -3711761437629470849L;
	/**
	 * a constructor for building a hand of triple
	 * with the specified player and list of cards
	 * 
	 * @param player
	 * @param cards
	 */
	public Triple(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}
	
	/**
	 * a method for retrieving the top card of this hand
	 * @return the top card
	 */
	public Card getTopCard() {
		this.sort();
		return this.getCard(2);
	}
	
	/**
	 * a method for checking if this is a valid hand
	 * @return true if its size is 3 and the rank of three cards are the same
	 * 	       otherwise return false 
	 */
	public boolean isValid() {
		if (this.size() == 3) {
			if (this.getCard(0).getRank() == this.getCard(1).getRank() && this.getCard(0).getRank() == this.getCard(2).getRank()) {
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
	
	/**
	 * returning a string specifying the Triple type
	 * @return Triple type
	 */
	public String getType() {
		return "Triple";
	}
}
