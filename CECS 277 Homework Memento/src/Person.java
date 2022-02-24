import java.io.Serializable;

/**
 * Demonstration class that we will preserve into an instance of Memento.
 * @author Vy Nguyen, Nicki Huynh
 */

@SuppressWarnings("serial")
public class Person implements Serializable{
	/** Height of the person in inches. */
	private int heightInches;
	/** The weight of the person in pounds.  Ounces not significant. */
	private int weightPounds;
	/** Last Name of the person. */
	private String lName;
	/** First Name of the person.*/
	private String fName;
	/** The person's hair color */
	private HairColor hairColor;
	/** Ratio of inches to feet. */
	public static final int inchesPerFoot = 12;
	/** Maximum believable height in inches.*/
	private static final int maxHeight = 7 * inchesPerFoot;
	/** Minimum believable height in inches. */
	private static final int minHeight = 1 * inchesPerFoot;
	/** Maximum believable weight in pounds.*/
	private static final int maxWeight = 400;
	/** Minimum believable weight in pounds.*/
	private static final int minWeight = 20;
	
	public enum HairColor {
		//each is an instance of Color
	    BLACK, BLONDE, RED, AUBURN, SALT_AND_PEPPER, GREY, WHITE, BALD;
		/**
		 * Return the hair color according to the color number.
		 * @param 	colorNumber the number of the color.
		 * @return 	the hair color if found, else.
		 * @throw 	IllegalArgumentException if the color number outside of range.
		 */
		public static HairColor getColor (int colorNumber) {
			int currentColor = 0;
			boolean found = false;
			HairColor results = HairColor.BLACK;
			for (HairColor color:values() ) {
				if (currentColor == colorNumber) {
					results = color;
					found = true;
					break;
				}
				currentColor++;
			}
			if (found) {
				return results;
			} else {
				throw new IllegalArgumentException ("Color number outside of range!");
			}
		}
	}
		
	/**
	 * Build a new person.
	 * @param lName				Last name.
	 * @param fName 			First name.
	 * @param color				Color of the person's hair.
	 * @param heightInFeet		Height of the person in feet.
	 * @param heightInInches	Inches portion of their height.
	 * @param weightInPounds	Weight of the person, in pounds.
	 */
	public Person (String lName, String fName, HairColor color, int heightInFeet,
			int heightInInches, int weightInPounds) {
		setHeight (heightInFeet, heightInInches);//Update the height
		setWeight (weightInPounds);
		this.lName = lName;
		this.fName = fName;
		this.hairColor = color;
	}
	
	/**
	 * Overloading constructor of person: create a new person.
	 * @param lName Last name.
	 * @param fName First name.
	 */
	public Person (String lName, String fName) {
		this.lName = lName;
		this.fName = fName;
		this.hairColor = HairColor.BALD;
	}
	
	/**
	 * Return the last name of the person.
	 * @return Last name.
	 */
	public String getlName () {
		return this.lName;
	}
	
	/**
	 * Return the first name of the person.
	 * @return First name.
	 */
	public String getfName () {
		return this.fName;
	}
	
	/**
	 * Retrieve the person's hair color.
	 * @return	Their current hair color.
	 */
	public HairColor getHairColor () {
		return this.hairColor;
	}
	
	/**
	 * Set the person's hair color.
	 * @param newColor	Their new hair color.
	 */
	public void setHairColor (HairColor newColor) {
		this.hairColor = newColor;
	}
	
	/**
	 * Set the person's hair color.
	 * @param hairNumber the number of color
	 */
	public void setHairColor (int hairNumber) {
		this.hairColor = HairColor.getColor(hairNumber);
	}
	
	/**
	 * Set the person's height.
	 * @param feet 		height in feet.
	 * @param inches 	height in inches.
	 */
	public void setHeight (int feet, int inches) {
		int totalInches = netHeight (feet, inches);
		if (totalInches < minHeight || totalInches > maxHeight) {
			throw new IllegalArgumentException("Height out of bounds!");
		} else {
			this.heightInches = totalInches;
		}
	}
	
	/**
	 * Set the person's weight.
	 * @param pounds	weight in pounds.
	 */
	public void setWeight (int pounds) {
		if (pounds < minWeight || pounds > maxWeight) {
			throw new IllegalArgumentException ("Weight out of bounds!");
		} else {
			this.weightPounds = pounds; 
		}
	}
	
	/**
	 * Give the height of the person in inches.
	 * @return Height in inches.
	 */
	public int getHeightInches () {
		return this.heightInches;
	}
	
	/**
	 * Return the feet (floor) of the person.
	 * @return the feet of the person
	 */
	public int getHeightFeet () {
		return this.getHeightInches()/inchesPerFoot;
	}
	
	/**
	 * Return the number of lbs the person weighs.
	 * @return	The number of pounds that the person weighs.
	 */
	public int getWeightPounds () {
		return this.weightPounds;
	}
	
	/**
	 * Calculate height from feet & inches.
	 * @param feet	The feet in height.
	 * @param inches	The inches above the last foot that need to be added to get 
	 * height in inches.
	 * @return	Total height in inches.
	 */
	private static int netHeight (int feet, int inches) {
		return feet * inchesPerFoot + inches;
	}
	
	/**
	 * Return string version of the Person.
	 * @return	Display string of the person.
	 */
	@Override
	public String toString () {
		return String.format("Name: %s, %s, Hair Color: %s, Height:%d'%d, Weight #: %d",
				this.lName, this.fName, "" + this.hairColor, this.getHeightFeet(), 
				this.getHeightInches()%inchesPerFoot,
				this.weightPounds);//So we can print the Person.
	}
	
	/**
	 * Create an instance of PersonMemento from the current Person instance.
	 * @return the instance of PersonMemento that is created.
	 */
	public PersonMemento save() {
		return new PersonMemento(this);
	}
	
	/**
	 * Return an instance of Person that has the same state as the Person instance stored
	 * in the supplied PersonMemento
	 * @param archive The supplied PersonMemento
	 * @return an instance of Person
	 */
	public Person restore(PersonMemento archive) {
        Person out = null;
        if(archive != null)
            out = archive.getSavedPerson();
        return out;
	}
}