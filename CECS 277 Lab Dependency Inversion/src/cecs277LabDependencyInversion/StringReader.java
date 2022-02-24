package cecs277LabDependencyInversion;

/**
 * The interface StringReader.
 * @author	Vy Nguyen, Nicki Huynh
 * @date	09/25/2019
 */

public interface StringReader {
	// methods of an interface are automatically public
	/**
	 * Gets input from users and put in the next empty line
	 * @return the String input
	 */
	String getValue();
	
	/**
	 * Returns true if it has next line, false if it doesn't have next line
	 */
	boolean hasNext();
}
