package cecs277DemoVisitorPattern;

/**
 * The RentalVisitor Implementation could have some instance variables of its own that it
 * uses, for instance, to keep a running total, or do some other sort of statistical
 * calculation as it goes.  That works well if the client is disciplined and gets a new
 * visitor instance at the start of the "run" through a given collection, and then harvests
 * the accumulated data (presumably through an appropriate getter) at the end of the run.
 * @author	Vy Nguyen, Nicki Huynh
 * @date	12/02/2019
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RentalVisitorImpl implements RentalVisitor {
	/**
	 * the total publication year/release year of all the elements
	 * that the visitor has visited.
	 */
	private double totalYear;
	/** keeps track of number of elements that visitor has visited. */
	private double numOfElement;
	/** maps from MovieGenre to an integer. */
	private Map<MovieGenre, Integer> dvdList;
	/** maps from GameGenre to an integer. */
	private Map<GameGenre, Integer> gameList;
	
	/**
	 * Default constructor
	 */
	public RentalVisitorImpl() {
		dvdList = new HashMap<>();
		gameList = new HashMap<>();
		totalYear = 0;
		numOfElement = 0;
	}
	
	@Override
	public void visit(DVD dvd) {
		this.totalYear += dvd.getYearReleased();
		this.numOfElement += 1;
		
		// add the DVD to the list
		if (!this.dvdList.containsKey(dvd.getGenre())) {
			this.dvdList.put(dvd.getGenre(), 1);
		} // if the map doesn't have this item
		else {
			int newValue = this.dvdList.get(dvd.getGenre()) + 1;
			this.dvdList.replace(dvd.getGenre(), newValue);
		} // if the map has this item
	}
	
	@Override
	public void visit(Game game) {
		this.totalYear += game.getYearPublished();
		this.numOfElement += 1;
		
		// add the game to the list
		if (!this.gameList.containsKey(game.getGenre())) {
			this.gameList.put(game.getGenre(), 1);
		} // if the map doesn't have this item
		else {
			int newValue = this.gameList.get(game.getGenre()) + 1;
			this.gameList.replace(game.getGenre(), newValue);
		} // if the map has this item
	}
	
	@Override
	public double averageYear() {
		return totalYear / numOfElement;
	}
	
	@Override
	public ArrayList<String> counts() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Counts for the Movies");
		for (MovieGenre genre : dvdList.keySet()) {
			list.add("Genre: " + genre + " came up: " + dvdList.get(genre));
		}
		list.add("Counts for the Games");
		for (GameGenre genre : gameList.keySet()) {
			list.add("Genre: " + genre + " came up: " + gameList.get(genre));
		}
		return list;
	}
}