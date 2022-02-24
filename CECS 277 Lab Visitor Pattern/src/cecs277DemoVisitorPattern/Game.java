package cecs277DemoVisitorPattern;

/**
 * A game that we rent.
 * @author	Vy Nguyen, Nicki Huynh
 * @date	12/02/2019
 */
public class Game implements ItemElement{
	/** The rating of the movie. */
	private GameRating rating;
	/** The genre of the movie. */
	private GameGenre genre;
	/** The published year of the movie.*/
	private int yearPublished;
	/** The name of the movie. */
	private String name;
	
	/**
	 * Default constructor.
	 */
	public Game() {
		this.rating = GameRating.RATING_PENDING;
		this.genre = GameGenre.HORROR;
		this.yearPublished = 0;
		this.name = "";
	}
	
	/**
	 * The constructor of game, initializes the rating,
	 * genre, published year, and name.
	 * @param rating The rating of the movie.
	 * @param genre The genre of the movie.
	 * @param yearPublished The published year of the movie.
	 * @param name The name of the movie.
	 */
	public Game (GameRating rating, GameGenre genre, int yearPublished, String name) {
		this.rating = rating;
		this.genre = genre;
		this.yearPublished = yearPublished;
		this.name = name;
	}
	
	/**
	 * Returns the rating of the game.
	 * @return the rating.
	 */
	public GameRating getRating() {
		return rating;
	}
	
	/**
	 * Returns the genre of the game.
	 * @return the genre.
	 */
	public GameGenre getGenre() {
		return genre;
	}
	
	/**
	 * Returns the published year of the game.
	 * @return the published year.
	 */
	public int getYearPublished() {
		return yearPublished;
	}
	
	/**
	 * Returns the name of the game.
	 * @return the name.
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public void accept(RentalVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String toString () {
		return "Game - " + this.name +" Publication year: " + this.getYearPublished() +
				" Rating: " + this.getRating() + " Genre: " + this.getGenre();
	}
}