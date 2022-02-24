import java.io.*;
/**
 * The class does all of the I/O with the Memento file that has all of
 * Memento instances in it
 * @author Vy Nguyen, Nicki Huynh
 */
public class Caretaker {
	private ObjectInputStream in; // read from
	private ObjectOutputStream out; // write to
	private File file;
	
	/**
	 * Takes in a file name for the binary file that is uses to 
	 * write to/ read from.
	 * @param fileName the  file.
	 * @throws IOException exception when creating an ObjectOutputStream.
	 */
	public Caretaker(File fileName) throws IOException {
		this.file = fileName;
		out = new ObjectOutputStream(new FileOutputStream(file, true));
		in = new ObjectInputStream(new FileInputStream(file));
	}
	
	/**
	 * Appends the new memento to the end of the binary file
	 * @param toAdd the memento that is needed to add to the file.
	 * @throws IOException the Exception that the file doesn't exist
	 */
	public void addMemento(PersonMemento toAdd) throws IOException {
		this.out.writeObject(toAdd);
	}
	
	/**
	 * Returns an instance of PersonMemento that has the lowest weight.
	 * @return Person that has the lowest weight.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public PersonMemento getMemento() throws IOException, ClassNotFoundException {
		in.close();
		in = new ObjectInputStream(new FileInputStream(file));

		int lowestWeight = 401;
		PersonMemento returnPerson = null;
		boolean reading = true;
		
		do {
			try {
				PersonMemento temp = (PersonMemento) this.in.readObject();
				if (temp.getSavedPerson().getWeightPounds() < lowestWeight) {
					returnPerson = temp;
					lowestWeight = temp.getSavedPerson().getWeightPounds();
				}
			} catch (EOFException e) {

				reading = false;
			}
		} while (reading);
		return returnPerson;
	}
	
	/**
	 * Returns the first instance of PersonMemento that it finds in the
	 * file that has a weight that matches the input weight. 
	 * @param weight the given weight.
	 * @return PersonMemento that has the weight that matches the given
	 * weight. If none of the Mementos have exactly the weight requested,
	 * return a null pointer
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public PersonMemento getMemento(int weight) throws IOException,
												ClassNotFoundException {
		in.close();
		in = new ObjectInputStream(new FileInputStream(file));
		
		boolean reading = true;
		
		do{
			try {
				PersonMemento temp = (PersonMemento) this.in.readObject();
				if (temp.getSavedPerson().getWeightPounds() == weight) {
					return temp;
				}
			} catch (EOFException e) {
				reading = false;
			}
		} while (reading);
		
		return null;
	}
}