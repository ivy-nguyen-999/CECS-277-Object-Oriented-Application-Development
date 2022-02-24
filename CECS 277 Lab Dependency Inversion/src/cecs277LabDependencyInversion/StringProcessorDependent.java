package cecs277LabDependencyInversion;

/**
 * This class represents a dependency of the StringProcessorDependent upon lower level 
 * classes.  That dependency is injected in the constructor.  When the constructor 
 * runs, we have a specific class instance that we become dependent upon.  We could 
 * have other instances of that same class composed into this class at run time, but
 * the BEHAVIOR of those instances cannot change dynamically.
 * @author	Vy Nguyen, Nicki Huynh
 * @date	09/25/2019
 */
public class StringProcessorDependent {
	/** The object that will do the reading for us */
	private final StringReaderImp stringReader;
	/** The object that will do the writing for us */
	private final StringWriterImp stringWriter;
	
	/**
	 * Dependency injecting constructor.
	 * @param stringReader	The reader that we'll use.
	 * @param stringWriter	The writer that we'll use.
	 */
	public StringProcessorDependent(StringReaderImp stringReader, StringWriterImp stringWriter) {
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