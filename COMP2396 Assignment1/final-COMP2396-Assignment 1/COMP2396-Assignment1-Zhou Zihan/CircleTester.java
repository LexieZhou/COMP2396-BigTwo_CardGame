import java.awt.Color;
/**
 * The CircleTest class is used to verify whether Circle class is correct.
 * 
 * @author zhouzihan
 * @version 1.8
 */
public class CircleTester {
	/**
	 * This method set the Circle class and print
	 * some output to verify the correctness of the Circle class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("This is a circle tester!");
		
		////Creating a new circle class
		Circle circle = new Circle();
		
		//Set and check the circle color
		circle.color = new Color(200, 0, 0);
		if (circle.color != new Color(0, 0, 0)) {
			System.out.println("Circle color successfully set!");
		}
		
		//Fill and check the circle
		circle.filled = true;
		if (circle.filled == true) {
			System.out.println("Circle color successfully filled!");
		}
		
		//Specify the orientation of the circle in the screen coordination system
		circle.theta = Math.PI/2;
		
		//Specify the x-coordinate and y-coordinate of the center 
		//of the circle in the screen coordinate system
		circle.xc = 30;
		circle.yc = 30;
		
		//Specify two array of double values representing 
		//the x-coordinates and y-coordinates of the upper left and lower right  vertices
	    //of an axis-aligned bounding box of the circle in the screen coordinate system
		circle.xLocal = new double[] {2, 6};
		circle.yLocal = new double[] {2, 8};
		
		//Set the local-coordinates of the vertices of the circle
		circle.setVertices(30);
		
		//Translate the center of the circle along the 
		//x and y directions of the screen coordinate system
		circle.translate(100, 120);
		
		//rotate the circle about its center by a certain angle
		circle.rotate(20);
		
		//Retrieve the x-coordinates of the upper left and lower right vertices
		//by calling the getX method and print them out respectively.
		int[] listx = new int[circle.xLocal.length];
	    listx = circle.getX();
	    for (int i = 0; i < circle.xLocal.length; i ++) {
	    	System.out.println("The newly get x-coordinate of the circle is: " + listx[i]);
	    }
		
	    //Retrieve the y-coordinates of the upper left and lower right vertices
	  	//by calling the getY method and print them out respectively.
	    int[] listy = new int[circle.yLocal.length];
	    listy = circle.getY();
	    for (int k = 0; k < circle.yLocal.length; k++) {
	    	System.out.println("The newly get y-coordinate of the circle is: "+ listy[k]);
	    }
	}

}
