/**
 A class that inputs the sales of the customer.
 Homework Assignment: File I/O
 @author Vy Nguyen and Nicki Huynh
 @date 10/21/2019
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class EnterSales {
	public static void main(String[] args) {
		try {
			// if the file does not exist, it is automatically created
			BufferedWriter sales = new BufferedWriter(new FileWriter("Sales.txt", true));
			
			//Create scanner.
			Scanner in = new Scanner(System.in);
			
			boolean exists = false;
			while (!exists) {
				System.out.print("Adding a new sale to the file?(y/n): ");
				char cont = in.nextLine().charAt(0);
				if (cont == 'n') {
					exists = true;
				} //If the answer is no, set exist to be true
				else if (cont == 'y') {
					
					String name = "";
					ServiceSold service = null;
					double amount = 0;
					String date = "";

					// the name of the customer
					do {
						System.out.print("Please enter the name of the customer: ");
						String tempName = in.nextLine().trim();
						// validate
						try {
							name = validateName(tempName);
						} catch (IllegalArgumentException e) {
							System.out.println("Customer's name is invalid");
						}
					} while (name.equals("")); //While name is empty, will loop to get customer name
					
					// the service sold
					do {
						System.out.print("Please enter the name of the service: ");
						String serviceName = in.nextLine().trim().toLowerCase();
						try {
							service = validateService(serviceName);
						} catch (IllegalArgumentException e) {
							System.out.println("That service is invalid!");
						}
					} while (service == null); //While the service is null, will loop to get the service name
					
					// the price
					while (amount == 0) {
						System.out.print("Does the customer using any other services?(y/n): ");
						char answer = in.nextLine().toLowerCase().charAt(0);
						if (answer == 'n') {
							amount = service.price;
						} //If the customer did not use any other services, will set the price to one service
						else if (answer == 'y') {
							do {
								System.out.print("Please enter the price of that service: ");
								try {
									double extra = in.nextDouble();
									in.nextLine();
									amount = service.price + extra;
								} //Will try to get the price of the other service
								catch (IllegalArgumentException e) {
									System.out.println("you entered an invalid amount of money!");
								}	//Will throw exception if the price inputted is invalid
							} while (amount == 0);
						} //If the customer did use other services, will ask for the other service price
						else {
							System.out.println("You did not answer the question approriately!");
						} //If the customer gave another answer other than y or n
					} //While the amount is equal to 0, will loop to get the service price
					
					// the date
					while (date.equals("")) {
						System.out.print("Please enter the date that the service has been"
								+ "/will be rendered (MM/dd/uuuu): ");
						String tempDate = in.nextLine();
						if (isDateValid(tempDate)) {
							date = tempDate;
						} //If the date is valid, will input date in
						else {
							System.out.println("you entered an invalid date!");
						} //If the date is invalid, will not accept it
					} //While the date is empty, will loop to get the date of when the service occurred
					
					Service customer = new Service(name, service.name, amount, date);
					String output = customer.toString();
					sales.write(output);
					sales.newLine();
					System.out.println();
				} //If the answer is y, will create new service with data inputted
				else {
					System.out.println("You did not answer the question approriately!");
				} //If the answer is not y or n
				
			} //While exist is not false, will continue to loop
			sales.close();
			in.close();
		} //Will try to get data and write it to a file
		catch (IOException e) {
			System.out.println("Can't write the data into the file!");
		} //Will throw exception if data cannot be written to a file
	} //Main runner program
	
	public enum ServiceSold {
		
		BREAKFAST("Breakfast", 25.21),
		LUNCH("Lunch", 40.30),
		DINNER("Dinner", 53.68),
		CONFERENCE("Conference", 306.23),
		TEA("Tea", 12.14),
		MASSAGE("Massage", 150.23);
		
		private String name;
		private double price;

		/**
		 * Overloaded constructor of ServiceSold
		 * @param name String name of the service
		 * @param price Double value of the price of service
		 */
		private ServiceSold(String name, double price) {
			this.name = name;
			this.price = price;
		}

		/**
		 * A method to retrieve the name of the service
		 * @return String name of the service
		 */
		public String serviceName() {
			return this.name;
		}

		/**
		 * A method to retrieve the price of the service
		 * @return Double value of the price of the service
		 */
		public double servicePrice() {
			return this.price;
		}
	} //Enum of services offered to customers
	
	public static boolean isDateValid(String date) {
		try {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			df.setLenient(false);
			df.parse(date);
			return true;
		} //Will try to put string date into format and will return true if it can
		catch (ParseException e) {
	    	return false;
	    } //Will throw false out if the string date cannot be placed in format
	} //Method to check if date is in valid format
	
	public static String validateName(String name) {
		for (int index = 0; index < name.length(); index++) {
			if (!(Character.isLetter(name.charAt(index)) 
				|| Character.isWhitespace(name.charAt(index)))) {
				throw new IllegalArgumentException();
			}
		}
		return name;
	}
	
	public static ServiceSold validateService(String serviceName) {
		ServiceSold service;
		if (serviceName.equals("breakfast")) {
			service = ServiceSold.BREAKFAST;
		} //If answer is equals to breakfast, will set the service to breakfast
		else if (serviceName.equals("lunch")) {
			service = ServiceSold.LUNCH;
		} //If answer is equals to lunch, will set the service to lunch
		else if (serviceName.equals("dinner")) {
			service = ServiceSold.DINNER;
		} //If answer is equals to dinner, will set the service to dinner
		else if (serviceName.equals("conference")) {
			service = ServiceSold.CONFERENCE;
		} //If answer is equals to conference, will set the service to conference
		else if (serviceName.equals("tea")) {
			service = ServiceSold.TEA;
		} //If answer is equals to tea, will set the service to tea
		else if (serviceName.equals("massage")) {
			service = ServiceSold.MASSAGE;
		} //If answer is equals to massage, will set the service to massage
		else {
			throw new IllegalArgumentException();
		} //If answer is anything else, throw
		return service;
	}
}

