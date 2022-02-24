package cecs277DemoFactoryPatternGeometry;

/**
 * The supertype for all geometric objects that we will create.
 * @author	Dave Brown
 * @date	11/21/2019
 */
public abstract class GeometricShape {
	/**
	 * Find the area of the GeometricShape
	 * @return	The square area.
	 */
	public abstract double getArea ();
	
	/**
	 * Find the length around the outside of the shape.
	 * @return	The length around the perimeter.
	 */
	public abstract double getPerimeter ();
	
	/**
	 * Find the location of the shape.  What that means
	 * will vary from one shape to the next.
	 * @return	The location's x & y coordinates.
	 */
	public abstract Point getLocation ();
	
	/**
	 * Return the points that define the shape.
	 * @return	1 or more points that define this shape.
	 */
	public abstract Point [] getPoints ();
} // End of the GeometricShape class