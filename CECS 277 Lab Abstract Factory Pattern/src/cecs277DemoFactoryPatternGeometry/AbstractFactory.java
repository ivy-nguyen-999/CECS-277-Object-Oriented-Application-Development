package cecs277DemoFactoryPatternGeometry;

public abstract class AbstractFactory {
	/**
	 * The prototype if you will for any factory producing geometric objects.
	 * @param	shapeType	What type of shape you want to create.	
	 * @param	points		The list of one or more points to define the object.
	 * @return				The geometric object of concern.
	 * @throws InvalidShapeException 
	 */
	public abstract GeometricShape getGeometricShape (ShapeType shapeType, Point [] points) throws InvalidShapeException;
} // End of the AbstractFactory class