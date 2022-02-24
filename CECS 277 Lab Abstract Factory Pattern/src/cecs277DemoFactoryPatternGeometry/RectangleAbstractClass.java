package cecs277DemoFactoryPatternGeometry;

/**
 * Internally, we can represent rectangles in at least two, possibly 
 * several different ways.  This abstract supertype applies no matter
 * how the definition of the rectangle is administered internally.
 * @author	David Brown
 * @date	09/29/2019
 */
public abstract class RectangleAbstractClass extends GeometricShape{
	/** My definition of what I mean by "close enough" since the round off error is ever-present */
	static final double EPSILON = .0000001;
	/**
	 * Return the four corners of the rectangle.  That will vary, depending on which 
	 * sort of rectangle this is.
	 * @return	An array of 4 points.  Note that these Point instances are a copy
	 */
	public abstract Point [] getCorners ();
	
	/**
	 * This seems sort of silly, since all it does is use the getCorners method, but it makes it
	 * possible for this abstract class to implement all of the GeometricShape methods easily.
	 */
	@Override
	public Point [] getPoints () { return this.getCorners (); }
	
	/**
	 * Return the width of the rectangle.
	 * @return	The width of the rectangle.
	 */
	public abstract double getWidth ();
	
	/**
	 * Return the height of the rectangle.
	 * @return	The height of the rectangle.
	 */
	public abstract double getHeight ();
	
	/**
	 * Calculate the area.  Note that, even though we have no idea how the width and length
	 * are represented or calculated in the implementations of this abstract class, we can 
	 * count on getWidth and getHeight.  Polymorphism at its very finest.
	 * @return	The area of the rectangle
	 */
	@Override
	public double getArea () {return Math.abs(this.getWidth()) * Math.abs(this.getHeight());}

	/**
	 * Calculate the perimeter of the rectangle.
	 * @return	The perimeter of the rectangle
	 */
	@Override
	public double getPerimeter () {return (Math.abs(this.getWidth()) + Math.abs(this.getHeight())) * 2; }
	
	@Override
	public Point getLocation () {return this.getCorners()[0]; }
	/**
	 * Check the four angles on four points to make sure they are 90 degrees.
	 * @return	True if all four angles are 90 degrees, false otherwise.
	 */
	public static void checkAngles (Point [] points) throws InvalidShapeException {
		int nPoints = points.length;
		for (int i = 1; i <= nPoints; i++) {
			//Create a vector connecting points[i - 1] to points [i]
			Vector vector1 = Vector.getVector (points [i % nPoints], points [i - 1]);
			//Create a vector connecting points[i] to points [i + 1], wrapping around at the end
			Vector vector2 = Vector.getVector(points [i % nPoints], points [(i + 1) % nPoints]);
			//See if this is close enough to 90 degrees
			if (Math.abs(Math.abs(vector1.angle(vector2)) - Math.PI/2) > EPSILON) {
				throw new InvalidShapeException (points[i - 1], points[i % nPoints], points[(i + 1) % nPoints]);
			} // Angle is not pi/2
		} // End of loop through the points
	} // End of the checkAngles function
	
	/**
	 * Constructor for the RectangleAbstractClass.  Notice that this
	 * constructor just checks the points, it doesn't actually store
	 * a reference to those points as a member variable.
	 * @param points
	 * @throws InvalidShapeException
	 */
	public RectangleAbstractClass (Point [] points) throws InvalidShapeException {
		checkAngles (points);
	} // End of the RectangleAbstractClass constructor method
	
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder("Rectangle - Points: ");
		Point [] corners = this.getCorners();
		for (int i = 0; i < corners.length; i++) {
			sb.append(corners[i].toString() + " ");
		}
		sb.append("\nArea: " + this.getArea() + " Perimeter: " + this.getPerimeter());
		return sb.toString();
	} // End of the toString method
} // End of the RectangleAbstractClass class