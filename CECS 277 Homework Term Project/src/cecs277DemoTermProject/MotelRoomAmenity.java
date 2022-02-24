package cecs277DemoTermProject;
/**
 * Using Decorator pattern:
 * Abstract wrapper class that implements the MotelRoom.
 * @author Vy Nguyen, Nicki Huynh
 * @date 12/09/2019
 *
 */
public abstract class MotelRoomAmenity implements MotelRoom {
	/** 
	 * Implemented MotelRoom to allow adding additional functionalities
	 * to all of the defined (concrete MotelRoom classes - BasicRoom,
	 * DeluxeRoom, and Suite).
	 */
	protected MotelRoom room;
	
	/**
	 * The constructor of the class, specifying which room we are about
	 * to add amenity to.
	 * @param room The room that we want to add amenity to.
	 */
	public MotelRoomAmenity(MotelRoom  room) {
		super();
		this.room = room;
	}// Constructor of this abstract class.

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
