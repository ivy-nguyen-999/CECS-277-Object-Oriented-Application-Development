package cecs277LabDecoratorDesignPattern;

public class Rectangle extends GeometricObject {
	
	/** x coordinate of the rectangle upper left corner */
	double x;
	/** y coordinate of the rectangle upper left corner */
	double y;
	/** Width of the rectangle */
	private double width;
	/** Length of the rectangle */
	private double length;
	
	/**
	 * Create a new rectangle.
	 * @param x			x coordinate of the upper left hand corner.
	 * @param y			y coordinate of the upper left hand corner.
	 * @param width		Width of the rectangle.
	 * @param length	Length of the rectangle.
	 */
	public Rectangle (double x, double y, double width, double length) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.length = length;
	}

	@Override
	public void draw() {
		System.out.println("Drawing a Rectangle.");
	}

	@Override
	public void resize(double percent) {
		this.width = this.width*percent;
		this.length = this.length*percent;
	}

	@Override
	public String toString() {
		return "Rectangle- Upper left at: " + this.x + ", " + this.y + " width: " + 
				this.width + " length: " + this.length;
	}
}
