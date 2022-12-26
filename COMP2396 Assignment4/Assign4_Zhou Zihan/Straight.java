import java.util.*;
/**
 * Straight is a subclass of the Hand class 
 * and is used to model a hand of Straight
 * 
 * @author zhouzihan
 *
 */
public class Straight extends Hand{
	private static final long serialVersionUID = -3711761437629470849L;
	/**-
	 * a constructor for building a hand of Straight
	 * with the specified player and list of cards
	 * 
	 * @param player
	 * @param cards
	 */
	public Straight(CardGamePlayer player, CardList cards) {
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
	 * @return true if its size is 5 and the rank of five cards are consecutive
	 * 	       otherwise return false 
	 */
	public boolean isValid() {	
		//create an arraylist to store the updated rank
		ArrayList<Integer> compare_list = new ArrayList<Integer>();
		
		//firstly check the size
		if (this.size() != 5) {
			return false;
		}
		else {
			//check the sequence of the cards 
			//change the rank of 'A' and '2'
			//from 0 and 1 to 13 and 14
			for (int i = 0; i < 5; i++) {
				if (this.getCard(i).getRank() == 0) {
					compare_list.add(13);
				}
				else if (this.getCard(i).getRank() == 1) {
					compare_list.add(14);
				}
				else {
					compare_list.add(this.getCard(i).getRank());
				}
			}
			//sort the arraylist
			Collections.sort(compare_list);
			for (int k = 1; k < 5; k++) {
				if (compare_list.get(k) != compare_list.get(k-1) + 1) {
					return false;
				}
				else {
					k++;
				}
			}
			return true;
		}
	}
	
	/**
	 * returning a string specifying the Straight type
	 * @return Straight type
	 */
	public String getType() {
		return "Straight";
	}

}
