import java.awt.*;
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
		
		//Check the shape color
		shape.setColor(new Color(100, 0, 0));
		System.out.println("Shape color successfully set!");
		
		System.out.println("Shape color is "+shape.getColor());
		
		//Check the shape
		shape.setFilled(true);
        System.out.println("Is shape color successfully filled?");
        System.out.println(shape.getFilled());
		
		//Specify the orientation of the shape in the screen  coordination system
        shape.setTheta(30);
        System.out.println("The orientation of the shape is ");
        System.out.println(shape.getTheta());
		
		//Specify the x-coordinate and y-coordinate of the center 
		//of the shape in the screen coordinate system
        shape.setXc(50);
        System.out.println("The xc of the shape is ");
        System.out.println(shape.getXc());
        
        shape.setYc(40);
        System.out.println("The yc of the shape is ");
        System.out.println(shape.getYc());
		
		
		//Specify two array of double values representing 
		//the x-coordinates and y-coordinates of the vertices
        shape.setXLocal(new double[] {1, 2, 4, 7});
        System.out.println("The xLocal of the shape is ");
        for (int i = 0; i < shape.getXLocal().length; i++) {
        	System.out.println(shape.getXLocal()[i]);
        }

        shape.setYLocal(new double[] {2, 3, 4, 5});
        System.out.println("The yLocal of the shape is ");
        for (int i = 0; i < shape.getXLocal().length; i++) {
        	System.out.println(shape.getXLocal()[i]);
        }
		
		//Set the local-coordinates of the vertices of the shape
		shape.setVertices(30);
		
		//Translate the center of the shape along the 
		//x and y directions of the screen coordinate system
		shape.translate(20, 10);
		
		//rotate the shape about its center by a certain angle
		shape.rotate(40);
		
		//Retrieve the x-coordinates of the vertices by calling the getX method
		//and print them out respectively.
	    int[] listx = new int[shape.getXLocal().length];
	    listx = shape.getX();
	    for (int i = 0; i < shape.getXLocal().length; i ++) {
	    	System.out.println("The newly get x-coordinate is: " + listx[i]);
	    }
		
	    //Retrieve the y-coordinates of the vertices by calling the getY method
	    //and print them out respectively.
	    int[] listy = new int[shape.getYLocal().length];
	    listy = shape.getY();
	    for (int k = 0; k < shape.getYLocal().length; k++) {
	    	System.out.println("The newly get y-coordinate is: "+ listy[k]);
	    }
		
		
		
	}

}
