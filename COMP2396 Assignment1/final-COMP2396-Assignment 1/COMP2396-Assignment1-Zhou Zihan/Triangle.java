/**
 * The Triangle class is used to model triangles.
 * It is a subclass of the Shape class and it inherits all the
 * instance variables and methods of the Shape class.
 * 
 * @author zhouzihan
 * @version 1.8
 */
public class Triangle extends Shape{
	/**
	 * A method for setting the local coordinates of the 3 vertices of a standard triangle
	 * It overrides the setVertices() methods in Shape class.
	 * 
	 * @param d specifying the distance from the center of the triangle to any of its vertices
	 */
	public void setVertices(double d) {
		//an array of double values specifying the x-coordinates of the vertices of the triangle
		xLocal = new double[] {d, -d*Math.cos(Math.PI/3), -d*Math.cos(Math.PI/3)};
		
		//an array of double values specifying the y-coordinates of the vertices of the triangle
		yLocal = new double[] {0, -d*Math.sin(Math.PI/3), d*Math.sin(Math.PI/3)};
	}
}
