/**
 * The BigTwoDeck class is a subclass of the Deck class 
 * and is used to model a deck of cards used in a Big Two card game. 
 * It should override the initialize() method it inherits from the
 * Deck class to create a deck of Big Two cards.
 * 
 * @author zhouzihan
 *
 */
public class BigTwoDeck extends Deck{
	private static final long serialVersionUID = -3886066435694112173L;
	/**
	 * initialize the big two deck
	 */
	public void initialize() {
		
		//remove the previous cards
		removeAllCards();
		//create big two cards and add them to the deck
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				BigTwoCard BigTwoCard = new BigTwoCard(i, j);
				addCard(BigTwoCard);
			}
		}
	}
}
