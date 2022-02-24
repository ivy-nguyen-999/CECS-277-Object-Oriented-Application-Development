package cecs277DemoTermProject;

import java.util.ArrayList;

/**
 * The class adds a Spa to the motel room and changes the price.
 * @author Vy Nguyen, Nicki Huynh
 * @date 12/09/2019
 */
public class Spa extends MotelRoomAmenity {
	/**
	 * Adds a Spa to the room.
	 * @param room The given room.
	 */
	public Spa(MotelRoom room) {
		super(room);
	}

	@Override
	public double price() {
		return this.room.price() + 20.0;
	}// Changes the price of the motel room after adding a spa.

	@Override
	public String description() {
		return this.room.toString() + ", Spa " + this.price();
	}// Changes the description of the room after adding a spa.
	
	@Override
	public String toString() {
		return this.room.toString() + ", Spa";
	}// Overrides the toString method.

	@Override
	public boolean hasSprayResistantShower() {
		return this.room.hasSprayResistantShower();
	}// No change in the functionality.
	
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
		if (!this.room.getAmenityList().contains("Spa")) {
			this.room.getAmenityList().add("Spa");
		}
		return this.room.getAmenityList();
	}
}
