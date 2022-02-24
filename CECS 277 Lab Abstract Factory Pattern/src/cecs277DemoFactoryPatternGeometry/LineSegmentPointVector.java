package cecs277DemoFactoryPatternGeometry;

/**
 * This variation on the line segment just uses a starting point and a vector to do its work.
 * The vector added to the starting point will give the ending point.
 * @author	Dave Brown
 * @date	11/21/2019
 */
public class LineSegmentPointVector extends LineSegmentAbstractClass {

	/** The starting point for the line segment */
	Point start;
	/** The vector pointing to the other point for the line segment */
	Vector direction;
	
	public LineSegmentPointVector (Point [] points) {
		this.start = points[0];
		this.direction = Vector.getVector(points[0], points[1]);
	}
	@Override
	public Point[] getPoints() {
		Point [] points = {this.start, this.direction.add(this.start)};
		return points;
	} // End of the getPoints method
} // End of the LineSegmentPointVector class	