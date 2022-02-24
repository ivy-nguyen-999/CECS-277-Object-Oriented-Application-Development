package cecs277AdapterPattern;

public class RectangleAdapter implements OldRectangle {
	/**
	 *  to serve as the storage and method implementation for key methods
	 *  that RectangleAdapter needs to implement the OldRectangle interface
	 */
	private NewRectangle rect;
	
	public RectangleAdapter(Point first, Point second, Point third, Point fourth) {
		double width = first.getDistance(second);
		double length = first.getDistance(third);
		rect = new NewRectangle(first, width, length);
	}
	
	@Override
	public double getArea() {
		return this.rect.getArea();
	}

	@Override
	public double getPerimeter() {
		return this.rect.getPerimeter();
	}

	@Override
	public double getDiagonal() {
		Point[] corners = getCorners();
		return corners[0].getDistance(corners[3]);
	}

	@Override
	public Point[] getCorners() {
		Point first = this.rect.getUpperLeft();
		Point second = new Point(first.getX(), first.getY() + rect.getWidth());
		Point third = new Point(first.getX() + rect.getLength(), first.getY());
		Point fourth = new Point(third.getX(), third.getY() + rect.getWidth());
		Point[] result = {first, second, third, fourth};
		return result;
	}

}
