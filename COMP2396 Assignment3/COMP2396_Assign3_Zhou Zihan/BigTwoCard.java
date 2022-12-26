/**
 * The BigTwoCard class is a subclass of the Card class
 * and is used to model a card used in a Big Two card game.
 * It should override the compareTo() method it inherits from the Card class 
 * to reflect the ordering of cards used in a Big Two card game. 
 * 
 * @author zhouzihan
 *
 */
public class BigTwoCard extends Card{
	private static final long serialVersionUID = -713898713776577970L;
	/**
	 * a constructor for building a card with the specified suit and rank
	 * suit is an integer between 0 and 3
	 * rank is an integer between 0 and 12
	 * @param suit an int value between 0 and 3 representing the suit of a card:
	 *             <p>
	 *             0 = Diamond, 1 = Club, 2 = Heart, 3 = Spade
	 * @param rank an int value between 0 and 12 representing the rank of a card:
	 *             <p>
	 *             1 = '3', ..., 8 = '9', 9 = '0', 10 = 'J', 11 =
	 *             'Q', 12 = 'K', 13 = 'A', 14 = '2'
	 */
	public BigTwoCard(int suit, int rank) {
		super(suit, rank);
	}
	
	/**
	 * Compares this card with the specified card for order.
	 * 
	 * @param card the card to be compared
	 * @return a negative integer, zero, or a positive integer as this card is less
	 *         than, equal to, or greater than the specified card
	 */
	public int compareTo(Card card) {
		//adjust the rank in Card class
		//Since this.rank and card.rank are protected, create this_card and card_rank to denote the rank of the two comparing cards
		//temporarily change 'A' from rank 0 to rank 13
		//temporarily change '2' from rank 1 to rank 14
		int this_rank = this.rank;
		int card_rank = card.rank;
		
		if (this_rank == 0) {
			this_rank = 13;
		}
		if (this_rank == 1) {
			this_rank = 14;
		}
		if (card_rank == 0) {
			card_rank = 13;
		}
		if (card_rank == 1) {
			card_rank = 14;
		}
		//compare the two card
		//first compare the rank then compare the suit
		if (this_rank > card_rank) {
			return 1;
		} else if (this_rank < card_rank) {
			return -1;
		} else if (this.suit > card.suit) {
			return 1;
		} else if (this.suit < card.suit) {
			return -1;
		} else {
			return 0;
		}
	}
	
}
