/**
 * The RegularPolygon class is a subclass of the Shape class and is used to 
 * model regular n-sided polygons.

 * @author zhouzihan
 * @version 1.8
 * 
 */
public class RegularPolygon extends Shape {
	
	//an integer value specifying the number of sides of the regular n-sided polygon.
	private int numOfSides;
	
	//a double value specifying the radius of the regular n-sided polygon.
	private double radius;
	
	/**
	 * a constructor for building a regular n-sided 
	 * polygon with a radius of r.
	 * 
	 * @param n
	 * @param r
	 */
	public RegularPolygon(int n, double r) {
		if (n <= 3) {
			this.numOfSides = 3;
		}
		if (n > 3) {
			this.numOfSides = n;
		}
		if (r <= 0) {
			this.radius = 0;
		}
		if (r > 0) {
			this.radius = r;
		}
		this.setVertices();
	}
	
	/**
	 * a constructor for building a regular n-sided polygon 
	 * with a radius of 1.0.
	 * @param n
	 */
	public RegularPolygon(int n) {
		this.radius = 1.0;
		if (n <=3) {
			this.numOfSides = 3;
		}
		else {
			this.numOfSides = n;
		}
		this.setVertices();
	}
	
	/**
	 * a constructor for building a regular 3-sided polygon
	 * with a radius of 1.0.
	 */
	public RegularPolygon() {
		this.numOfSides = 3;
		this.radius = 1.0;
		this.setVertices();
	}
	
	/**
	 * a method for retrieving the number of sides of the regular polygon.
	 * @return numOfSides
	 */
	public int getNumOfSides() {
		return this.numOfSides;
	}
	
	/**
	 * a method for retrieving the radius of the regular polygon.
	 * @return radius
	 */
	public double getRadius() {
		return this.radius;
	}
	
	/**
	 * a method for setting the number of sides of the regular n-sided polygon. 
	 * This method should also reset the local coordinates of the vertices of 
	 * the regular n-sided polygon.
	 * @param n
	 */
	public void setNumOfSides(int n) {
		if (n <= 3) {
			this.numOfSides = 3;
		}
		else {
			this.numOfSides = n;
		}
		this.setVertices();
	}
	
	/**
	 * a method for setting the radius of the regular n-sided polygon.
	 * This method should also reset the local coordinates of the vertices 
	 * of the regular n-sided polygon.
	 * @param r
	 */
	public void setRadius(double r) {
		if (r <= 0) {
			this.radius = 0;
		}
		else {
			this.radius = r;
		}
		this.setVertices();
	}
	
	/**
	 * a method for setting the local coordinates of the vertices of 
	 * the regular n-sided polygon based on its number of sides and radius (see appendix). 
	 * If the number of sides is an odd number, 
	 * the first vertex should lie on the positive x-axis and its distance 
	 * from the origin is given by the radius of the regular n-sided polygon. 
	 * The rest of the vertices can be obtained by rotating this vertex 
	 * about the origin by a multiple of 2p/n, where n is the number of sides,
	 * in a counter-clockwise manner.
	 */
	private void setVertices() {
		double[] verticesXLocal = new double[this.numOfSides];
		double[] verticesYLocal = new double[this.numOfSides];
		
		if (this.numOfSides % 2 == 1) {
			for (int i = 0; i < this.numOfSides; i++) {
				verticesXLocal[i] = this.radius*Math.cos(0-i*2*Math.PI/this.numOfSides);
				verticesYLocal[i] = this.radius*Math.sin(0-i*2*Math.PI/this.numOfSides);
			}
		}
		else {
			for (int i = 0; i < this.numOfSides; i++) {
				verticesXLocal[i] = this.radius*Math.cos(Math.PI/this.numOfSides-i*2*Math.PI/this.numOfSides);
				verticesYLocal[i] = this.radius*Math.sin(Math.PI/this.numOfSides-i*2*Math.PI/this.numOfSides);
		    }
		}
		
		setXLocal(verticesXLocal);
		setYLocal(verticesYLocal);
	}
	
	/**
	 * a method for determining if a point (x, y) in the screen coordinate system 
	 * is contained by the regular n-sided polygon. 
	 * A point is considered to be contained by a polygon 
	 * if it lies either completely inside the polygon, 
	 * or on any of the sides or vertices of the polygon.
	 * 
	 * @param x
	 * @param y
	 * @return true or false according to whether it lies inside the polygon
	 */
	public boolean contains(double x, double y) {
		double[] xRotate = getXLocal();
		double xmin = 0;
		int flag = 0;  //use flag to denote whether the point lies inside the polygon
				
		double localx = (x-this.getXc())*Math.cos(-2*Math.PI/this.numOfSides)-(y-this.getYc())*Math.sin(-2*Math.PI/this.numOfSides);
		double localy = (x-this.getXc())*Math.sin(-2*Math.PI/this.numOfSides)+(y-this.getYc())*Math.cos(-2*Math.PI/this.numOfSides);
		double x1 = localx;
		
		//Detect xRotate array to get the minimum x
		for (int i = 0; i < this.numOfSides; i++) {
			if(xRotate[i] <= xmin) {
				xmin  = xRotate[i];
			}
		}
		
		// Rotate the localx and check whether it lies inside the polygon.
		for(int i = 0; i < this.numOfSides; i++) {
			// The point lies outside the polygon
			if(x1 < xmin) {
				flag = 1;
				break;
			}
			//Rotate the localx again and again and check whether it lies inside the polygon
			x1= localx*Math.cos(2*(i+1)*Math.PI/this.getNumOfSides()) - localy*Math.sin(2*(i+1)*Math.PI/this.getNumOfSides());
		}
		
		// The point lies outside the polygon.
		if (flag == 1) {
			return false;
		}
		
		// The point lies inside the polygon.
		else {
			return true;
		}
	}
}
