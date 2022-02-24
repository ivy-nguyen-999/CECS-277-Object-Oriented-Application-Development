package cecs277DemoFactoryPatternGeometry;

/**
 * This version of Line Segment just stores the start and end points
 * without any attempt at sophistication.
 * @author	Dave Brown
 * @date	11/21/2019
 */
public class LineSegment2Points extends LineSegmentAbstractClass {

	/**
	 * The state of this line segment: the two end points.
	 */
	Point [] points;
	
	public LineSegment2Points (Point [] points) {
		//Make a deep copy of the set of points passed in.
		this.points = Point.clone(points);
	} // End of the LineSegment2Points constructor
	
	@Override
	public Point[] getPoints() {
		return Point.clone(this.points);
	}
} // End of the LineSegment2Points class