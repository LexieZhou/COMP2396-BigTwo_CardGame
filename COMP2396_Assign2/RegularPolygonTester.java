
/**
 * The RegularPolygon class is a subclass of the Shape class and is used to model regular nsided
 * polygons. Besides the properties it inherited from the Shape class, the RegularPolygon
 * class also declares a number of private instance variables for storing the number of sides and
 * the radius of a polygon. It has public getters and setters for accessing its private instance
 * variables.
 * 
 * @author zhouzihan
 * @version 1.8
 */
public class RegularPolygonTester {
	
	/**
	 * 
	 * This method is set to verify the correctness of the RegularPolygon class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("This is a RugularPolygon class tester!");
		
		RegularPolygon r = new RegularPolygon(3, 40);
		
		//get an integer value specifying the number of sides of the regular n-sided polygon.
		System.out.println("Get the number of sides of the polygon: ");
		System.out.println(r.getNumOfSides());
		
		//get a double value specifying the radius of the regular n-sided polygon
		System.out.println("Get the radius of the polygon: ");
		System.out.println(r.getRadius());
		
		//change the sides of the polygon.
		System.out.println("Get the number of the changed sides of the polygon: ");
		r.setNumOfSides(6);
		System.out.println(r.getNumOfSides());
		
		//change the radius of the polygon.
		System.out.println("Get the changed radius of the polygon: ");
		r.setRadius(30);;
		System.out.println(r.getRadius());
		
		//check whether the point is inside the polygon
		System.out.println("Is the point inside the polygon?");
		System.out.println(r.contains(3, 4));
	}

}
