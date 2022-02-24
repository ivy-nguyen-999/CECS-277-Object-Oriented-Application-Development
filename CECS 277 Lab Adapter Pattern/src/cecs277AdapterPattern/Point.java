package cecs277AdapterPattern;

public class Point {
	/** x coordinate of the point. */ 
	private double x;
	/** y coordinate of the point. */
	private double y;
	
	public Point (double x, double y) {
		this.x = x;
		this.y = y;
	}
	/** retrieve the x coordinate. */
	double getX () { return this.x; }
	/** retrieve the y coordinate. */
	double getY () { return this.y; }
	
	/**
	 * Provide the distance between two points.
	 * @param	The other point.
	 * @return	The distance to that other point.
	 */
	public double getDistance (Point other) {
		double deltaX = other.getX() - this.getX();
		double deltaY = other.getY() - this.getY();
		return Math.sqrt (deltaX * deltaX + deltaY * deltaY);
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder("Point: X coordinate: ");
		sb.append(this.getX());
		sb.append(" Y coordinate: " + this.getY());
		return sb.toString();
	}
}
