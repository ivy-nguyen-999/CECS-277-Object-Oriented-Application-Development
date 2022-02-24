package cecs277LabDependencyInversion;

public class DependencyInversionDependentRunner {
	/**
	 * Loosely borrowed from: https://www.baeldung.com/java-dependency-inversion-principle.
	 * @author	Vy Nguyen, Nicki Huynh
	 * @date	09/25/2019
	 */
	public static void main(String[] args) {
		//get an instance of the reader and writer interfaces.  The sr and sw
		//variables only "know" about the methods that those respective interfaces
		//include.  Any other methods that the concrete implementations include
		//will not be available.
		StringReaderImp sr = new StringReaderImp ();
		StringWriterImp sw = new StringWriterImp ();
		StringProcessorDependent SPD = new StringProcessorDependent (sr, sw);
		while (sr.hasNext()) {
			SPD.printString();
		}
		sw.write("Completed successfully");
	}
}
