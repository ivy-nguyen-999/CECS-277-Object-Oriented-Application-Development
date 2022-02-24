package cecs277DemoTermProject;

import java.util.ArrayList;

/**
 * The FoodBar class adds a food bar to the room.
 * @author Vy Nguyen, Nicki Huynh
 * @date 12/09/2019
 */
public class FoodBar extends MotelRoomAmenity {
	/**
	 * Adds a food bar to the room.
	 * @param room The given room.
	 */
	public FoodBar(MotelRoom room) {
		super(room);
	}

	@Override
	public double price() {
		return this.room.price() + 10.0;
	}// Returns the price of the room after adding a food bar to the room.

	@Override
	public String description() {
		return this.room.toString() + ", FoodBar " + this.price();
	}// Returns the description of the room after adding a food bar to the room.
	
	@Override
	public String toString() {
		return this.room.toString() + ", FoodBar";
	}// Override the toString method.

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
	}// No change in the functionality.

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
		if (!this.room.getAmenityList().contains("FoodBar")) {
			this.room.getAmenityList().add("FoodBar");
		}
		return this.room.getAmenityList();
	}
}
