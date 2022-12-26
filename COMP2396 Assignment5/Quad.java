/**
 * FullHouse is a subclass of the Quad class 
 * and is used to model a hand of Quad
 * 
 * @author zhouzihan
 *
 */
public class Quad extends Hand{
	private static final long serialVersionUID = -3711761437629470849L;
	/**
	 * a constructor for building a hand of Quad
	 * with the specified player and list of cards
	 * 
	 * @param player
	 * @param cards
	 */
	public Quad(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}
	
	/**
	 * a method for retrieving the top card of this hand
	 * @return the top card
	 */
	public Card getTopCard() {
		this.sort();
		//the circumstance that the first four cards are of the same number
		//return the first card that denotes one of the same four cards
		if (this.getCard(0).getRank()==this.getCard(1).getRank() 
				&& this.getCard(0).getRank()==this.getCard(2).getRank()
				&& this.getCard(0).getRank()==this.getCard(3).getRank()) {
			return this.getCard(0);
		}
		//the circumstance that the last four cards are of the same number
		//return the last card that denotes one of the same four cards
		else {
			return this.getCard(4);
		}
	}
	
	/**
	 * a method for checking if this is a valid hand
	 * @return true if are made up of all four cards of one rank
	 * 			plus any fifth card
	 * 	       false otherwise
	 */
	public boolean isValid() {
		//firstly check the size of the card
		if (this.size() != 5 ) {
			return false;
		}
		else {
			this.sort();
			//the circumstance that the first four cards are of the same number
			if (this.getCard(0).getRank()==this.getCard(1).getRank() 
					&& this.getCard(0).getRank()==this.getCard(2).getRank()
					&& this.getCard(0).getRank()==this.getCard(3).getRank()) {
				return true;
			}
			//the circumstance that the last four cards are of the same number
			else if(this.getCard(4).getRank()==this.getCard(1).getRank() 
					&& this.getCard(4).getRank()==this.getCard(2).getRank()
					&& this.getCard(4).getRank()==this.getCard(3).getRank()){
				return true;
			}
			else {
				return false;
			}
		}
	}

	
	/**
	 * returning a string specifying the Quad type
	 * @return Quad type
	 */
	public String getType() {
		return "Quad";
	}
}
