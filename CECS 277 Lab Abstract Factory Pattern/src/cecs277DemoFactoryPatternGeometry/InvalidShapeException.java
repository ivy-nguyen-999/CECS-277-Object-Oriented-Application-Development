package cecs277DemoFactoryPatternGeometry;

/**
 * Special exception to cover the case when one of the angles is wrong.  Admittedly, 
 * this is a pretty specialized exception, but I hope that it demonstrates what you can
 * do with custom exception classes that you write.
 * @author	David Brown
 * @date	10/19/2019
 */
public class InvalidShapeException extends Exception {
	
	/** Dummy serial version number to make it serializable. */
	private static final long serialVersionUID = 1L;
	
	/** The first point in the angle. */
	private Point first;
	/** The second point in the angle. */
	private Point second;
	/** The third point in the angle. */
	private Point third;
	
	/**
	 * Typical constructor
	 * @param	first	The first point in the angle.
	 * @param	second	The second point in the angle.
	 * @param	third	The third point in the angle.
	 */
	public InvalidShapeException (Point first, Point second, Point third) {
		super("Invalid angle between: " + first + " " + second + " " + third);
		this.first = first;
		this.second = second;
		this.third = third;
	} // End of the constructor for InvalidShapeException
	
	public Point [] getPoints () {
		Point [] angle = {this.first, this.second, this.third};
		return angle;
	} // End of the getPoints method
} // End of the InvalidShapeException class