/**
 * A class that helps to get experience processing ASCII data,
 * handling errors in the input, working with home-grown exception classes.
 * Lab: I/O Exception
 * @author Vy Nguyen, Nicki Huynh
 * @date 10/16/2019
 */

import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class IOExceptionRunner {
	/**
	 * Read the next two double precision numbers from the scanner that we get,
	 * and make them into a Point instance.  Check to see that we can get both
	 * the x and the y coordinates from the scanner.  Throw a IllegalArgumentException
	 * if you cannot get two double precision numbers out of the scanner.
	 * @param	line	The scanner that has the current line of input.  The caller
	 * 					reads in a line of text from the input file, then creates a
	 * 					scanner on that line of text, all by itself.  Not the whole file.
	 * 					Then passes that scanner to this routine to get two double
	 * 					precision values.
	 * @return			A new instance of Point.
	 */
	public static Point getNextPoint (Scanner line, int i) {
		Point newPoint = null; // initializes a new Point.
		if (line.hasNextDouble()) {
			double x = line.nextDouble();
			if (line.hasNextDouble()){
				double y = line.nextDouble();
				newPoint = new Point(x,y);
				return newPoint;
			}// if line has two double precision numbers to make a Point
			else {
				throw new IllegalArgumentException();
			}// throw if there is only one precision number
		}// check if line has precision numbers
		else {
			throw new IllegalArgumentException();
		}// throw if there is no precision number
	}// return a Point if there are two precision numbers
	// else, throw
	
	/**
	 * Find the area of the triangle, given the vertices that the user passes in.
	 * @param vertices	An array of three Points that are the corners of the triangle.
	 * 					The order is unimportant.  Note that this does not check to
	 * 					make sure that there are exactly three.
	 * @return			The area of the triangle, using Heron's formula.
	 */
	public static double area (Point[] vertices) {
		double side1, side2, side3;
		// Find the length of each of the sides of the triangle
		side1 = vertices[0].distance(vertices[1]);
		side2 = vertices[1].distance(vertices[2]);
		side3 = vertices[2].distance(vertices[0]);
		// s is an intermediate value needed by Heron's formula
		double s =	(side1 + side2 + side3)/2.0;
		return Math.sqrt(s*(s - side1) * (s - side2) * (s - side3));
	} // calculate the area if we have all the vertices

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser();
		Scanner in = null;// Input file
		boolean foundInFile = false;// Flag that we don't have an input file.
		do {
			// setDialogTitle changes the title
			chooser.setDialogTitle("Please select an input file");
			// showOpenDialog opens the window
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				try {
					File selectedFile = chooser.getSelectedFile();
					in = new Scanner(selectedFile);
					foundInFile = true;
				} // If the file exists, inputs data into it
				// If the file does not exist
				catch (FileNotFoundException e) {
					System.out.println("Can't open the file!");
				} //Will send out an exception if file isn't found or cannot open
			} // Checks if chooser gets approval to certain file choice
		} while (!foundInFile);
		boolean foundOutFile = false;//Flag that we don't have an output file
		PrintWriter out = null;//Output file
		do {
			// setDialogTitle changes the title
			chooser.setDialogTitle("Please select an output file");
			// showOpenDialog opens the window
			if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				String outName = chooser.getSelectedFile().getAbsolutePath();
				try {
					out = new PrintWriter(outName);
					foundOutFile = true;
				} // If the file exists, inputs data into it
				// If the file does not exist
				catch (FileNotFoundException e) {
					System.out.println("Can't open the file!");
				}//Will send out an exception if file isn't found or cannot open
			}// Checks if chooser gets approval to certain file choice
		} while (!foundOutFile);
		
		String line;// The current line of the ASCII text file
		Point[] vertices = new Point [3];// The array of triangle vertices
		while (in.hasNextLine()) {
			line = in.nextLine();
			System.out.println("Line: " + line);
			Scanner thisLine = new Scanner (line);
			boolean success = false;
			for (int i = 0; i < 3; i++) {
				try {
					// Use getNextPoint to read the next point from the thisLine scanner.
					vertices[i] = getNextPoint(thisLine, i);
					// Once you have all three points read in, set success to be true.
					if (i == 2) {
						success = true;
					} //If triangle has all 3 points, successfully makes triangle
				} // If there is enough inputs to create 3 points
				catch (IllegalArgumentException e) {
					System.out.println("Failed to create a triangle!");
				} //If there is not enough inputs to create 3 points in triangle
			} // End of reading in the vertices
			if (success) { // Output the area to the output file.
				out.println("Next area: " + area(vertices));
			} //If the triangle was successfully made, will find its area
		} //As long as file as next line, loop continues
		in.close();
		out.close();
		System.out.println("Completed satisfactorily.");
	}

}
