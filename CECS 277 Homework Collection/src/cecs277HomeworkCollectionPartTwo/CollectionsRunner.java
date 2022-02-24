package cecs277HomeworkCollectionPartTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CollectionsRunner {

	public static void main(String[] args) {
		// create two types of maps
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>();
		Map<String, Integer> unsortedMap = new HashMap<String, Integer>();
		
		// tree map:
		// record the time before reading and hashing the novel
		Instant tFirst = Instant.now();
		int tSum = readNovel(sortedMap);
		// record the time after reading and hashing the novel
		Instant tSecond = Instant.now();
		// Calculate the time between before and after reading and hashing the novel
		long tDuration = Duration.between(tFirst, tSecond).toNanos();
		System.out.println("Tree map");
		System.out.println("Total words in War and Peace: " + tSum);
		System.out.print("Total time (sec) to read and hash War and Peace: ");
		System.out.printf("%.3f", (tDuration * Math.pow(10, -9)));
		System.out.println(" seconds");
		printResult(sortedMap);
		
		System.out.println();
		
		// hash map:
		// record the time before reading and hashing the novel
		Instant hFirst = Instant.now();
		int hSum = readNovel(unsortedMap);
		// record the time after reading and hashing the novel
		Instant hSecond = Instant.now();
		// Calculate the time between before and after reading and hashing the novel
		long hDuration = Duration.between(hFirst, hSecond).toNanos();
		System.out.println("Hash map");
		System.out.println("Total words in War and Peace: " + hSum);
		System.out.print("Total time (sec) to read and hash War and Peace: ");
		System.out.printf("%.3f", (hDuration * Math.pow(10, -9)));
		System.out.println(" seconds");
		printResult(unsortedMap);
		
		System.out.println("Completed satisfactorily.");
	}
	
	public static int readNovel(Map<String, Integer> map) {
		int sum = 0; // keeps track of how many words that are in the novel
		try (Scanner novel = new Scanner(new File("War and Peace.txt"))) {
			while (novel.hasNext()) {
				// remove anything that is not a character
				// and run everything to lower case
				String word = novel.next().toLowerCase().replaceAll("[^a-z]", "");
				
				// get rid of all the white space
				// that's why we got 647 words less than what he got
				if (!word.equals("")) {
					sum += 1; // increments the number of words
					// if the key is not in the map yet
					if (!map.containsKey(word)) {
						// create a new entry in your Map with that word as the key,
						// and a value of 1
						map.put(word, 1);
					}
					// otherwise
					else {
						// retrieve and update the value
						int newValue = map.get(word) + 1;
						// use replace function to update the count for that word
						map.replace(word, newValue);	
					}
				}
			}
		} catch (FileNotFoundException FNFE) {
			System.out.println("Can't find the novel!");
		}
		return sum; // return the number of words
	}
	
	public static void printResult(Map<String, Integer> map) {
		// loop through each word and print out the result
		for (String key : map.keySet()) {
			System.out.println(key + " occurred: " + map.get(key) + " times");
		}
	}
}
