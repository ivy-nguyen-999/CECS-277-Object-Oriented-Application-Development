/**
 * A class that creates points with x and y coordinates.
 * Homework Assignment: IPI
 * @author Nicki Huynh and Vy Nguyen
 * @date 10/14/2019
 */

public class Point {
	private double x;
	private double y;
	public Point (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	double getX() { return this.x; }
	double getY() { return this.y; }
	
	/*
	 * Find the distance between two points.
	 * @param	The other point.
	 * @return	The distance between them.
	 */
	public double distance (Point other) {
		double deltaX = other.getX() - this.getX();
		double deltaY = other.getY() - this.getY();
		return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
	}
	
	public String toString () {
		return "Point: X: " + this.getX() + " Y: " + this.getY();
	}
}