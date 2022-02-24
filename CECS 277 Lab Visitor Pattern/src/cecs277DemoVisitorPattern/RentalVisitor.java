package cecs277DemoVisitorPattern;

import java.util.ArrayList;

/**
 * The key to this interface is that it has a separate method for each type of ItemElement that we 
 * will deal with.  If we add a new ItemElement type, we have to update this interface, and then any
 * implementations of this interface have to be updated to have a new method for visiting the new
 * type.  The way that we calculate the rate and the duration of the rent varies from one type of 
 * ItemElement to the next, but we do calculate the rate and the duration for each.
 * @author	Vy Nguyen, Nicki Huynh
 * @date	12/02/2019
 */
public interface RentalVisitor {
	/** 
	 * Visit a DVD and save the rental rate and the duration of the rental.
	 * @param	dvd		The DVD that you want to visit.
	 */
	void visit (DVD dvd);
	
	/**
	 * Visit a Game and save the rate and duration of the rental.
	 * @param	game	The game to get the rate and rent duration for.
	 */
	void visit (Game game);
	
	/**
	 * Returns the average publication year/releases year of all the elements
	 * that the visitor has visited.
	 * @return The average year
	 */
	double averageYear();
	
	/**
	 * Returns an ArrayList that essentially a listing of the frequencies
	 * of the genres of film and game.
	 * @return a listing of frequencies of the genres of film and game.
	 */
	ArrayList<String> counts();
}