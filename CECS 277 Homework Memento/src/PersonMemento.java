import java.io.Serializable;
/**
 * A class to performs the duties of the Memento class.
 * @author Vy Nguyen, Nicki Huynh
 */

@SuppressWarnings("serial")
public class PersonMemento implements Serializable {
	/** The person that is saved into the memento */
	private Person savedPerson;
	
	/**
	 * Constructor that takes in the Person instance and save it.
	 * @param savedPerson The Person instance to preserve into an
	 * instance of PersonMemento.
	 */
	public PersonMemento(Person savedPerson) {
		this.savedPerson = savedPerson;
	}
	
	/**
	 * Return the person in memento.
	 * @return an instance of Person with the same values as the Memento.
	 */
	public Person getSavedPerson() {
		return this.savedPerson;
	}
	
	
}
