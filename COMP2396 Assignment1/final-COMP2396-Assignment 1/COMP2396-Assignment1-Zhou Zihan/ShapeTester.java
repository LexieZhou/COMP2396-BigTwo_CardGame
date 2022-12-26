import java.awt.Color;
/**
 * The ShapeTester class is used to verify whether Shape class is correct.
 * 
 * @author zhouzihan
 * @version 1.8
 *
 */

public class ShapeTester {
	/**
	 * This method set the Shape class
	 * and print some output to verify the correctness of Shape class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("This is a shape tester!");
		
		//Creating a shape class
		Shape shape = new Shape();
		
		//Set and check the shape color
		shape.color = new Color(100, 100, 0);
		if (shape.color != new Color(0, 0, 0)) {
			System.out.println("Shape color successfully set!");
		}
		
		//Fill and check the shape
		shape.filled = true;
		if (shape.filled == true) {
			System.out.println("Shape color successfully filled!");
		}
		
		//Specify the orientation of the shape in the screen  coordination system
		shape.theta = 35;
		
		//Specify the x-coordinate and y-coordinate of the center 
		//of the shape in the screen coordinate system
		shape.xc = 20;
		shape.yc = 30;
		
		//Specify two array of double values representing 
		//the x-coordinates and y-coordinates of the vertices
		shape.xLocal = new double[] {1, 2, 4, 7};
		shape.yLocal = new double[] {2, 4, 3, 8};  
		
		//Set the local-coordinates of the vertices of the shape
		shape.setVertices(30);
		
		//Translate the center of the shape along the 
		//x and y directions of the screen coordinate system
		shape.translate(20, 10);
		
		//rotate the shape about its center by a certain angle
		shape.rotate(40);
		
		//Retrieve the x-coordinates of the vertices by calling the getX method
		//and print them out respectively.
	    int[] listx = new int[shape.xLocal.length];
	    listx = shape.getX();
	    for (int i = 0; i < shape.xLocal.length; i ++) {
	    	System.out.println("The newly get x-coordinate is: " + listx[i]);
	    }
		
	    //Retrieve the y-coordinates of the vertices by calling the getY method
	    //and print them out respectively.
	    int[] listy = new int[shape.yLocal.length];
	    listy = shape.getY();
	    for (int k = 0; k < shape.yLocal.length; k++) {
	    	System.out.println("The newly get y-coordinate is: "+ listy[k]);
	    }
		
		
		
	}

}
