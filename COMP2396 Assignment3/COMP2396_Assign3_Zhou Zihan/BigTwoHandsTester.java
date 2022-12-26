/**
 * BigTwoHandsTester is used to verify whether the BigTwoHands is correct
 * 
 * @author zhouzihan
 *
 */
public class BigTwoHandsTester {
	//Create two dummy players and prepare them different hand for testing later
	private static CardGamePlayer p1 = new CardGamePlayer("1P");
	private static CardGamePlayer p2 = new CardGamePlayer("2P");
	
	public static void main(String[] args) {
		//create two cardlist
		CardList cards1, cards2;
		
		/**
		 * Attempt to test single hands
		 */
		//Player1: a single card of diamond 3
		cards1 = new CardList();
		cards1.addCard(new BigTwoCard(0, 2));  //3d
		Hand single_h1 = new Single(p1, cards1);
		System.out.println("1P plays "+ single_h1.getType() + " :");
		cards1.print();
		//check the isValid function
		if (single_h1.isValid() == true) {
			System.out.println("Cards1 is a single hand.");
		}
		else {
			System.out.println("Cards1 is not a single hand.");
		}
		
		//Player2: a single card of heart 2
		cards2 = new CardList();
		cards2.addCard(new BigTwoCard(2, 1));   //2h
		Hand single_h2 = new Single(p2, cards2);
		System.out.println("2P plays " + single_h2.getType()+" :");
		cards2.print();
		//check the isValid function
		if (single_h2.isValid() == true) {
			System.out.println("Cards2 is a single hand.");
		}
		else {
			System.out.println("Cards2 is not a single hand.");
		}
		
		//compare the two hands
		//when static method composeHand() is well implemented in BigTwo
		//The code would be better to be modified
		//The following comparing method can be directly replaced by
		//composeAndCompare(cards1, cards2);
		if (single_h1.beats(single_h2)) {
			System.out.println("1P wins!");
		}
		else {
			System.out.println("1P dose not beat 2P.");
		}	
			System.out.println("=====");
		
		/**
		 * Attempt to test pair hands
		 */
		//Player1: a pair of 3s
		cards1 = new CardList();
		cards1.addCard(new BigTwoCard(0, 2));  //3d
		cards1.addCard(new BigTwoCard(1, 2));  //3c
		Hand pair_h1 = new Pair(p1, cards1);
		System.out.println("1P plays "+ pair_h1.getType() + " :");
		cards1.print();
		//check the isValid function
		if (pair_h1.isValid() == true) {
			System.out.println("Cards1 is a pair hand.");
		}
		else {
			System.out.println("Cards1 is not a pair hand.");
		}
		
		//Player2: a pair of 2s
		cards2 = new CardList();
		cards2.addCard(new BigTwoCard(3, 1));   //2s
		cards2.addCard(new BigTwoCard(2, 1));   //2h
		Hand pair_h2 = new Pair(p2, cards2);
		System.out.println("2P plays " + pair_h2.getType()+" :");
		cards2.print();
		//check the isValid function
		if (pair_h2.isValid() == true) {
			System.out.println("Cards2 is a pair hand.");
		}
		else {
			System.out.println("Cards2 is not a pair hand.");
		}
		
		//compare the two hands
		if (pair_h1.beats(pair_h2)) {
			System.out.println("1P wins!");
		}
		else {
			System.out.println("1P dose not beat 2P.");
		}
		
		System.out.println("=====");
		
		/**
		 * Attempt to test Triple hands
		 */
		//Player1: a triple of As
		cards1 = new CardList();
		cards1.addCard(new BigTwoCard(0, 0));  //Ad
		cards1.addCard(new BigTwoCard(1, 0));  //Ac
		cards1.addCard(new BigTwoCard(2, 0));  //Ah
		Hand triple_h1 = new Triple(p1, cards1);
		System.out.println("1P plays "+ triple_h1.getType() + " :");
		cards1.print();
		//check the isValid function
		if (triple_h1.isValid() == true) {
			System.out.println("Cards1 is a triple hand.");
		}
		else {
			System.out.println("Cards1 is not a triple hand.");
		}
		
		//Player2: a triple of 6s
		cards2 = new CardList();
		cards2.addCard(new BigTwoCard(3, 5));   //6s
		cards2.addCard(new BigTwoCard(2, 5));   //6h
		cards2.addCard(new BigTwoCard(1, 5));   //6c
		Hand triple_h2 = new Triple(p2, cards2);
		System.out.println("2P plays " + triple_h2.getType()+" :");
		cards2.print();
		//check the isValid function
		if (triple_h2.isValid() == true) {
			System.out.println("Cards2 is a triple hand.");
		}
		else {
			System.out.println("Cards2 is not a triple hand.");
		}
		//compare the two hands
		if (triple_h1.beats(triple_h2)) {
			System.out.println("1P wins!");
		}
		else {
			System.out.println("1P dose not beat 2P.");
		}
		
		System.out.println("=====");
		
		/**
		 * Attempt to test Straight hands
		 */
		//Player1: a sequence of straight cards
		cards1 = new CardList();
		cards1.addCard(new BigTwoCard(1, 1));  //2c
		cards1.addCard(new BigTwoCard(2, 12)); //Kh
		cards1.addCard(new BigTwoCard(3, 11)); //Qs
		cards1.addCard(new BigTwoCard(3, 10)); //Js
		cards1.addCard(new BigTwoCard(0, 0));  //Ad
		Hand straight_h1 = new Straight(p1, cards1);
		System.out.println("1P plays "+ straight_h1.getType() + " :");
		cards1.print();
		//check the isValid function
		if (straight_h1.isValid() == true) {
			System.out.println("Cards1 is a straight hand.");
		}
		else {
			System.out.println("Cards1 is not a Straight hand.");
		}
		
		//Player2: a sequence of straight cards
		cards2 = new CardList();
		cards2.addCard(new BigTwoCard(3, 5));   //6s
		cards2.addCard(new BigTwoCard(2, 4));   //5h
		cards2.addCard(new BigTwoCard(1, 3));   //4c
		cards2.addCard(new BigTwoCard(0, 2));   //3d
		cards2.addCard(new BigTwoCard(3, 6));   //7s
		Hand straight_h2 = new Straight(p2, cards2);
		System.out.println("2P plays " + straight_h2.getType()+" :");
		cards2.print();
		//check the isValid function
		if (straight_h2.isValid() == true) {
			System.out.println("Cards2 is a straight hand.");
		}
		else {
			System.out.println("Cards2 is not a straight hand.");
		}
		//compare the two hands
		if (straight_h1.beats(straight_h2)) {
			System.out.println("1P wins!");
		}
		else {
			System.out.println("1P dose not beat 2P.");
		}
		
		System.out.println("=====");
		
		/**
		 * Attempt to test Flush hands
		 */
		//Player1: a sequence of flush cards
		cards1 = new CardList();
		cards1.addCard(new BigTwoCard(3, 1));  //2s
		cards1.addCard(new BigTwoCard(3, 12)); //Ks
		cards1.addCard(new BigTwoCard(3, 11)); //Qs
		cards1.addCard(new BigTwoCard(3, 10)); //Js
		cards1.addCard(new BigTwoCard(3, 6));  //7s
		Hand flush_h1 = new Flush(p1, cards1);
		System.out.println("1P plays "+ flush_h1.getType() + " :");
		cards1.print();
		//check the isValid function
		if (flush_h1.isValid() == true) {
			System.out.println("Cards1 is a flush hand.");
		}
		else {
			System.out.println("Cards1 is not a flush hand.");
		}
		
		//Player2: a sequence of straight cards
		cards2 = new CardList();
		cards2.addCard(new BigTwoCard(2, 5));   //6h
		cards2.addCard(new BigTwoCard(2, 4));   //5h
		cards2.addCard(new BigTwoCard(2, 3));   //4h
		cards2.addCard(new BigTwoCard(2, 2));   //3h
		cards2.addCard(new BigTwoCard(2, 6));   //7h
		Hand flush_h2 = new Straight(p2, cards2);
		System.out.println("2P plays " + flush_h2.getType()+" :");
		cards2.print();
		//check the isValid function
		if (flush_h2.isValid() == true) {
			System.out.println("Cards2 is a flush hand.");
		}
		else {
			System.out.println("Cards2 is not a flush hand.");
		}
		//compare the two hands
		if (flush_h1.beats(flush_h2)) {
			System.out.println("1P wins!");
		}
		else {
			System.out.println("1P dose not beat 2P.");
		}
		
		System.out.println("=====");
		
		/**
		 * Attempt to test FullHouse hands
		 */
		//Player1: a sequence of FullHouse cards
		cards1 = new CardList();
		cards1.addCard(new BigTwoCard(3, 1));  //2s
		cards1.addCard(new BigTwoCard(2, 1));  //2h
		cards1.addCard(new BigTwoCard(1, 1)); //2c
		cards1.addCard(new BigTwoCard(3, 10)); //Js
		cards1.addCard(new BigTwoCard(2, 10));  //Jh
		Hand FullHouse_h1 = new FullHouse(p1, cards1);
		System.out.println("1P plays "+ FullHouse_h1.getType() + " :");
		cards1.print();
		//check the isValid function
		if (FullHouse_h1.isValid() == true) {
			System.out.println("Cards1 is a FullHouse hand.");
		}
		else {
			System.out.println("Cards1 is not a FullHouse hand.");
		}
		
		//Player2: a sequence of FullHouse cards
		cards2 = new CardList();
		cards2.addCard(new BigTwoCard(2, 5));   //6h
		cards2.addCard(new BigTwoCard(3, 5));   //6s
		cards2.addCard(new BigTwoCard(1, 5));   //6c
		cards2.addCard(new BigTwoCard(2, 1));   //2h
		cards2.addCard(new BigTwoCard(3, 1));   //2s
		Hand FullHouse_h2 = new FullHouse(p2, cards2);
		System.out.println("2P plays " + FullHouse_h2.getType()+" :");
		cards2.print();
		//check the isValid function
		if (FullHouse_h2.isValid() == true) {
			System.out.println("Cards2 is a FullHouse hand.");
		}
		else {
			System.out.println("Cards2 is not a FullHouse hand.");
		}
		//compare the two hands
		if (FullHouse_h1.beats(FullHouse_h2)) {
			System.out.println("1P wins!");
		}
		else {
			System.out.println("1P dose not beat 2P.");
		}
		
		System.out.println("=====");
		
		/**
		 * Attempt to test Quad hands
		 */
		//Player1: a sequence of Quad cards
		cards1 = new CardList();
		cards1.addCard(new BigTwoCard(3, 2));  //3s
		cards1.addCard(new BigTwoCard(2, 2));  //3h
		cards1.addCard(new BigTwoCard(1, 2));  //3c
		cards1.addCard(new BigTwoCard(0, 2));  //3d
		cards1.addCard(new BigTwoCard(2, 1));  //2h
		Hand Quad_h1 = new Quad(p1, cards1);
		System.out.println("1P plays "+ Quad_h1.getType() + " :");
		cards1.print();
		//check the isValid function
		if (Quad_h1.isValid() == true) {
			System.out.println("Cards1 is a Quad hand.");
		}
		else {
			System.out.println("Cards1 is not a Quad hand.");
		}
		
		//Player2: a sequence of FullHouse cards
		cards2 = new CardList();
		cards2.addCard(new BigTwoCard(2, 0));   //Ah
		cards2.addCard(new BigTwoCard(3, 0));   //As
		cards2.addCard(new BigTwoCard(1, 0));   //Ac
		cards2.addCard(new BigTwoCard(0, 0));   //Ad
		cards2.addCard(new BigTwoCard(3, 1));   //2s
		Hand Quad_h2 = new Quad(p2, cards2);
		System.out.println("2P plays " + Quad_h2.getType()+" :");
		cards2.print();
		//check the isValid function
		if (Quad_h2.isValid() == true) {
			System.out.println("Cards2 is a Quad hand.");
		}
		else {
			System.out.println("Cards2 is not a Quad hand.");
		}
		//compare the two hands
		if (Quad_h1.beats(Quad_h2)) {
			System.out.println("1P wins!");
		}
		else {
			System.out.println("1P dose not beat 2P.");
		}
		
		System.out.println("=====");
		
		/**
		 * Attempt to test StraightFlush hands
		 */
		//Player1: a sequence of StraightFlush cards
		cards1 = new CardList();
		cards1.addCard(new BigTwoCard(2, 5));  //6h
		cards1.addCard(new BigTwoCard(2, 4));  //5h
		cards1.addCard(new BigTwoCard(2, 3));  //4h
		cards1.addCard(new BigTwoCard(2, 6));  //7h
		cards1.addCard(new BigTwoCard(2, 7));  //8h
		Hand StraightFlush_h1 = new StraightFlush(p1, cards1);
		System.out.println("1P plays "+ StraightFlush_h1.getType() + " :");
		cards1.print();
		//check the isValid function
		if (StraightFlush_h1.isValid() == true) {
			System.out.println("Cards1 is a StraightFlush hand.");
		}
		else {
			System.out.println("Cards1 is not a StraightFlush hand.");
		}
		
		//Player2: a sequence of StraightFlush cards
		cards2 = new CardList();
		cards2.addCard(new BigTwoCard(3, 11));   //Qs
		cards2.addCard(new BigTwoCard(3, 12));   //Ks
		cards2.addCard(new BigTwoCard(3, 10));   //Js
		cards2.addCard(new BigTwoCard(3, 0));   //As
		cards2.addCard(new BigTwoCard(3, 1));   //2s
		Hand StraightFlush_h2 = new StraightFlush(p2, cards2);
		System.out.println("2P plays " + StraightFlush_h2.getType()+" :");
		cards2.print();
		//check the isValid function
		if (StraightFlush_h2.isValid() == true) {
			System.out.println("Cards2 is a StraightFlush hand.");
		}
		else {
			System.out.println("Cards2 is not a StraightFlush hand.");
		}
		//compare the two hands
		if (StraightFlush_h1.beats(StraightFlush_h2)) {
			System.out.println("1P wins!");
		}
		else {
			System.out.println("1P dose not beat 2P.");
		}
		
		System.out.println("=====");
		
		
			
		
	}

}
