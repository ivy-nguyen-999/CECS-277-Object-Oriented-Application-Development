package cecs277DemoMementoPattern;

public class MementoRunner {

	public static void main(String[] args) {
		Section CECS277 = new Section("CECS 277", "David Brown", 5, DaysOfTheWeek.MONDAY_WEDNESDAY,
				Time.EIGHT, Time.NINE, "VEC", "330");
		System.out.println("CECS277 originally:\n" + CECS277);
		//The syntax needs a little explanation here.  The CareTaker ct is a nested class
		//within Section.  So the left hand side should make sense.  The right hand side 
		//essentially says that the specific instance of Section that is referenced by the
		//variable CECS277 is the one that will have the new instance of CareTaker.  We have
		//to be specific there because CareTaker is NOT a static class, so it has to be 
		//part of a specific instance of Section.
		Section.CareTaker ct = CECS277.new CareTaker();
		ct.add();
		CECS277.setDays(DaysOfTheWeek.TUESDAY_THURSDAY);
		ct.add();
		CECS277.setBuilding("ECS");
		CECS277.setRoom("414");
		ct.add();
		CECS277.setStartTime(Time.THREE_THIRTY);
		CECS277.setEndTime(Time.FOUR_THIRTY);
		System.out.println("After changing the time and location.\n" + CECS277);
		CECS277.getStateFromMemento(ct.get());
		System.out.println("Rolling back by one notch.\n" + CECS277);
		CECS277.getStateFromMemento(ct.get());
		System.out.println("Rolling back by another notch.\n" + CECS277);
		CECS277.getStateFromMemento(ct.get());
		System.out.println("Rolling back by another notch.\n" + CECS277);
	}

}