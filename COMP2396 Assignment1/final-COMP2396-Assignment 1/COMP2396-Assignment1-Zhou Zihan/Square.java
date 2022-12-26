/**
 * The Square class is used to model squares.
 * It is a subclass of the Shape class and it inherits all the instance variables
 * and methods of the Shape class.
 * 
 * @author zhouzihan
 * @version 1.8
 */

public class Square extends Shape{

	/**
	 * A method for setting the local coordinates of the 4 vertices of a standard square
	 * It overrides the setVertices() methods in Shape class.
	 * 
	 * @param d specify half-the-length of a side of the square
	 */
	public void setVertices(double d) {
		//an array of double values specifying the x-coordinates of the vertices of the square
		xLocal = new double[] {d, d, -d, -d};
		
		//an array of double values specifying the y-coordinates of the vertices of the square
		yLocal = new double[] {d, -d, -d, d};
	}

}
