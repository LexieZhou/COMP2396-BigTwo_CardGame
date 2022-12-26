/**
 * The Circle class is used to model circles.
 * It is a subclass of the Shape class and it inherits all the instance variables
 * and methods of the Shape class.
 * 
 * @author zhouzihan
 * @version 1.8
 */
public class Circle extends Shape{
	
	/**
	 * A method for setting the local coordinates of the
	 * upper left and lower right vertices of an axis-aligned
	 * bounding box of a standard circle
	 * as well as the getX() and getY() methods for retrieving the
	 * screen coordinates.
	 * 
	 * It overrides the setVertices() methods in Shape class.
	 * 
	 * @param d specify the radius of a standard circle
	 */
	public void setVertices(double d) {
		//an array of double values specifying the x-coordinates of the vertices of the circle
		xLocal = new double[] {-d, d};
		
		//an array of double values specifying the y-coordinates of the vertices of the circle
		yLocal = new double[] {-d, d};
	}
	
	/**
     * a method to retrieve the x-coordinates of the vertices in its local coordinate system
     * 
     * @return the x-coordinates of the upper left and lower right vertices
     * of an axis-aligned bounding box of the circle in the screen coordinate system
     */
	public int[] getX() {
		int num;
    	num = xLocal.length;
    	int[] screenx = new int[num];
    	for (int i = 0; i < num; i++) {
    		screenx[i] = (int) Math.round(xLocal[i]+xc);
    	}
    	return screenx;
	}
	
	/**
     * a method to retrieve the y-coordinates of the vertices in its local coordinate system
     * 
     * @return the y-coordinates of the upper left and lower right vertices
     * of an axis-aligned bounding box of the circle in the screen coordinate system
     */	
    public int[] getY() {
    	int num;
        num = yLocal.length;
        int[] screeny = new int[num];
        for (int i = 0; i < num; i++) {
        	screeny[i] = (int) Math.round(yLocal[i]+yc);
        }
        return screeny;
    }
}
