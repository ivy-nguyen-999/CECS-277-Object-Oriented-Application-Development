package cecs277AdapterPattern;

public interface OldRectangle {
	/**
	 * retrieve the area of the rectangle.
	 * @return	The rectangle's area.
	 */
	double getArea();
	/**
	 * Retrieve the perimeter of the rectangle.
	 * @return	The rectangle's perimeter
	 */
	double getPerimeter();
	/**
	 * retrieve the diagonal of the rectangle
	 * @return the rectangle's diagonal
	 */
	double getDiagonal();
	/**
	 * retrieve all the corner points
	 * @return the rectangle's corners
	 */
	Point[] getCorners();
}
