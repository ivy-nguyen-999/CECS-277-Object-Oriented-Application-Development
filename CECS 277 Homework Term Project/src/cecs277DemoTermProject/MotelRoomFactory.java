package cecs277DemoTermProject;
/**
 * MotelRoomFactory class for the Factory design, used to
 * 		create the different types of rooms in the motel.
 * @author Vy Nguyen and Nicki Huynh
 * @date 12/09/2019
 */
public class MotelRoomFactory {
	/**
	 * Create a MotelRoom based on given information.
	 * @param type The type of the motel.
	 * @param roomName The name of the room.
	 * @return The MotelRoom based on given information.
	 */
	public MotelRoom getMotelRoom(MotelRoomType type, String roomName) {
		if (type == MotelRoomType.BASIC_ROOM) {
			return new BasicRoom(roomName);
		} //If type is BasicRoom type, will create BasicRoom with name
		else if (type == MotelRoomType.DELUXE_ROOM) {
			return new DeluxeRoom(roomName);
		} //If type is DeluxeRoom type, will create DeluxeRoom with name
		else if (type == MotelRoomType.SUITE) {
			return new Suite(roomName);
		} //If type is Suite type, will create Suite with name
		else {
			return null;
		} //Otherwise if not any of the other types
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
