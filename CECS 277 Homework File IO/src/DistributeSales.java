import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DistributeSales {
	public static void main(String[] args) {
		try {
			// creates Scanner instance to read File in java
			Scanner reader = new Scanner(new File("Sales.txt"));
			
			int lineNum = 1;
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				String[] elements = line.split(";");
				try {
					String name = elements[0];
					String service = elements[1];
					double price = Double.parseDouble(elements[2]);
					String date = elements[3];
					
					if (validateName(name) && validateService(service) && validateDate(date)) {
						String newFileName = service + ".txt";
						try {
							BufferedWriter file = new BufferedWriter(new FileWriter(newFileName, true));
							file.write(line);
							file.newLine();
							file.close();
						} catch (IOException e) {
							System.out.println("Unable to create a new file!");
						}
					}
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Line " + lineNum + " doesn't have enough argument.");
				} catch (IllegalArgumentException e) {
					System.out.println("Unable to read line " + lineNum);
				} catch (ParseException e) {
					System.out.println("The date of line " + lineNum + " is invalid!");
				}
				lineNum++;
			}
		} catch (FileNotFoundException e){
			System.out.println("Unable to open the file!");
		}
	}
	
	public static boolean validateName(String name) {
		for (int index = 0; index < name.length(); index++) {
			if (!(Character.isLetter(name.charAt(index)) 
				|| Character.isWhitespace(name.charAt(index)))) {
				throw new IllegalArgumentException("Custome's name is invalid");
			}
		}
		return true;
	}
	
	public static boolean validateService(String service) {
		for (int index = 0; index < service.length(); index++) {
			if (!Character.isLetter(service.charAt(index))) {
				throw new IllegalArgumentException("The name of the service is invalid");
			}
		}
		return true;
	}
	
	public static boolean validateDate(String date) throws ParseException {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		df.setLenient(false);
		df.parse(date);
		return true;
	}

}
