package cecs277DemoTermProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * RoachMotel uses Singleton pattern to ensure that it has only one instance
 * and provide a global point to access to it.
 * @author Vy Nguyen and Nicki Huynh
 * @date 12/09/2019
 */

public class RoachMotel implements Subject, Management {
	/**
	 * The RoachMotel instance. the volatile keyword makes sure that multiple threads
	 * handle the unique instance variable correctly when we initialize it.
	 */
	private volatile static RoachMotel motel;
	/** The name of the motel. */
	private String name;
	/** The number of rooms of the motel. */
	private int capacity;
	/** The sign that shows the motel still has available rooms or not. */
	private String sign;
	/** Available rooms of the motel. */
	private Queue<MotelRoom> availableRooms;
	/** Occupied rooms of the motel. */
	private ArrayList<MotelRoom> occupiedRooms;
	/** The waiting list of the motel. */
	private ArrayList<Observer> waitingList;
	/** The list of customers who are actually in the motel. */
	private ArrayList<RoachColony> customerList;
	/** Transaction log. */
	private static String transactionLog;
	/** File corresponding to log file name */
	private File logFile;
	/** Flag to tell whether we have written to this log yet or not. */
	boolean append = false;
	
	/** The private constructor that only this class can use.*/
	private RoachMotel(){
		this.waitingList = new ArrayList<>();
		this.availableRooms = new LinkedList<>();
		this.occupiedRooms = new ArrayList<>();
		this.customerList = new ArrayList<>();
		this.name = "Doesn't has a name yet.";
		this.capacity = 0;
		this.sign = "No Vacancy";
		transactionLog = "transactionLog.txt";
		this.logFile = new File(this.transactionLog);
	}
	
	/**
	 * This essentially takes the place of the RoachMotel constructor.
	 * @return the one and only instance of the RoachMotel class.
	 * @throws IOException 
	 */
	public static RoachMotel getRoachMotel() {
		// Uses double checked locking:
		if (motel == null) {
			synchronized (RoachMotel.class) {
				if (motel == null) {
					motel = new RoachMotel();
				}// Check again as multiple threads can reach above step.
			}// To make thread safe.
		}// If the motel is not created yet.
		return motel;
	}// The motel is not created until we need it and call getMotel().
	
	/**
	 * Specifies the capacity (number of rooms) and the name of the motel.
	 * @param motelName The name of the motel.
	 * @param capacity The number of rooms.
	 */
	public void buildRoachMotel(String motelName, int capacity) {
		if (capacity < 1) {
			throw new IllegalArgumentException("Invalid capacity!");
		}// Throws IllegalArgumentException if the capacity is less than or equal to 0.
		this.name = motelName;
		this.capacity = capacity;
		this.sign = "No Vacancy";
	}// Initializes each variable in the class.
	
	/**
	 * Returns the name of the motel.
	 * @return The name of the motel.
	 */
	public String getMotelName() {
		return this.name;
	}// Returns the name of the motel.
	
	/**
	 * Returns the number of rooms in the motel.
	 * @return The capacity of the motel.
	 */
	public int getMotelCapacity() {
		return this.capacity;
	}// Returns the capacity.
	
	/**
	 * Returns the sign of the motel.
	 * @return 	"No Vacancy" if the motel is full.
	 * 			"Vacancy" if the motel still has available rooms.
	 */
	public String getMotelSign() {
		updateMotelSign();
		return this.sign;
	}// Returns the sign.
	
	// helper method.
	private void updateMotelSign() {
		if (availableRooms.isEmpty()) {
			this.sign = "No Vacancy";
		} //If there are no available rooms, sign says "No Vacancy"
		else {
			this.sign = "Vacancy";
		} //If there is at least one room open, sign says "Vacancy"
	}
	
	/**
	 * Returns String representation of rooms in the motel.
	 * @return a list of available rooms and occupied room.
	 */
	@Override
	public String toString() {
		String display = "motel: {";
		// using Iterator to iterate through the list of occupied rooms.
		Iterator<MotelRoom> occupiedItr = this.occupiedRooms.iterator();
		// hasNext() returns true if the list has more elements.
		while (occupiedItr.hasNext()) {
			MotelRoom temp = occupiedItr.next();
			display += temp.description() + " = " + temp.getCustomer();
			if(occupiedItr.hasNext()) {
				display += "; ";
			}// adding semicolon if the list still have next room.
		}// end while loop.
		display += "}\navailable Rooms: [";
		// using Iterator to iterate through the list of available rooms.
		Iterator<MotelRoom> availableItr = this.availableRooms.iterator();
		// hasNext() returns true if the list has more elements.
		while (availableItr.hasNext()) {
			display += availableItr.next().getName();
			if(availableItr.hasNext()) {
				display += ", ";
			}// adding comma if the list still have next room.
		}// end while loop.
		display += "]";
		return display;
	}
	
	/**
	 * Initializes the available rooms list.
	 * @param room The room to add to the list.
	 */
	public void addRooms(MotelRoom room) {
		if ((availableRooms.size() + occupiedRooms.size() + 1) > this.capacity) {
			throw new IllegalArgumentException("Can't add more rooms to this motel.");
		}// Makes sure we don't have more rooms than the capacity.
		availableRooms.add(room);
		updateMotelSign();
	}
	
	/**
	 * When the customer checks in.
	 * @param colony The customer.
	 * @return the motel room for that colony.
	 */
	public MotelRoom checkIn(RoachColony colony) {
		if (waitingList.contains(colony) && availableRooms.size() > 0) {
			waitingList.remove(colony);
		}// Check if colony is in the waiting list
		
		if (availableRooms.size() > 0) {
			MotelRoom temp = availableRooms.poll();
			temp.setColony(colony);
			colony.registerManagement(this);
			this.customerList.add(colony);
			return temp;
		}// Check to see if there is still available room.
		
		else {
			registerObserver(colony);
		}// If a Customer tries to check in and the hotel is full,
		// The customer gets waitlisted.
		return null;
	}
	
	/**
	 * Updates the rooms that are occupied.
	 * @param room	The new room that is now occupied.
	 */
	public String updateCheckIn(MotelRoom room) {
		String output = "";
		if (room != null) {
			occupiedRooms.add(room);
			output += "in set amenities: " + room.getAmenityList() + "\n";
			output += room.description() + "\n" + room.getCustomer();
		} //If room does not equal to null
		else {
			output += "There is no available room right now.";
		} //Otherwise
		updateMotelSign();
		return output;
	}
	
	/**
	 * Returns the cleaning status for each room.
	 * @return the cleaning status.
	 */
	public String cleaningStatus() {
		String status = "";
		CleaningRoomsVisitor visitor = new CleaningRoomsVisitorImpl();
		for (MotelRoom room : occupiedRooms) {
			status += "room number is: " + room.getName() + "\nCleaning room: " + room.getName();
			status += "\n" + room.accept(visitor) + "\n";
		} //Loops through the occupied motel rooms
		return status;
	}
	
	private void spray(RoachColony colony) {
		// find the room of the colony.
		// using Iterator to iterate through the list of occupied rooms.
		Iterator<MotelRoom> occupiedItr = this.occupiedRooms.iterator();
		MotelRoom motelRoom = null;
		while (occupiedItr.hasNext()) {
			MotelRoom temp = occupiedItr.next();
			String tempName = temp.getCustomer().getColonyName();
			if (tempName.equals(colony.getColonyName())) {
				motelRoom = temp;
				break; // end the loop once found.
			}// If we find the room of that customer.
		}// Loop the occupied rooms list.
		
		if (motelRoom.hasSprayResistantShower()) {
			colony.gotSprayed(0.25);
		} //If room has Shower amenity, will lose 25% of population
		else {
			colony.gotSprayed(0.50);
		} //If room does not have Shower amenity, will lose 50% of population
	}
	
	/**
	 * Checks out the Roach Colony and gets them to pay. Records transaction of payment.
	 * @param colony		Roach colony that will be checking out.
	 * @param NumOfDays		Number of days the colony stayed in motel.
	 * @param payment		What kind of payment colony will use.
	 * @return				The amount the colony has to pay.
	 */
	public String checkOut(RoachColony colony, int NumOfDays, PaymentStrategy payment) throws IOException {
		if (!this.customerList.contains(colony)) {
			throw new IllegalArgumentException("This roach colony did not check in yet.");
		}// Throw an exception when the colony is not in the customer list.
		// using Iterator to iterate through the list of occupied rooms.
		Iterator<MotelRoom> occupiedItr = this.occupiedRooms.iterator();
		MotelRoom motelRoom = null;
		while (occupiedItr.hasNext()) {
			MotelRoom temp = occupiedItr.next();
			String tempName = temp.getCustomer().getColonyName();
			if (tempName.equals(colony.getColonyName())) {
				motelRoom = temp;
				break; // end the loop once found.
			}// If we find the room of that customer.
		}// Loop the occupied rooms list.
		String pay = payment.pay(NumOfDays * motelRoom.price());
		colony.removeManagement(this);
		occupiedRooms.remove(motelRoom);
		motelRoom = motelRoom.setAvailable();		
		availableRooms.add(motelRoom);
		updateMotelSign();
		notifyObservers();
		// write to the transaction log
		RoachMotel log = RoachMotel.getRoachMotel();
		log.log(pay);
		return pay;
	}
	
	/**
	 * Retrieved the transaction log of the motel.
	 * @return	the file transaction log.
	 */
	public File getTransactionLog() {
		return new File(this.transactionLog);
	}
	
	@Override
	public boolean registerObserver(Observer observer) {
        if (waitingList.contains(observer)) {
            return false;
        } // Return false if observer already has that observer
        else {
        	waitingList.add(observer);
            return true;
        } // Return true and add observer otherwise
	}

	@Override
	public boolean removeObserver(Observer observer) {
        if (waitingList.contains(observer)) {
        	waitingList.remove(observer);
            return true;
        } // Return true and remove observer if observer is registered
        else {
            return false;
        } // Return false otherwise
	}

	@Override
	public void notifyObservers() {
		Iterator<Observer> itr = this.waitingList.iterator();
		while (itr.hasNext()) {
			itr.next().update(this);
		}
	}
	
	/**
	 * Logs the data into a text file.
	 * @param message The String message that is to be logged.
	 */
	public void log (String message) {
		FileWriter fileWriter = null;
		synchronized (this) {
			try {
				//Create a new FileWriter and append if we have written anything already.
				fileWriter = new FileWriter (this.logFile.getAbsoluteFile(), this.append);
				this.append = true;	// From here on out, append
			} //Try to write data to file
			catch (IOException e) {
				e.printStackTrace();
			} // End of squelching the IOException exception
			PrintWriter pw = new PrintWriter (fileWriter);
			pw.println(message);
			pw.close();
		} //Make thread safe
	}

	@Override
	public void update(Customer colony) {
		RoachColony col = (RoachColony) colony;
		spray(col);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
