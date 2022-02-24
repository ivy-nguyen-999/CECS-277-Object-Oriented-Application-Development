package cecs277DemoFactoryPatternGeometry;

/**
 * This creates an instance of the proper factory, based on the factory
 * type passed in.  If an invalid factory type is passed in, we just 
 * return a null, but that's highly unlikely since I'm using an enumeration
 * to regulate the factory types that we'll accept.
 * @author	Dave Brown
 * @date	11/21/2019
 */
public class FactoryProvider {
	public static AbstractFactory getFactory (FactoryType factoryType) {
		AbstractFactory results;
		switch (factoryType) {
		case POINT_DIMENSIONS:
			results =  new ConcreteFactoryPointDimensions();
			break;
		case POINTS:
			results = new ConcreteFactoryPoints();
			break;
		default:
			results = null;
		}
		return results;
	} // End of the getFactory method
} // End of the FactoryProvider class