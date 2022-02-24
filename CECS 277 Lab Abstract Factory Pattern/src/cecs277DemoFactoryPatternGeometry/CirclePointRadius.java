package cecs277DemoFactoryPatternGeometry;

/**
 * This version of Cicle creates a circle using a point and radius
 * @author	Vy Nguyen, Nicki Huynh
 * @date	11/25/2019
 */

public class CirclePointRadius extends CircleAbstractClass {
	/** The center of the circle */
	private Point center;
	/** The radius of the circle */
	private double radius;
	
	/**
	 * The constructor of CirclePointRadius class
	 * @param points all the points that can be use to find the radius and center point
	 * @throws InvalidShapeException
	 */
	public CirclePointRadius(Point[] points) {
		this.center = points[0].between(points[1]);
		this.radius = Math.abs(points[0].distance(center));
	} // End the constructor

	@Override
	public Point getCenterPoint() {
		return this.center;
	} // End get the center point

	@Override
	public double getRadius() {
		return this.radius;
	} // End get the radius

	@Override
	public Point[] getPoints() {
		Point[] points = new Point[2];
		points[0] = new Point(center.getX(), center.getY() - radius);
		points[1] = new Point(center.getX(), center.getY() + radius);
		//Make a copy of the two points so that they cannot get tweaked.
		Point [] copy = Point.clone(points);
		return copy;
	} // End get two points that can make the circle
	
	@Override
	public String toString() {
		return "Radius and center circle: " + super.toString();
	} // override the toString method
	
}
