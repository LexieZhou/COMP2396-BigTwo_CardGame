/**
 * Pair is a subclass of the Hand class 
 * and is used to model a hand of pair
 * 
 * @author zhouzihan
 *
 */
public class Pair extends Hand{
	private static final long serialVersionUID = -3711761437629470849L;
	/**
	 * a constructor for building a hand of pair
	 * with the specified player and list of cards
	 * 
	 * @param player
	 * @param cards
	 */
	public Pair(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}
	
	/**
	 * a method for retrieving the top card of this hand
	 * @return the top card
	 */
	public Card getTopCard() {
		this.sort();
		return this.getCard(1);
	}
	
	/**
	 * a method for checking if this is a valid hand
	 * @return true if its size is 2, and the rank of two cards is the same
	 * 	       otherwise return false
	 */
	public boolean isValid() {
		if (this.size() == 2) {
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
	
	/**
	 * returning a string specifying the pair type
	 * @return pair type
	 */
	public String getType() {
		return "Pair";
	}
}
