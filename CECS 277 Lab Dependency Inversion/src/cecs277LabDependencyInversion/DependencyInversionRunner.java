package cecs277LabDependencyInversion;

/**
 * Loosely borrowed from: https://www.baeldung.com/java-dependency-inversion-principle.
 * @author	Vy Nguyen, Nicki Huynh
 * @date	09/25/2019
 */

public class DependencyInversionRunner {

	public static void main(String[] args) {
		/* get an instance of the reader and writer interfaces.  The sr and sw
		 * variables only "know" about the methods that those respective interfaces
		 * include.  Any other methods that the concrete implementations include
		 * will not be available.
		 */
		StringReader sr = new StringReaderImp();
		StringWriter sw = new StringWriterImp();
		StringProcessor SPD = new StringProcessor(sr, sw);
		while (sr.hasNext()) {
			SPD.printString();
		} //While there are still lines, it will continue to print
		sw.write("Completed successfully");
	}
}
