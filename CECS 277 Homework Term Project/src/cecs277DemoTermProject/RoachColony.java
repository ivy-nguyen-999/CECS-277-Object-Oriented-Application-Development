package cecs277DemoTermProject;
/**
 * RoachColony class, the colony that will or will try
 * 		to check into the Roach Motel. Contains their
 * 		name, population, growth rate, and etc.
 * @author Vy Nguyen and Nicki Huynh
 * @date 12/09/2019
 */
import java.util.ArrayList;
import java.util.Iterator;

public class RoachColony implements Observer, Customer {
	/** The name of the roach colony. */
	private String name;
	/** The initial population. */
	private int population;
	/** The growth rate. */
	private double rate;
	/** The management. */
	private ArrayList<Management> management;
	
	/**
	 * The constructor of the RoachColony.
	 * @param name The name of the colony.
	 * @param population The initial population.
	 * @param rate The growth rate.
	 */
	public RoachColony(String name, int population, double rate) {
		this.name = name;
		this.population = population;
		this.rate = rate;
		management = new ArrayList<>();
	}
	
	/**
	 * Returns the name of the roach colony.
	 * @return The name of the roach colony.
	 */
	public String getColonyName() {
		return this.name;
	}
	
	/**
	 * Returns the population of the roach colony.
	 * @return the population of the roach colony.
	 */
	public int getPopulation() {
		return this.population;
	}
	
	/**
	 * When the colony throw a party, the number of occupants in the room increases
	 * by the growth rate.
	 */
	public void throwParty() {
		population = (int) (population * rate);
		notifyManagement();
	}
	
	public void gotSprayed(double lost) {
		double left = 1 - lost;
		this.population = (int) (this.population * left);
	}
	
	@Override
	public void update(Subject update) {
		String output = "The " + this.name + " colony received the notification from "
				+ RoachMotel.getRoachMotel().getMotelName();
		System.out.println(output);
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.population;
	}

	@Override
	public boolean registerManagement(Management motel) {
        if (management.contains(motel)) {
            return false;
        } // Return false if observer already has that observer
        else {
        	management.add(motel);
            return true;
        } // Return true and add observer otherwise
	}

	@Override
	public boolean removeManagement(Management motel) {
        if (management.contains(motel)) {
        	management.remove(motel);
            return true;
        } // Return true and remove observer if observer is registered
        else {
            return false;
        } // Return false otherwise
	}

	@Override
	public void notifyManagement() {
		Iterator<Management> itr = this.management.iterator();
		while (itr.hasNext()) {
			itr.next().update(this);
		} //While there is a next
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
