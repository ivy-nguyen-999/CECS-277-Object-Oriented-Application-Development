/*
 * Demonstrate the use of interfaces by implementing Measurable in the person class
 * @author Vy Nguyen, Nicki Huynh
 */

package cecs277LabInterfacesAndPolymorphism;
import java.util.Arrays;

public class InterfaceAndPolymorphismRunner {
	
	public static void main(String[] args) {
		
		// creates a array of the person class
		Person[] people = new Person[4];
		// adds people to the array
		Person personOne = new Person("Vy", "Nguyen", 20);
		people[0] = personOne;
		Person personTwo = new Person("Nicki", "Huynh", 21);
		people[1] = personTwo;
		Person personThree = new Person("Jessica", "Nguyen", 28);
		people[2] = personThree;
		Person personFour = new Person("James", "Williams", 3);
		people[3] = personFour;
		
		// display the array of Persons
		for(Person person : people) {
			// using method toString to print out each person
			System.out.println(person.toString());
		}
		
		// sort the array Person by using parallelSort
		Arrays.parallelSort(people);
		
		System.out.println();
		// display the array of Persons after sorting
		for(Person person : people) {
			// using method toString to print out each person
			System.out.println(person.toString());
		}
		
		// Calculate the average
		System.out.println();
		System.out.print("the average: ");
		System.out.println(Data.average(people));

	}
}
