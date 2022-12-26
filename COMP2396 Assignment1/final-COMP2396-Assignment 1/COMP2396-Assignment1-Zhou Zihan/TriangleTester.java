import java.awt.Color;
/**
 * The TriangleTester is to verify whether Triangle class is correct.
 * 
 * @author zhouzihan
 * @version 1.8
 */
public class TriangleTester {
	/**
	 * This method set the Triangle class and print
	 * some output to verify the correctness of the Triangle class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("This is a triangle tester!");
		
		//Create a new triangle class
		Triangle triangle = new Triangle();
		
		//Set and check the triangle color
		triangle.color = new Color(0, 10, 100);
		if (triangle.color != new Color(0, 0, 0)) {
			System.out.println("Triangle color successfully set!");
		}
		
		//Fill and check the triangle class
		triangle.filled = true;
		if (triangle.filled == true) {
			System.out.println("Triangle color successfully filled!");
		}
		
		//Specify the orientation of the triangle in the screen  coordination system
		triangle.theta = 30;
		
		//Specify the x-coordinate and y-coordinate of the center 
		//of the triangle in the screen coordinate system
		triangle.xc = 3;
		triangle.yc = 4;
		
		//Specify two array of double values representing 
		//the x-coordinates and y-coordinates of the vertices of the triangle
		triangle.xLocal = new double[] {2, 4, 7};
		triangle.yLocal = new double[] {4, 3, 8};
		
		//Set the local-coordinates of the vertices of the triangle
		triangle.setVertices(20);
		
		//Translate the center of the triangle along the 
		//x and y directions of the screen coordinate system
		triangle.translate(20, 10);
		
		//rotate the triangle about its center by a certain angle
		triangle.rotate(40);
		
		//Retrieve the x-coordinates of the vertices by calling the getX method
		//and print them out respectively.
	    int[] listx = new int[triangle.xLocal.length];
	    listx = triangle.getX();
	    for (int i = 0; i < triangle.xLocal.length; i ++) {
	    	System.out.println("The newly get x-coordinate of the triangle is: " + listx[i]);
	    }
		
	    //Retrieve the y-coordinates of the vertices by calling the getY method
	  	//and print them out respectively.
	    int[] listy = new int[triangle.yLocal.length];
	    listy = triangle.getY();
	    for (int k = 0; k < triangle.yLocal.length; k++) {
	    	System.out.println("The newly get y-coordinate of the triangle is: "+ listy[k]);
	    }
	}

}
