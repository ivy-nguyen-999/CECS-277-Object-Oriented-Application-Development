package cecs277DemoFactoryPatternGeometry;

/** 
 * A point in 2 dimensional space as well as some handy analytical geometry utilities.
 * @author	Dave Brown
 * @Date	09/29/2019
 */
public class Point {
	/** The x coordinate */
	double x;
	/** The y coordinate */
	double y;
	
	/**
	 * Default constructor.
	 */
	public Point () {
		this.x = 0;
		this.y = 0;
	} // End of default constructor.
	
	/**
	 * Normal constructor.
	 * @param	x	The x coordinate of the point.
	 * @param	y	The y coordinate of the point.
	 */
	public Point (double x, double y) {
		this.x = x;
		this.y = y;
	} // End of the normal constructor
	
	/**
	 * Copy constructor.  Creates a clone of the given point.
	 * @param	other	The other point that we're using for our template.
	 */
	public Point (Point other) {
		this.x = other.getX();
		this.y = other.getY();
	} // End of the copy constructor
	
	public double getX () { return this.x; }
	
	public double getY () { return this.y; }
	
	/**
	 * Calculate the distance to another point.
	 * @param	The other point.
	 * @return	The distance between this point and the other point.
	 */
	public double distance (Point other) {
		double deltaX = this.getX() - other.getX();
		double deltaY = this.getY() - other.getY();
		return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
	} // End of the distance method
	
	/**
	 * Come up with a point midway between two other points: the implicit parameter
	 * Point, and the Point passed in.
	 * @param	The other point.
	 * @return	The point between the implicit parameter point and the explicity parameter.
	 */
	public Point between (Point other) {
		double x = (this.getX() + other.getX())/2.0;
		double y = (this.getY() + other.getY())/2.0;
		return new Point (x, y);
	} // End of the between method
	
	/**
	 * Clone an array of points.
	 * @param	input	The array of points to clone.
	 * @return			The cloned points.
	 */
	public static Point [] clone(Point [] points) {
		Point [] results = new Point [points.length];
		for (int i = 0; i < points.length; i++) {
			results [i] = new Point (points[i]);
		}
		return results;
	} // End of the clone method
	
	@Override
	public String toString () {
		return "Point: x value: " + this.getX() + " y value: " + this.getY();
	} // End of the toString method
} // End of the Point class