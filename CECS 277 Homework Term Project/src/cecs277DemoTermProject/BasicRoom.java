package cecs277DemoTermProject;

import java.util.ArrayList;

/**
 * The basic room class, contains methods for basic room in motel.
 * @author Vy Nguyen and Nicki Huynh
 * @date 12/09/2019
 */
public class BasicRoom implements MotelRoom {
	/** The name of the room. */
	private String name;
	/** The customer of the room. */
	private RoachColony colony;
	/** The price of the room. */
	private double price;
	/** Do not disturb status. */
	private boolean disturb;
	/** Amenity list. */
	private ArrayList<String> amenities;
	
	/**
	 * Constructor of the BasicRoom class.
	 * @param roomName the given name of the room.
	 */
	public BasicRoom(String roomName) {
		this.name = roomName;
		this.price = 50.0;
		this.colony = null;
		this.disturb = true;
		amenities = new ArrayList<>();
	}
	
	/**
	 * Set which colony is occupying the room.
	 * @param colony the give roach colony.
	 */
	public void setColony(RoachColony colony) {
		this.colony = colony;
	}

	@Override
	public double price() {
		return this.price;
	}

	@Override
	public String description() {
		return "BasicRoom " + this.price();
	}
	
	@Override
	public String toString() {
		return "BasicRoom";
	}
	
	@Override
	public boolean hasSprayResistantShower() {
		return false;
	}

	@Override
	public String getName() {
		return this.name;
	}// Returns the name of the room.

	@Override
	public MotelRoom setAvailable() {
		this.price = 50.0;
		this.colony = null;
		return this;
	}

	@Override
	public RoachColony getCustomer() {
		return this.colony;
	}

	@Override
	public String accept(CleaningRoomsVisitor visitor) {
		if (allowToClean()) {
			return visitor.visit(this);
		} //If room does not have "Do Not Disturb" sign out, can clean
		return "";
	}

	@Override
	public void setDoNotDisturb() {
		this.disturb = false;
	}

	@Override
	public void setDisturb() {
		this.disturb = true;
	}

	@Override
	public boolean allowToClean() {
		return this.disturb;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public ArrayList<String> getAmenityList() {
		return amenities;
	}
}
