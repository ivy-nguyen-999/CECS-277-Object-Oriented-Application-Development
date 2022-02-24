package cecs277DemoTermProject;

/**
 * The MotelRoom interface, certain properties each room will have
 * 		such as price, type, name, and others. It will also let the
 * 		motel know if room has the shower amenity or if it can be
 * 		cleaned without the disturb sign up.
 * @author Vy Nguyen and Nicki Huynh
 * @date 12/09/2019
 */
import java.util.ArrayList;

public interface MotelRoom {
	/**
	 * Returns the price of the motel room.
	 * @return the price.
	 */
	double price();
	
	/**
	 * Returns the description of the motel room.
	 * @return the description of the motel room.
	 */
	String description();
	
	/**
	 * Returns which amenity is added to the room.
	 * @return amenity list.
	 */
	ArrayList<String> getAmenityList();
	
	/**
	 * Checks to see if the room has a spray resistant shower.
	 * @return 	True if the room has spray resistant shower.
	 * 			False if the room does not have the spray resistant shower.
	 */
	boolean hasSprayResistantShower();
	
	/**
	 * Returns the name of the room.
	 * @return The name.
	 */
	String getName();
	
	/**
	 * Resets everything in the room, except its type and name.
	 * @return the original room.
	 */
	MotelRoom setAvailable();
	
	/**
	 * Set which colony is occupying the room.
	 * @param colony the give roach colony.
	 */
	void setColony(RoachColony colony);
	
	/**
	 * Returns the occupants of the room.
	 * @return The roach colony.
	 */
	RoachColony getCustomer();
	
	/**
	 * Makes sure all room accept visitor.
	 * @param visitor	Who is visiting room.
	 * @return the cleaning status.
	 */
	String accept(CleaningRoomsVisitor visitor);
	
	/**
	 * Sets the room to be do not disturb.
	 */
	void setDoNotDisturb();
	
	/**
	 * Sets the room to be disturb.
	 */
	void setDisturb();
	
	/**
	 * Gets the disturb status of the room.
	 * @return
	 */
	boolean allowToClean();
}
