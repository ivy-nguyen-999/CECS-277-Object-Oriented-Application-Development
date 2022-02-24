package cecs277DemoTermProject;

import java.util.ArrayList;

/**
 * The suite room class, contains methods for suite room in motel.
 * @author Vy Nguyen and Nicki Huynh
 * @date 12/09/2019
 */
public class Suite implements MotelRoom {
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
	 * Constructor of the Suite class.
	 * @param roomName the given name of the room.
	 */
	public Suite(String roomName) {
		this.name = roomName;
		this.colony = null;
		this.price = 100.0;
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
		return "Suite " + this.price();
	}
	
	@Override
	public String toString() {
		return "Suite";
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
		this.colony = null;
		this.price = 100.0;
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
