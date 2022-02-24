package cecs277DemoFactoryPatternGeometry;
/**
 * The runner to test out the factory
 * @author	Vy Nguyen, Nicki Huynh
 * @date	11/25/2019
 */
public class FactoryRunner {

	public static void main(String[] args) {
		// creates points
		Point one = new Point(-5, 0);
		Point two = new Point(0, 5);
		Point three = new Point(10, -5);
		Point four = new Point(5, -10);
		// creates 3 arrays of points
		Point[] rPoints = {one, two, three, four};
		Point[] lPoints = {one, two};
		Point[] cPoints = {two, three};
		// creates a ConcreteFactoryPoints and ConcreteFactoryPointDimensions.
		AbstractFactory factoryP = FactoryProvider.getFactory(FactoryType.POINTS);
		AbstractFactory factoryD = FactoryProvider.getFactory(FactoryType.POINT_DIMENSIONS);
		//  Create GeometricObjects
		GeometricShape rectangleP = null;
		GeometricShape rectangleD = null;
		GeometricShape lineSegmentP = null;
		GeometricShape lineSegmentD = null;
		GeometricShape circleP = null;
		GeometricShape circleD = null;
		try {
			// initialize value for each shape
			rectangleP = factoryP.getGeometricShape(ShapeType.RECTANGLE, rPoints);
			rectangleD = factoryD.getGeometricShape(ShapeType.RECTANGLE, rPoints);
			lineSegmentP = factoryP.getGeometricShape(ShapeType.LINE_SEGMENT, lPoints);
			lineSegmentD = factoryD.getGeometricShape(ShapeType.LINE_SEGMENT, lPoints);
			circleP = factoryP.getGeometricShape(ShapeType.CIRCLE, cPoints);
			circleD = factoryD.getGeometricShape(ShapeType.CIRCLE, cPoints);
		} catch (InvalidShapeException ISE) {
			System.out.println("Can't create the shape!");
		} // catch InvalidShapeException when can't create the shape
		
		System.out.println("Testing the factory!");
		// display the points:
		// for rectangle
		System.out.println("\nPoints for rectangle: ");
		for (Point point : rPoints) {
			System.out.println("	" + point);
		}
		// for line segment
		System.out.println("\nPoints for line segment: ");
		for (Point point : lPoints) {
			System.out.println("	" + point);
		}
		// for circle
		System.out.println("\nPoints for circle: ");
		for (Point point : cPoints) {
			System.out.println("	" + point);
		}
		// print out the results
		System.out.println();
		System.out.println(rectangleP + "\n" + rectangleD + "\n" 
				+ lineSegmentP + "\n" + lineSegmentD + "\n"
				+ circleP + "\n" + circleD);
		// completed satisfactorily
		System.out.println();
		System.out.println("Completed satisfactorily");
	} // end the main

}
