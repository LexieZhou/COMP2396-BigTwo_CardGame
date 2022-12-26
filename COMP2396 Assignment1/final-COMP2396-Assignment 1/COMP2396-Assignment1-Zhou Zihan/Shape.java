import java.awt.Color;
/**
 * The Shape class is used to model general shapes.
 * @author zhouzihan
 * @version 1.8
 */
public class Shape {
	
	/**
	 * Color object specifying the color of the shape.
	 */
	public Color color;
	
	/**
	 * A boolean value specifying whether the shape is filled.
	 */
    public boolean filled;
    
    /**
     * A double value specifying the orientation of the shape in the screen coordinate system.
     */
    public double theta;
    
    /**
     * A double value specifying the x-coordinate of the center of the shape.
     */
    public double xc;
    
    /**
     * A double value specifying the y-coordinate of the center of the shape.
     */
    public double yc;
    
    /**
     * An array of double values specifying the x-coordinates of the vertices of the shape.
     */
    public double[] xLocal;
    
    /**
     * An array of double values specifying the y-coordinates of the vertices of the shape.
     */
    public double[] yLocal;
    
    /**
     * a method to set the local coordinates of the vertices of a shape
     * a dummy method, supposed to be overridden in the subclasses
     * @param d The value used to denotes the local coordinates of the vertices of a shape
     */
    public void setVertices(double d) {
    	
    }
    
    /**
     * a method for translating the center of the shape in the screen coordinate system
     * @param dx translate the shape along the x directions
     * @param dy translate the shape along the y directions
     */
    public void translate(double dx, double dy) {
    	xc=xc+dx;
    	yc=yc+dy;
    }
    
    /**
     * a method to rotate the shape about its center
     * @param dt denotes the angle of rotating
     */
    public void rotate(double dt) {
    	theta=theta+dt;
    }
    
    /**
     * a method to retrieve the x-coordinates of the vertices in its local coordinate system
     * @return the x-coordinates of the vertices in the screen coordinate system
     */
    public int[] getX() {
    	int[] screenx = new int[xLocal.length];
    	for (int i = 0; i < xLocal.length; i++) {
    		screenx[i] = (int) Math.round(xLocal[i]*Math.cos(theta) - yLocal[i]*Math.sin(theta) + xc);
    	}
    	return screenx;
    }
    
    /**
     * a method to retrieve the y-coordinates of the vertices in its local coordinate system
     * @return the y-coordinates of the vertices in the screen coordinate system
     */
    public int[] getY() {
    	int[] screeny = new int[yLocal.length];
    	for (int i = 0; i < yLocal.length; i++) {
    		screeny[i] = (int) Math.round(xLocal[i]*Math.sin(theta) + yLocal[i]*Math.cos(theta) + yc);
    	}
    	return screeny;
    }

}
