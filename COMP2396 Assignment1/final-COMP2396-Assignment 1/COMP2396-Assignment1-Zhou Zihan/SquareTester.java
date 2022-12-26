import java.awt.Color;
/**
 * The SquareTester class is used to verify whether Square class is correct.
 * 
 * @author zhouzihan
 * @version 1.8
 */
public class SquareTester {
	/**
	 * This method set the Square class and print
	 * some output to verify the correctness of the Square class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("This is a square tester!");
		
		//Creating a new square class
		Square square = new Square();
		
		//Set and check the shape color
		square.color = new Color(20, 100, 30);
		if (square.color != new Color(0, 0, 0)) {
			System.out.println("Square color successfully set!");
		}
		
		//Fill and check the shape
		square.filled = true;
		if (square.filled == true) {
			System.out.println("Square color successfully filled!");
		}
		
		//Specify the orientation of the square in the screen  coordination system
		square.theta = 15;
		
		//Specify the x-coordinate and y-coordinate of the center 
		//of the square in the screen coordinate system
		square.xc = 0;
		square.yc = 0;
		
		//Set the local-coordinates of the vertices of the shape
		square.setVertices(30);
		
		//Specify two array of double values representing 
		//the x-coordinates and y-coordinates of the vertices of the square
		square.xLocal = new double[] {2, 2, -2, -2};
		square.yLocal = new double[] {2, -2, -2, 2};
		
		//Translate the center of the shape along the 
		//x and y directions of the screen coordinate system
		square.translate(10, 10);
		
		//rotate the square about its center by a certain angle
		square.rotate(90);
		
		//Retrieve the x-coordinates of the vertices by calling the getX method
		//and print them out respectively.
	    int[] listx = new int[square.xLocal.length];
	    listx = square.getX();
	    for (int i = 0; i < square.xLocal.length; i++) {
	    	System.out.println("The newly get x-coordinate of the square is: " + listx[i]);
	    }
		
	    //Retrieve the y-coordinates of the vertices by calling the getY method
	  	//and print them out respectively.
	    int[] listy = new int[square.yLocal.length];
	    listy = square.getY();
	    for (int k = 0; k < square.yLocal.length; k++) {
	    	System.out.println("The newly get y-coordinate of the square is: "+ listy[k]);
	    }
	}

}
