import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JFileChooser;
/**
 * The class that saves person's data and searches inputted weight
 * @author Vy Nguyen, Nicki Huynh
 * @date 10/30/2019
 */
public class MementoRunner {

	public static void main(String[] args) {
		// Prompts the user for the name and path of the file that they
		// will use for storing their PersonMemento objects
	    JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select a save location");
        
	    boolean foundFile = false; // flag that we don't have any file yet
	    File selectedFile;
	    Caretaker ct = null;
	    
	    do {
	    	try {
	    		if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
	    			selectedFile = chooser.getSelectedFile();
	    			ct = new Caretaker(selectedFile);
	    			foundFile = true;
	    		} //If file is approved and found
	    	} //Will try to find file
	    	catch (IOException IOE) {
	            System.out.println("Failed to find a file.");
	        } //Throws exception if cannot find file
	    } while (!foundFile); //Loops while file foundFile is not false

	    // import scanner
	    Scanner in = new Scanner(System.in);
	    System.out.println("prompting you for persons:");
	    // asks user for their name
	    System.out.print("Enter the person's last name: ");
	    String lname = in.nextLine();
	    System.out.print("Enter the person's first name: ");
	    String fname = in.nextLine();
	    
	    // create a Person
	    Person person =  new Person(lname, fname);
	    
	    // start the loop
	    char answer = 'N';
	    while (answer == 'N') {
	    	// for hair color
	    	boolean hasHair = false;
	    	do {
		    	try {
			    	System.out.println("0: BLACK\n1: BLONDE\n2: RED\n3: AUBURN\n4: SALT_AND_PEPPER"
			    			+ "\n5: GREY\n6: WHITE\n7: BALD");
			    	System.out.print("Please enter the # corresponding to the hair color: ");
			    	int hairNumber = in.nextInt(); in.nextLine();
			    	person.setHairColor(hairNumber);
			    	hasHair = true;
		    	} //Will try to set hair color
		    	catch(IllegalArgumentException e) {
		    		System.out.println("Color number outside of range!");
		    	} //Throws exception if value is not listed for hair colors
		    	catch(InputMismatchException e) {
		    		System.out.println("Please enter a valid value!");
		    	} //Throws exception if not proper value input
	    	} while (!hasHair); //Will loop while hasHair is not false
	    	System.out.println("You entered color: " + person.getHairColor());
	    	
	    	// for height
	    	boolean hasHeight = false;
	    	do {
	    		try {
	    	    	System.out.print("Person's height in feet: ");
	    	    	int feet = in.nextInt(); in.nextLine();
	    	    	System.out.print("And the inches? For instance, 5'10\" would be 10: ");
	    	    	int inches = in.nextInt();in.nextLine();
	    	    	person.setHeight(feet, inches);
	    	    	hasHeight = true;
	    		} //Will try to input height
	    		catch (IllegalArgumentException e) {
	    			System.out.println("Height out of bounds!");
	    		} //Throws exception if value is not in bounds for height
	    		catch(InputMismatchException e) {
		    		System.out.println("Please enter a valid value!");
		    	} //Throws exception if not proper value input
	    	} while (!hasHeight); //Will loop while hasHeight is not false

	    	
	    	// for weight
	    	boolean hasWeight = false;
	    	do {
	    		try {
	    	    	System.out.print("Their weight in pounds: ");
	    	    	int pounds = in.nextInt(); in.nextLine();
	    	    	person.setWeight(pounds);
	    	    	hasWeight = true;
	    		} //Will try to input weight
	    		catch (IllegalArgumentException e) {
	    			System.out.println("Weight out of bounds!");
	    		} //Throws exception if value is not in bounds for weight
	    		catch(InputMismatchException e) {
		    		System.out.println("Please enter a valid value!");
		    	} //Throws exception if not proper value input
	    	} while (!hasWeight); //Will loop while hasWeight is not false
	    	
	    	// print out the person
	    	System.out.println(person.toString());
	    	
	    	// save the person to memento
	    	try {
	    		Person newPerson = new Person(person.getlName(), person.getfName(), person.getHairColor(),
	    				person.getHeightFeet(), (person.getHeightInches() - person.getHeightFeet() * 12),
	    				person.getWeightPounds());
				ct.addMemento(newPerson.save());
			} //Will try to save person into memento
	    	catch (IOException e) {
				System.out.println("Can't write this person to the file!");
			} //Throws exception if unable to save person into memento
	    	
	    	// ask for continue
	    	do {
	    		System.out.print("Are we done here (Y/N)?: ");
	    		answer = in.nextLine().toUpperCase().charAt(0);
	    	} while (answer != 'Y' && answer != 'N'); //Will loop while answer is not equal to 'Y' or 'N'
	    } //Loops while answer is 'N'
	    
	    // Print out the skinniest version
	    try {
	    	System.out.print("Skinniest version: ");
			System.out.println(person.restore(ct.getMemento()));
		} //Will try to find skinniest version of person in momento
	    catch (ClassNotFoundException | IOException | NullPointerException e) {
			System.out.println("Can't print out the skinniest version");
		} //Throws exception if memento is empty and there is no "skinniest" version
	    
	    // search weight
	    try {
	    	System.out.print("What weight do you want to search for? ");
	    	int tempWeight = in.nextInt();
	    	in.nextLine();
	    	if (ct.getMemento(tempWeight) != null) {
	    		System.out.print("Sought after version: ");
	    		System.out.println(person.restore(ct.getMemento(tempWeight)));
	    	} //If version's weight is not equal to null, will print version with matching weight
	    	else {
	    		System.out.println("Can't find a version with that weight!");
	    	} //If version's weight does not match
	    } //Will try to find specific weight
	    catch (ClassNotFoundException | IOException e) {
	    	System.out.println("Can't search that weight.");
	    } //Throws exception if weight cannot be searched
	    
	}

}
