package cecs277LabDecoratorDesignPattern;

public class LineColorDecorator extends ShapeDecorator {
	/** The color of the line around the outside of the shape */
	private Color lineColor;
	
	public LineColorDecorator (GeometricObject shape, Color color) {
		super(shape);
		this.lineColor = color;
	}
	
	@Override
	public String toString() {
		return "Line color: " + this.lineColor + " for shape: " + super.getDecoratedShape();
	}

	@Override
	public void draw() {
		System.out.println ("Drawing a shape with line color: " + this.lineColor);
		super.getDecoratedShape().draw();
	}

	@Override
	public void resize(double percent) {
		System.out.println ("Resizing a shape of line color: " + this.lineColor);
		super.getDecoratedShape().resize(percent);
	}

}
