package cecs277DemoFactoryPatternGeometry;

/**
 * Internally, we can represent circle in at least two, possibly 
 * several different ways.  This abstract supertype applies no matter
 * how the definition of the circle is administered internally.
 * @author	Vy Nguyen, Nicki Huynh
 * @date	11/25/2019
 */

public abstract class CircleAbstractClass extends GeometricShape {
	/**
	 * Find the center point of the circle
	 * @return the center point
	 */
	public abstract Point getCenterPoint();
	
	/**
	 * Find the radius of the circle
	 * @return the radius
	 */
	public abstract double getRadius();
	
	/**
	 * Find the area of the circle
	 * @return	The circle area
	 */
	public double getArea() {
		return Math.PI * Math.pow(getRadius(), 2);
	}
	
	/**
	 * Find the length around the outside of the circle.
	 * @return	The length around the perimeter.
	 */
	public double getPerimeter() {
		return 2.0 * Math.PI * getRadius();
	}
	
	/**
	 * Find the location of the center point. 
	 * @return	x & y coordinates of the center point.
	 */
	public Point getLocation() {
		return getCenterPoint();
	}
	
	/**
	 * Return the points that define the shape.
	 * @return	1 or more points that define this shape.
	 */
	public abstract Point[] getPoints();
	
	public String toString() {
		return "Circle - Located at: " + getCenterPoint().toString() 
				+ " of radius: " + getRadius() + "\nArea: " + this.getArea() 
				+ " Perimeter: " + this.getPerimeter();
	}
	
}
