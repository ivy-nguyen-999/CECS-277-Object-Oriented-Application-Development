package cecs277DemoFactoryPatternGeometry;

public class ConcreteFactoryPoints extends AbstractFactory {
	/**
	 * This factory builds Geometric objects of the points family, 
	 * that is, internally they manage their dimensions with nothing
	 * more than an array of points.  The alternative to that style is the 
	 * point/dimensions style.  Both styles of Geometric object accept an array
	 * of points for the constructor, what they do with them behind the scenes
	 * is where the magic happens.
	 * 
	 * You might notice that this has no constructor and no instance variables,
	 * so this could have been done as a static class just as easily.
	 * @author	David Brown
	 * @date	11/21/2019
	 */

	@Override
	public GeometricShape getGeometricShape(ShapeType shapeType, Point[] points) throws InvalidShapeException {
		if (shapeType == ShapeType.RECTANGLE) {
			return new Rectangle4Points(points);
		} else if (shapeType == ShapeType.LINE_SEGMENT) {
			return new LineSegment2Points(points);
		} else if (shapeType == ShapeType.CIRCLE) {
			return new Circle2Points(points);
		}
		else {						// Bad shape type passed in, could throw an exception here instead.
			return null;
		}
	} // End of the getGeometricShape method
} // End of the ConcreteFactoryPoints class