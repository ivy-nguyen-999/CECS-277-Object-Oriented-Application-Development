package cecs277LabDecoratorDesignPattern;

public class FillColorDecorator extends ShapeDecorator{
	/** Fill color for this shape. */
	Color FillColor;
	
	/**
	 * Create a GeometricObject decorated by color.
	 * @param shape	The Geometric object that you're decorating.
	 * @param color	The fill color of this object.
	 */
	public FillColorDecorator (GeometricObject shape, Color color) {
		super(shape);									//Compose the thing that we're decorating
		this.FillColor = color;
	}

	@Override
	public String toString() {
		return "Fill color: " + FillColor + " for shape: " + super.getDecoratedShape();
	}

	@Override
	public void draw() {
		System.out.println ("Drawing a shape of color: " + this.FillColor);
		super.getDecoratedShape().draw();
	}

	@Override
	public void resize(double percent) {
		System.out.println ("Resizing a shape of color: " + this.FillColor);
		super.getDecoratedShape().resize(percent);
	}
}
