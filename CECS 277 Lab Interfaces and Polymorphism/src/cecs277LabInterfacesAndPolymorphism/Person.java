/*
 * Constructs the person with their names and ages, and compare their names
 * @author Vy Nguyen, Nicki Huynh
 */

package cecs277LabInterfacesAndPolymorphism;

public class Person implements Comparable<Person>, Measurable {
   private String firstName;
   private String lastName;
   private int age;
   
   /**
    * Constructor initializes firstName and lastName.
    * @param firstName the given first name
    * @param lastName the given last name
    * @param age the given age
    */
   public Person(String firstName, String lastName, int age) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
   }
   
   // access methods:
   /**
    * Returns first name of the person.
    */
   public String getFirstName() { return firstName; }
   
   /**
    * Returns last name of the person.
    */
   public String getLastName() { return lastName; }

   /**
    * Return a String version of the person's age.
    * Note, this is a really bad idea, we should have stored their birthday and
    * calculated the age, but this is simpler for now.
    * @return String version of this person.
    */
   @Override
   public String toString() {
      return "Name: " + firstName + " " + lastName + " Age: " + age;
   }

   /**
    * Compare one instance of Person (the implicit parameter) to another
    * instance of Person (the explicit parameter that we're calling "Other".
    * @param	Other	The second Person in the comparison.
    * @return			
    * 					Note, we compare by last name first, then the first name.
    * 					Note, we ignore the case in this particular implementation.
    */
   @Override
   public int compareTo(Person Other) {
	   int nameComp = this.getLastName().compareToIgnoreCase(Other.getLastName());
	   if (nameComp == 0) {					//Last names match, so we have to go to the first name.
		   nameComp = this.getFirstName().compareToIgnoreCase(Other.getFirstName());
	   }
	   return nameComp;
   }
   
   /**
    * Returns the age of the person.
    */
   public double getMeasure() {
	   return age;
   }
}
