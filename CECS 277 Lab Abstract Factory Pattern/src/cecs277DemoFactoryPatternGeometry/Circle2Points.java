package cecs277DemoFactoryPatternGeometry;

/**
 * This version of Cicle creates a circle using two points
 * @author	Vy Nguyen, Nicki Huynh
 * @date	11/25/2019
 */

public class Circle2Points extends CircleAbstractClass {
	/** two points on opposite sides of the circle */
	private Point[] points;
	 /**
	  * The constructor of Circle2Points class
	  * @param points the two points that create a cicle
	  * @throws InvalidShapeException when the degree between two points is invalid
	  */
	public Circle2Points(Point[] points) {
		//Create a copy of the incoming points so that we don't have to worry about the client
		//moving our points around on us.
		this.points = Point.clone(points);
	}

	@Override
	public Point getCenterPoint() {
		return points[0].between(points[1]);
	} // End get the center point

	@Override
	public double getRadius() {
		return Math.abs(points[0].distance(getCenterPoint()));
	} // End get the radius

	@Override
	public Point[] getPoints() {
		//Make a copy of the two points so that they cannot get tweaked.
		Point [] copy = Point.clone(this.points);
		return copy;
	} // End get the two points
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Points used to create circles: ");
		Point [] points = this.getPoints();
		for (int i = 0; i < points.length; i++) {
			sb.append(points[i].toString() + " ");
		}
		sb.append("\n2 point circle: " + super.toString());
		return sb.toString();
	} // Override the toString() method
}
