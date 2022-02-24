package cecs277DemoFactoryPatternGeometry;

import java.io.FileNotFoundException;

/**
 * A quantity and a direction.  The direction comes as the number of radians measured 
 * counter clockwise from the x axis.
 * @author	Dave Brown
 * @date	September 28th, 2019
 */
public class Vector {
	static final double EPSILON = .0000001;
	/** The length of the vector */
	private double magnitude;
	/** The angle in radians */
	private double direction;
	
	public Vector (double magnitude, double direction) {
		if (magnitude <= 0) {
			throw new IllegalArgumentException ("Vector length must be > 0!");
		} else {
			this.magnitude = magnitude;
			this.direction = direction;
		}
	}
	
	public double getMagnitude () { return this.magnitude; }
	
	public double getDirection () { return this.direction; }
	
	/**
	 * Yield the direction in degrees.
	 * @return	The direction in degrees.
	 */
	public double getDirectionDeg () { return Math.toDegrees(this.direction); } 
	
	public Point add (Point base) {
		double x = base.getX() + this.getMagnitude()*Math.cos(this.getDirection());
		double y = base.getY() + this.getMagnitude()*Math.sin(this.getDirection());
		return new Point (x, y);
	} // End of method to add a vector to a point
	
	/**
	 * Create a vector from a point.  Use the distance of the point from 0,0 as the
	 * magnitude, and the angle to a line connecting that point to 0,0 as the direction.
	 * @param	source			The starting point for the vector.
	 * @param	destination		The point that the vector points to.
	 * @return					The vector that has a magnitude = the distance of that
	 * 							point from 0,0 and points towards that point.
	 */
	public static Vector getVector (Point source, Point destination) {
		double magnitude = source.distance(destination);
		double direction;
		double deltaY = destination.getY() - source.getY();
		double deltaX = destination.getX() - source.getX();
		double slope = deltaY / deltaX;
		if (Math.abs(deltaY) < EPSILON) {					// the line segment //s the X axis
			if (deltaX < 0) {								//180 degrees
				direction = Math.PI;
			} else {
				direction = 0;								//0 degrees
			}
		} else if (slope == Double.POSITIVE_INFINITY) {		//Goes straight up
			direction = Math.PI/2;
		} else if (slope == Double.NEGATIVE_INFINITY) {		//Goes straight down
			direction = Math.PI * (double) 3 / (double) 2;
		} else {
			direction = Math.atan(slope);					//Use arc tangent to get the angle in radians
		}
		return new Vector (magnitude, direction);
	} // End of method to get a vector from two points
	
	/**
	 * Get a vector from just one point, which treats the source as 0, 0
	 * @param	destination		The point that the vector should point to.
	 * @return					The vector pointing to that point.
	 */
	public static Vector getVector (Point destination) {
		return getVector (new Point (0, 0), destination);
	}
	
	/**
	 * Add two vectors together.
	 * @param	vector	The Vector to add to this one.
	 * @return			The results of adding these two vectors.
	 */
	public Vector add (Vector vector) {
		//Convert this Vector to a point
		Point P1 = this.add(new Point (0, 0));
		//Add the point version of this vector to the other vector
		Point P2 = vector.add(P1);
		//Convert from that resulting point back to a vector
		return getVector (P2);
	} // End of the method to add one vector to the another
	
	/**
	 * Return the angle (in radians) between two vectors.  Their magnitude isn't taken into 
	 * account at all, it's just their respective angle to the X axis that matters.  If that 
	 * angle is < pi, then we essentially calculate the angle in the other direction.
	 * @param	other		The other Vector that you want the angle to.
	 * @return				The angle between them in radians.  A negative value means that
	 * 						the other vector is closer if you rotate counter clockwise.
	 */
	public double angle (Vector other) {
		double myDirection = this.getDirection();
		double yourDirection = other.getDirection();
		double difference = yourDirection - myDirection;
		//We are > 180 degrees apart, it's closer to rotate in the other direction
		if (Math.abs(difference) > Math.PI) {
			if (difference < 0) {						//Other is clockwise from me
				difference = difference + Math.PI;
			} else {									//Other is counterclockwise from me
				difference = difference - Math.PI;
			}
		}
		return difference;
	} // End of the angle method
	
	public String toString () {
		return "Vector- Direction: " + this.getDirectionDeg() + " degrees, magnitude: " + this.getMagnitude();
	}
	public static void main(String[] args) throws FileNotFoundException {
		Point base = new Point (0,0);
		System.out.println (new Vector (5, .523598767).add(base));
		System.out.println (new Vector (5, 3.6651914205897932384626433832795).add(base));
		System.out.println (new Vector (5, Math.PI/4).add(new Vector (5, (double) 7 / (double) 4 * Math.PI)));
		System.out.println (getVector (new Point(0, 5)));
	} // Little test routine for the vector class
} // End of the Vector class