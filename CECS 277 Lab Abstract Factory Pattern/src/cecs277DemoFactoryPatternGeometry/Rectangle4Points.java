package cecs277DemoFactoryPatternGeometry;

/**
 * One of the concrete products.  This is the simple version: it just represents itself internally
 * using the 4 vertices.
 * @author	David Brown
 * @date	11/22/2019
 */
public class Rectangle4Points extends RectangleAbstractClass{
	
	/** The four corners of the rectangle */
	private Point [] corners;
	
	public Rectangle4Points (Point [] corners) throws InvalidShapeException {
		super (corners);
		//Create a copy of the incoming points so that we don't have to worry about the client
		//moving our points around on us.
		this.corners = Point.clone(corners);
	} // End of Constructor

	@Override
	public Point[] getCorners() {
		//Make a copy of the four corners so that they cannot get tweaked.
		Point [] copy = Point.clone(this.corners);
		return copy;
	} // End of getCorners method

	@Override
	public double getWidth() { return this.corners[0].distance(this.corners[1]); }

	@Override
	public double getHeight() { return this.corners[1].distance(this.corners[2]); }

} // End of the REctangle4Points class