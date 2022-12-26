/**
 * BigTwoDeckTester is a class used to verify whether BigTwoDeck class is correct
 * 
 * @author zhouzihan
 *
 */
public class BigTwoDeckTester {
	
	public static void main(String[] args) {
		// Prepare a Big Two Deck
		BigTwoDeck deck = new BigTwoDeck();
		
		System.out.println(
				"=== Are you going to cheat with an illegal deck? ==="
		);
		System.out.println("-----");
		
		//get deck size
		System.out.println(
				"How many cards are there (Expected: 52)?"+
				deck.size()
		);
		System.out.println("-----");
		
		//get class
		System.out.println(
				"What cards are you using (Expected: BigTwoCard)? "+
				deck.getCard(0).getClass()
		);
		System.out.println("-----");
		
		System.out.println(
				"Just to make sure, Ace of spades is not the top card in your deck. "
		);
		//compare cards
		System.out.println(String.format(
				"Is %s stronger than %s (Expected: -1)? %d",
				deck.getCard(39), deck.getCard(40), deck.getCard(39).compareTo(deck.getCard(40))
		));
		System.out.println("-----");
		System.out.println("-----");
		//More tests, took longer than actually playing one Big Two game ...
		System.out.println("...");
		System.out.println("-----");
		
		System.out.println("I don't believe you! Let me check all your cards!");
		
		//print the deck
		deck.print();

	}

}
