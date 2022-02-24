package cecs277LabDependencyInversion;
/**
 * StringWriter that implements StringWriter interfaces. 
 * @author	Vy Nguyen, Nicki Huynh
 * @date	09/25/2019
 */
public class StringWriterImp implements StringWriter {
	/**
	 * Prints out the given String value
	 * @param value the given String value
	 */
	@Override
	public void write(String value) {
		System.out.println(value);
	}

}