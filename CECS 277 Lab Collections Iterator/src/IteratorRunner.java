import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Learn how to use several of the Java Collections classes with each other.
 * @author Vy Nguyen, Nicki Huynh
 * @date 10/28/2019
 */
public class IteratorRunner {

	public static void main(String[] args) throws FileNotFoundException {
		// a Scanner object to read the file
		Scanner input = new Scanner(new File("Pride and Prejudice.txt"));
		
		/* a map object that maps from a String to an Integer in alphabetical order
		 * the String is the word that we are counting
		 * the Integer value is the number of times that we have seen the String
		 */
		Map<String, Integer> sortedMap = new TreeMap <String, Integer>();
		
		while (input.hasNext()) {
			// remove anything that is not a character
			// and run everything to lower case
			String word = input.next().toLowerCase().replaceAll("[^a-z]", "");
			
			// if word is not empty
			if (!word.equals("")) {
				// if the key is not in the map yet
				if (!sortedMap.containsKey(word)) {
					// create a new entry in your Map with that word as the key,
					// and a value of 1
					sortedMap.put(word, 1);
				}
				// otherwise
				else {
					// retrieve and update the value
					int newValue = sortedMap.get(word) + 1;
					// use replace function to update the count for that word
					sortedMap.replace(word, newValue);
					
				}
			}
		}
		
		// report out:
		// use the Map keyset() member method to get a list of all of the words
		Set<String> theKey = sortedMap.keySet();
		// create an iterator on that set 
		Iterator<String> iterator = theKey.iterator();
		// using the Iterator hasNext and Next, print out each word that you
		// have counted, and the count
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next + " : " + sortedMap.get(next));
		}
	}

}
