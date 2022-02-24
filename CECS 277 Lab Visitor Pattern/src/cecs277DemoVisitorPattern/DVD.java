package cecs277DemoVisitorPattern;
/**
 * A movie that we rent.
 * @author	Vy Nguyen, Nicki Huynh
 * @date	12/02/2019
 */
public class DVD implements ItemElement{
	/** The name of the movie. */
	private String name;
	/** The release year of the movie. */
	private int yearReleased;
	/** The genre of the movie. */
	private MovieGenre genre;
	
	/**
	 * Default constructor.
	 */
	public DVD() {
		this.name = "";
		this.yearReleased = 0;
		this.genre = MovieGenre.ACTION;
	}
	
	/**
	 * Constructor takes in the name, released year and the movie genre.
	 * @param name The name of the movie.
	 * @param yearReleased The release year of the movie.
	 * @param genre The genre of the movie
	 */
	public DVD (String name, int yearReleased, MovieGenre genre) {
		this.name = name;
		this.yearReleased = yearReleased;
		this.genre = genre;
	}
	
	/**
	 * Return the name of the DVD title.
	 * @return	Title of the dvd.
	 */
	public String getName() {return this.name; }
	
	/**
	 * Return the year released.
	 * @return	Year that the DVD was released.
	 */
	public int getYearReleased () {return this.yearReleased; }

	/**
	 * Return the genre for this movie.
	 * @return	The genre.
	 */
	public MovieGenre getGenre() {return this.genre; }
	
	@Override
	public String toString () {
		return "DVD - Name: " + this.getName() + " Released: " + this.getYearReleased() +
				" Genre: " + this.getGenre();
	}

	@Override
	public void accept(RentalVisitor visitor) {
		visitor.visit(this);
	}
	
	
}