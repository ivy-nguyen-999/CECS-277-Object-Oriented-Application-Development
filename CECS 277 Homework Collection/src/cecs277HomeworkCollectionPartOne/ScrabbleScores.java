package cecs277HomeworkCollectionPartOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ScrabbleScores {
	
	public static void main(String[] args){
		
		// create a Map that has the letter of the alphabet as the key
		// and the score that letter gets in Scrabble as the value
		Map<Character, Integer> letters = new TreeMap<Character, Integer>();
		
		// create a second map to keep the score of the entire word
		// using HashMap because we don't have to follow alphabetical order
		Map<String, Integer> outputMap = new TreeMap<String, Integer>();
		
		// read the ScrabblePoints.txt file
		// creates File instance to reference text file in Java
		// creates Scanner instance to read File in java
		try (Scanner scrabble = new Scanner(new File ("ScrabblePoints.txt"))){
			while (scrabble.hasNextLine()) {
				// read the next line and split it into an array
				String[] next = scrabble.nextLine().split(" ");
				// the first field is the score for all of the letters in that record
				int point = Integer.parseInt(next[0]);
				// the letters that follow each gets that score
				for (int index = 1; index  < next.length; index++) {
					// add to the map in alphabetical order
					letters.put(next[index].toLowerCase().charAt(0), point);
				}
			}
			
			// read the records in Q words.txt file
			try (Scanner qWords = new Scanner(new File("Q words.txt"))){
				
				while (qWords.hasNextLine()) {
					// read the next line
					String next = qWords.nextLine();
					// sum of that word
					int sum = 0;
					for (int index = 0; index < next.length(); index++) {
						sum += letters.get(next.charAt(index));
					}
					// add the element to the map
					outputMap.put(next, sum);
				}
				
				// after reading the record in the file, print out
				for (String key : outputMap.keySet()) {
					System.out.println("Score for word: "+ key + " is: " + outputMap.get(key));
				}
				System.out.println("Completed satisfactorily.");
				
			} catch (FileNotFoundException FNFE) {
				System.out.println("Can't find the Q words.txt file!");
			}
		} catch (FileNotFoundException FNFE) {
			System.out.println("Can't find the ScrabblePoints.txt file!");
		}
	}
	
}
