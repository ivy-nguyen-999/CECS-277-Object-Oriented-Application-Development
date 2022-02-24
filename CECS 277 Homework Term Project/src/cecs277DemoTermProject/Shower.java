package cecs277DemoTermProject;

import java.util.ArrayList;

/**
 * The class adds a spray resistant shower to the motel room 
 * and changes the price.
 * @author Vy Nguyen, Nicki Huynh
 * @date 12/09/2019
 */
public class Shower extends MotelRoomAmenity {
	/**
	 * Adds spray resistant shower to the motel room.
	 * @param room the given room.
	 */
	public Shower(MotelRoom room) {
		super(room);
	}

	@Override
	public double price() {
		return this.room.price() + 25.0;
	}// Changes the price of the room after adding a shower.
	
	@Override
	public String description() {
		return this.room.toString() + ", Shower " + this.price();
	}// Changes the description of the room after adding a shower.
	
	@Override
	public String toString() {
		return this.room.toString() + ", Shower";
	}// Overrides the toString method.

	@Override
	public boolean hasSprayResistantShower() {
		return true;
	}// Returns true.

	@Override
	public String getName() {
		return this.room.getName();
	}// No change in the functionality.
	
	@Override
	public MotelRoom setAvailable() {
		return this.room.setAvailable();
	}
	
	@Override
	public void setColony(RoachColony colony) {
		this.room.setColony(colony);
	}// No change in the functionality.
	
	@Override
	public RoachColony getCustomer() {
		return this.room.getCustomer();
	}
	
	@Override
	public String accept(CleaningRoomsVisitor visitor) {
		return this.room.accept(visitor);
	}

	@Override
	public void setDoNotDisturb() {
		this.room.setDoNotDisturb();
	}

	@Override
	public void setDisturb() {
		this.room.setDisturb();
	}

	@Override
	public boolean allowToClean() {
		return this.room.allowToClean();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public ArrayList<String> getAmenityList() {
		if (!this.room.getAmenityList().contains("Shower")) {
			this.room.getAmenityList().add("Shower");
		}
		return this.room.getAmenityList();
	}
}
