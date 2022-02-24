package cecs277LabDependencyInversion;

/**
 * This class is a copy of StringProcessorDependent but it replies on 
 * StringWriter and StringReader interfaces.
 * @author	Vy Nguyen, Nicki Huynh
 * @date	09/25/2019
 */
public class StringProcessor {
	/** The object that will do the reading for us */
	private final StringReader stringReader;
	/** The object that will do the writing for us */
	private final StringWriter stringWriter;
	
	/**
	 * The constructor replies on the new interfaces
	 * @param stringReader	The reader that we'll use.
	 * @param stringWriter	The writer that we'll use.
	 */
	public StringProcessor(StringReader stringReader, StringWriter stringWriter) {
		this.stringReader = stringReader;
		this.stringWriter = stringWriter;
	}
	
	/**
	 * Take a record from the input, and immediately write it to the output.
	 */
	public void printString() {
		stringWriter.write(stringReader.getValue());
	}

}