package cecs277LabDecoratorDesignPattern;

public class Circle extends GeometricObject {
	/** x coordinate of center */
	double x;
	/** y coordinate of center */
	double y;
	/** radius */
	double radius;
	
	/**
	 * Define a new circle.
	 * @param x			The x coordinate of the center of the circle.
	 * @param y			The y coordinate of the center of the circle.
	 * @param radius	The radius of the circle.
	 */
	public Circle (double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = Math.abs(radius);
	}

	@Override
	public String toString() {
		return "Circle - centered on: " + this.x + ", " + this.y + " of radius: " + this.radius;
	}

	@Override
	public void draw() {
		System.out.println ("Drawing a circle.");
	}

	@Override
	public void resize(double percent) {
		this.radius *= percent;
	}

}
