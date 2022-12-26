import java.awt.*;
/**
 * The Shape class is used to model general shapes.
 * @author zhouzihan
 * @version 1.8
 */
public class Shape {
	
	//a Color object specifying the color of the shape.
	private Color color;
	
	//a boolean value specifying whether the shape is filled or not filled.
    private boolean filled;
    
    //a double value specifying the orientation (in radians) of the shape in the screen coordinate system.
    private double theta;
    
    //a double value specifying the x-coordinate of the center of the shape in the screen coordinate system.
    private double xc;
    
    //a double value specifying the y-coordinate of the center of the shape in the screen coordinate system.
    private double yc;
    
    //an array of double values specifying the x-coordinates of the vertices (in counter-clockwise order) of the shape in its local coordinate system.
    private double[] xLocal;
    
    //an array of double values specifying the y-coordinates of the vertices (in counter-clockwise order) of the shape in its local coordinate system.
    private double[] yLocal;
    
    /**
     * a method for retrieving the color of the shape.
     * @return color
     */
    public Color getColor() {
    	return color;
    }
    
    /**
     * a method for retrieving the fill-type of the shape.
     * @return filled
     */
    public boolean getFilled() {
    	return filled;
    }
    
    /**
     * a method for retrieving the orientation (in radians) of the shape in the screen coordinate system.
     * @return theta
     */
    public double getTheta() {
    	return theta;
    }
    
    /**
     * a method for retrieving the x-coordinate of the center of the shape in the screen coordinate system.
     * @return xc
     */
    public double getXc() {
    	return xc;
    }
    
    /**
     * a method for retrieving the y-coordinate of the center of the shape in the screen coordinate system.
     * @return yc
     */
    public double getYc() {
    	return yc;
    }
    
    /**
     * a method for retrieving the x-coordinates of the vertices (in counter-clockwise order) of the shape in its local coordinate system.
     * @return xLocal
     */
    public double[] getXLocal() {
    	return xLocal;
    }
    
    /**
     * a method for retrieving the y-coordinates of the vertices (in counter-clockwise order) of the shape in its local coordinate system.
     * @return yLocal
     */
    public double[] getYLocal() {
    	return yLocal;
    }
    
    /**
     * a method for setting the color of the shape.
     * @param color
     */
    public void setColor(Color color) {
    	this.color = color;
    }
    
    /**
     * a method for setting the fill-type of the shape.
     * @param filled
     */
    public void setFilled(boolean filled) {
    	this.filled = filled;
    }
    
    /**
     * a method for setting the orientation of the shape.
     * @param theta
     */
    public void setTheta(double theta) {
    	this.theta = theta;
    }
    
    /**
     * a method for setting the x-coordinate of the center of the shape in the screen coordinate system.
     * @param xc
     */
    public void setXc(double xc) {
    	this.xc = xc;
    }
    
    /**
     * a method for setting the y-coordinate of the center of the shape in the screen coordinate system.
     * @param yc
     */
    public void setYc(double yc) {
    	this.yc = yc;
    }
    
    /**
     * a method for setting the x-coordinates of the vertices (in counter-clockwise order) of the shape in its local coordinate system.
     * @param xLocal
     */
    public void setXLocal(double[] xLocal) {
    	this.xLocal = xLocal;
    }
    
    /**
     * a method for setting the y-coordinates of the vertices (in counter-clockwise order) of the shape in its local coordinate system.
     * @param yLocal
     */
    public void setYLocal(double[] yLocal) {
    	this.yLocal = yLocal;
    }
    
    /**
     * a method for translating the center of the shape by dx and dy, respectively, 
     * along the x and y directions of the screen coordinate system. 
     * (i.e., dx and dy should be added to xc and yc respectively.)
     * 
     * @param dx
     * @param dy
     */
    public void translate(double dx, double dy) {
    	xc=xc+dx;
    	yc=yc+dy;
    }
    
    /**
     * a method for rotating the shape about its center by an angle of dt (in radians). 
     * (i.e., dt should be added to theta.)
     * @param dt
     */
    public void rotate(double dt) {
    	theta=theta+dt;
    }
    
    /**
     * a method for retrieving the x-coordinates of the vertices (in counterclockwise order) 
     * of the shape in the screen coordinate system*.
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
     * a method for retrieving the y-coordinates of the vertices (in counterclockwise order)
     *  of the shape in the screen coordinate system*.
     * @return the y-coordinates of the vertices in the screen coordinate system
     */
    public int[] getY() {
    	int[] screeny = new int[yLocal.length];
    	for (int i = 0; i < yLocal.length; i++) {
    		screeny[i] = (int) Math.round(xLocal[i]*Math.sin(theta) + yLocal[i]*Math.cos(theta) + yc);
    	}
    	return screeny;
    }
    
    /**
     * a method to set the local coordinates of the vertices of a shape
     * a dummy method, supposed to be overridden in the subclasses
     * @param d The value used to denotes the local coordinates of the vertices of a shape
     */
    public void setVertices(double d) {
    	
    }

}
