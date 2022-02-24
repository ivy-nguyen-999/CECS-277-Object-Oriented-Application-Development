package cecs277LabDecoratorDesignPattern;

public class Squares extends GeometricObject {

	/** x coordinate of the square upper left corner */
	double x;
	/** y coordinate of the square upper left corner */
	double y;
	/** Length of the square*/
	private double LengthOneSide;
	
	/**
	 * Create a new Square
	 * @param x				x coordinate of the upper left hand corner.
	 * @param y				y coordinate of the upper left hand corner.
	 * @param sideLength 	the length of the side
	 */
	public Squares(double x, double y, double sideLength) {
		this.x = x;
		this.y = y;
		this.LengthOneSide = sideLength;
	}
	
	@Override
	public String toString() {
		return "Square- Upper left at: " + this.x + ", " + this.y + " length of one side: "
				+ this.LengthOneSide;
	}

	@Override
	public void draw() {
		System.out.println("Drawing a Square.");
	}

	@Override
	public void resize(double percent) {
		this.LengthOneSide *= percent;
	}

}
