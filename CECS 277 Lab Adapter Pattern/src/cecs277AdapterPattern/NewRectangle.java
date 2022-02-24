package cecs277AdapterPattern;

public class NewRectangle {
	private Point upperLeft;
	/** The width of the rectangle */
	private double width;
	/** The length of the rectangle */
	private double length;
	
	public NewRectangle (Point start, double width, double length) {
		this.upperLeft = start;
		this.width = width;
		this.length = length;
	}
	
	/**
	 * Retrieve the upper left corner of the rectangle.
	 * @return	The upper left point.
	 */
	public Point getUpperLeft () {
		return this.upperLeft;
	}
	
	/**
	 * Retrieve the width of the rectangle.
	 * @return	The width.
	 */
	public double getWidth () {
		return this.width;
	}
	
	/**
	 * Retrieve the length of the rectangle.
	 * @return	The length.
	 */
	public double getLength () {
		return this.length;
	}
	
	/**
	 * retrieve the area of the rectangle.
	 * @return	The rectangle's area.
	 */
	public double getArea () {
		return width * length;
	}
	
	/**
	 * Retrieve the perimeter of the rectangle.
	 * @return	The rectangle's perimeter
	 */
	public double getPerimeter () {
		return 2*this.width + 2*this.length;
	}
}
