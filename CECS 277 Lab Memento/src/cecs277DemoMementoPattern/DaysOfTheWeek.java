package cecs277DemoMementoPattern;

public enum DaysOfTheWeek {
	MONDAY_WEDNESDAY, TUESDAY_THURSDAY, FRIDAY, SATURDAY;
	
	public String toString () {
		String[] temp = this.name().toLowerCase().split("_");
		String returnString = temp[0].substring(0,1).toUpperCase() 
				+ temp[0].substring(1);
		
		if (temp.length > 1) {
			returnString += " " + temp[1].substring(0,1).toUpperCase() 
					+ temp[1].substring(1);
		}
		
		return returnString;
	}
}
