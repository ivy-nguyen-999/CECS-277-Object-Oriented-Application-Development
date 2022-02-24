package cecs277LabDependencyInversion;

import java.util.Scanner;

/**
 * One of perhaps many StringReader interface implementations that we could build. 
 * @author	Vy Nguyen, Nicki Huynh
 * @date	09/25/2019
 */
public class StringReaderImp implements StringReader {

	//For this simple example, we build our own Scanner object to read in lines of text.
	//This creates a dependency of StringReaderImp on the System.in and Scanner classes,
	//and we could have had them passed in as arguments to the constructor to reduce the 
	//dependency.
	Scanner in;
	public StringReaderImp () {
		//squirrel away our input scanner for later.  Ideally, we would use a
		//factory here to make sure that we only have one System.in scanner
		//at a time since multiple System.in Scanners never seems to work right.
		MyScanner temp = new MyScanner();
		this.in = temp.getScanner();
	}
	
	/**
	 * Gets input from users and put in the next empty line
	 * @return the String input
	 */
	@Override
	public String getValue() {
		String line;
		line = this.in.nextLine();
		return line;
	}
	
	/**
	 * Returns true if it has next line, false if it doesn't have next line
	 */
	@Override
	public boolean hasNext() {
		return this.in.hasNextLine();
	}
}