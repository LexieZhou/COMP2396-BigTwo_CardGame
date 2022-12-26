/**
 * The BigTwoCardTester a class used to verify whether BigTwoCard is correct.
 * 
 * @author zhouzihan
 *
 */
public class BigTwoCardTester {

	public static void main(String[] args) {
		System.out.println();
		
		//Creating big two cards
		BigTwoCard _3d = new BigTwoCard(0, 2); //Three of Diamonds
		BigTwoCard _Kh = new BigTwoCard(2, 12); //King o Hearts
		BigTwoCard _Ac = new BigTwoCard(1, 0); //Ace of Clubs
		BigTwoCard _2s = new BigTwoCard(3, 1); //Two of Spades
		
		System.out.println("-----");
		System.out.println(
				"Is 3d stronger than 2s (Expected: -1)? " +
				_3d.compareTo(_2s)
		);
		
		System.out.println("-----");
		System.out.println(
				"Is 3d stronger than 3d (Expected: 0)? " +
				_3d.compareTo(_3d)
		);
		
		System.out.println("-----");
		System.out.println(
				"Is Ac stronger than Kh (Expected: 1)? " +
				_Ac.compareTo(_Kh)
		);
		
		System.out.println("-----");
		System.out.println(
				"Is Kc stronger than Ac (Expected: -1)? " +
				_Kh.compareTo(_Ac)
		);
		
		

	}

}
