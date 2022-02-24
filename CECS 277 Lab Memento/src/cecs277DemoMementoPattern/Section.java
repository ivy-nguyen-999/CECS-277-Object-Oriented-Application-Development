package cecs277DemoMementoPattern;

import java.util.Stack;

/**
 * This is the class whose state we manage in the memento.
 * @author	David Brown
 * @date	08/24/2019
 */
public class Section {
	/** The name of the course */
	String courseName;
	/** The section number of this particular section */
	int sectionNumber;
	/** The start time name */
	Time startTime;
	/** The end time name */
	Time endTime;
	/** The Building where this section is held */
	String Building;
	/** The room number of this section */
	String Room;
	/** The course instructor's name */
	String instructorName;
	/** The days of the week that the course is offered */
	DaysOfTheWeek days;
	public Section(String courseName, String instructorName, int sectionNumber,
			DaysOfTheWeek days, Time startTime, Time endTime, String building,
			String room) {
		super();
		this.courseName = courseName;
		this.sectionNumber = sectionNumber;
		this.startTime = startTime;
		this.endTime = endTime;
		Building = building;
		Room = room;
		this.instructorName = instructorName;
		this.days = days;
	}
	@Override
	public String toString() {
		return "Section [courseName=" + courseName + ", courseInstructor=" + 
				instructorName + ", sectionNumber=" + sectionNumber + ", days=" +
				days + ", startTime=" + startTime + ", endTime=" + endTime 
				+ ", Building=" + Building + ", Room=" + Room + "]";
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setInstructorName(String instructor) {
		this.instructorName = instructor;
	}
	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}
	public void setDays(DaysOfTheWeek days) {
		this.days = days;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	public void setBuilding(String building) {
		Building = building;
	}
	public void setRoom(String room) {
		Room = room;
	}

	public void getStateFromMemento (Memento mem) {
		this.courseName = mem.getCourseName();
		this.instructorName = mem.getInstructorName();
		this.sectionNumber = mem.getSectionNumber();
		this.days = mem.getDays();
		this.startTime = mem.getStartTime();
		this.endTime = mem.getEndTime();
		this.Building = mem.getBuilding();
		this.Room = mem.getRoom();
	}
	
	/**
	 * Pickle the current state into an instance of Memento and return it.
	 * @return	The memento copy of the present state.
	 */
	public Memento saveStatetoMemento () {
		return new Memento (this.courseName, this.instructorName, this.sectionNumber,
				this.days, this.startTime, this.endTime, this.Building, this.Room);
	}
	
	/** 
	 * The one who manages the Memento objects and doles them out as required.
	 * I could have made a separate class out of this, but then you could run into the problem
	 * of one instance of the CareTaker mixing mementos from different instances of Section,
	 * which would never do.  This nested class is NOT static, so it must be associated with
	 * a particular instance of the enclosing class: Section.
	 * @author	David Brown
	 * @date	08/24/2019
	 */
	public class CareTaker {
		private Stack <Memento> mStack = new Stack <> ();
		
		public void add() {
			//Use the enclosing class's saveStatetoMemento() method to create a fresh memento 
			//instance.  We know this CareTaker has to belong to a specific instance of Section,
			//and we only want mementos from that Section.
			Memento memento = saveStatetoMemento();
			mStack.add(memento);
		}
		
		/** 
		 * Retrieve the most recently added version.  There could be any number of 
		 * ways to designate which memento you wanted.  We could pass in an index 
		 * number (use an ArrayList instead of a stack in that case), or use a lookup
		 * process to find the memento that matches specific characteristics, or 
		 * any of a number of things.  The important thing to this design pattern is
		 * that we have some way to indicate which memento we want.  In this case, 
		 * it is the most recent one.
		 * @return	The most recent memento.
		 */
		public Memento get() {
			return mStack.pop();
		}
	}

}