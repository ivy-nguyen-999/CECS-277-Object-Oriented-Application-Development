package cecs277DemoTermProject;
/**
 * Cleaning Room interface, methods to allow cleaning person
 * 		to visit different types of room to clean.
 * @author Vy Nguyen and Nicki Huynh
 * @date 12/09/2019
 */
public interface CleaningRoomsVisitor {
	/**
	 * Visits the BasicRoom type to clean.
	 * @param room		Which BasicRoom is being visited.
	 * @return			Result of cleaning room.
	 */
	String visit(BasicRoom room);

	/**
	 * Visits the DeluxeRoom type to clean.
	 * @param room		Which DeluxeRoom is being visited.
	 * @return			Result of cleaning room.
	 */
	String visit(DeluxeRoom room);

	/**
	 * Visits the Suite type to clean.
	 * @param room		Which Suite is being visited.
	 * @return			Result of cleaning room.
	 */
	String visit(Suite room);
}
