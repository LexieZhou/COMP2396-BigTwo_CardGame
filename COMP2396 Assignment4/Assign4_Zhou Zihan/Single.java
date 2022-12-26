
/**
 * Single is a subclass of the Hand class 
 * and is used to model a hand of single
 * 
 * @author zhouzihan
 *
 */
public class Single extends Hand{
	private static final long serialVersionUID = -3711761437629470849L;
	/**
	 * a constructor for building a hand of single
	 * with the specified player and list of cards
	 * 
	 * @param player
	 * @param cards
	 */
	public Single(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}
	
	/**
	 * a method for retrieving the top card of this hand
	 * @return the top card
	 */
	public Card getTopCard() {
		return this.getCard(0);
	}
	
	/**
	 * a method for checking if this is a valid hand
	 * @return true if its size is 1, which is a valid hand
	 * 	       false if its size is not 1, which is a invalid hand
	 */
	public boolean isValid() {
		if (this.size() == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * returning a string specifying the single type
	 * @return single type
	 */
	public String getType() {
		return "Single";
	}
}
