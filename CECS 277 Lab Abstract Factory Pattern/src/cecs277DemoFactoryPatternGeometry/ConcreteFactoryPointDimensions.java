package cecs277DemoFactoryPatternGeometry;

/**
 * This factory builds Geometric objects of the point/dimension family, 
 * that is, internally they manage their dimensions with a single point
 * and one or more dimensions.  The alternative to that style is the 
 * array of points.  Both styles of Geometric object accept an array
 * of points for the constructor, what they do with them behind the scenes
 * is where the magic happens.
 * @author	David Brown
 * @date	11/21/2019
 */
public class ConcreteFactoryPointDimensions extends AbstractFactory {

	@Override
	public GeometricShape getGeometricShape(ShapeType shapeType, Point[] points) throws InvalidShapeException {
		if (shapeType == ShapeType.RECTANGLE) {
			return new RectanglePointWidthHeight (points);
		} else if (shapeType == ShapeType.LINE_SEGMENT) {
			return new LineSegmentPointVector (points);
		} else if (shapeType == ShapeType.CIRCLE) {
			return new CirclePointRadius(points);
		} else {						// Bad shape type passed in, could throw an exception here instead.
			return null;
		}
	} // End of the getGeometricShape method
} // End of the ConcreteFactoryPointDimensions class