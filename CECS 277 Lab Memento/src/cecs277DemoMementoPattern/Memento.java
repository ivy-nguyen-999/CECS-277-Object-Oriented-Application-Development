package cecs277DemoMementoPattern;

public class Memento {
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
	
	public Memento(String courseName, String instructorName, int sectionNumber,
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
	public String getCourseName() {
		return courseName;
	}
	public int getSectionNumber() {
		return sectionNumber;
	}
	public Time getStartTime() {
		return startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public String getBuilding() {
		return Building;
	}
	public String getRoom() {
		return Room;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public DaysOfTheWeek getDays() {
		return days;
	}
}