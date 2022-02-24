package cecs277LabDecoratorDesignPattern;

public class LineWeightDecorator extends ShapeDecorator {
	
	/** Fill color for this shape. */
	private LineWeight weight;

	/**
	 * Decorate a GeometricObject with a LinewWeight.
	 * @param shape		The GeometricOject to decorate.
	 * @param weight	The line weight of the object.
	 */
	public LineWeightDecorator (GeometricObject shape, LineWeight weight) {
		super(shape);
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Line weight: " + this.weight + " for shape: " + super.getDecoratedShape();
	}

	@Override
	public void draw() {
		System.out.println ("Drawing a shape of line weight: " + this.weight);
		super.getDecoratedShape().draw();
	}

	@Override
	public void resize(double percent) {
		System.out.println ("Resizing a shape of line weight: " + this.weight);
		super.getDecoratedShape().resize(percent);
	}
}
