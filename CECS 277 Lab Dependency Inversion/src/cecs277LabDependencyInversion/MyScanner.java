package cecs277LabDependencyInversion;

import java.util.Scanner;

/**
 * Singleton design pattern for managing a single input Scanner for the application.
 * It probably ought to have a different name since this is not a generic scanner but
 * only a console scanner.
 * @author	David Brown
 * @date	07/22/2019
 */

public class MyScanner {
	/** The resource that we are managing. */
	private static Scanner in;
	
	/**
	 * The constructor is the only time that we actually build a fresh scanner for the console.
	 * 
	 */
	public MyScanner () {
		if (in == null) {
			in = new Scanner (System.in);
		} //Creates new scanner if none exist
	}
	
	/**
	 * Retrieve the one and only input scanner that we have.  The compiler balks a little
	 * because this is not a static method.  I could have done it as a static method, but
	 * this is a lazy implementation.  If no one needs an input Scanner, then we don't 
	 * build one.  As soon as the first client creates an instance of MyScanner, we 
	 * obligingly build one for them, store it for future use, and never build another
	 * Scanner instance but keep passing that old one out every time someone asks for a 
	 * scanner in getScanner.
	 * @return	The input scanner.
	 */
	public Scanner getScanner() {
		return MyScanner.in;
	}
}