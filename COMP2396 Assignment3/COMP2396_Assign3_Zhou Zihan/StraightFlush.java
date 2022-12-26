import java.util.ArrayList;
/**
 * StraightFlush is a subclass of the StraightFlush class 
 * and is used to model a hand of StraightFlush
 * 
 * @author zhouzihan
 *
 */
public class StraightFlush extends Hand{
	private static final long serialVersionUID = -3711761437629470849L;
	/**
	 * a constructor for building a hand of StraightFlush
	 * with the specified player and list of cards
	 * 
	 * @param player
	 * @param cards
	 */
	public StraightFlush(CardGamePlayer player, CardList cards) {
		super(player, cards);
	}
	
	/**
	 * a method for retrieving the top card of this hand
	 * @return the top card
	 */
	public Card getTopCard() {
		this.sort();
		return this.getCard(4);
	}
	
	/**
	 * a method for checking if this is a valid hand
	 * @return true if cards consists of five consecutive cards of the same suit
	 * 	       false otherwise
	 */
	public boolean isValid() {
		//firstly check the size of the card
		if (this.size() != 5 ) {
			return false;
		}
		else {
			this.sort();
			
			//set an integer list that stores the rank
			//simultaneously change the rank of 'A' from 0 to 13
			//the rank of '2' from 1 to 14
			ArrayList<Integer> rankList = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				if (this.getCard(i).getRank() == 0) {
					rankList.add(13);
				}
				else if (this.getCard(i).getRank() == 1) {
					rankList.add(14);
				}
				else {
					rankList.add(this.getCard(i).getRank());
				}
			}
			
			if (this.getCard(0).getSuit()!=this.getCard(1).getSuit() 
					|| this.getCard(0).getSuit()!=this.getCard(2).getSuit()
					|| this.getCard(0).getSuit()!=this.getCard(3).getSuit()
					|| this.getCard(0).getSuit()!=this.getCard(4).getSuit()) {
				return false;
			}
			else {
				if(rankList.get(0)+1 != rankList.get(1)
						|| rankList.get(0)+2 != rankList.get(2)
						|| rankList.get(0)+3 != rankList.get(3)
						|| rankList.get(0)+4 != rankList.get(4) ){
					return false;
				}
				else {
					return true;
				}
			}
		}
	}

	
	/**
	 * returning a string specifying the StraightFlush type
	 * @return StraightFlush type
	 */
	public String getType() {
		return "StraightFlush";
	}
}

