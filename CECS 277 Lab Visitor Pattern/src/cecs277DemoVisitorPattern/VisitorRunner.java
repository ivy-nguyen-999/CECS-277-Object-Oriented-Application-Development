package cecs277DemoVisitorPattern;
/**
 * Build on the Visitor example in lecture and change it to a different sort of iterator
 * @author Vy Nguyen, Nicki Huynh
 * @date 12/02/2019
 */
public class VisitorRunner {

	public static void main(String[] args) {
		ItemElement [] items = {
				new DVD ("Jurasic Park", 1993, MovieGenre.ADVENTURE),
				new Game(GameRating.MATURE, GameGenre.ROAD_RAGE, 2005, "Fast and Furiously"),
				new DVD("Indiana Jones and the Last Crusade", 1989, MovieGenre.ADVENTURE),
				new DVD("The Goonies", 1985, MovieGenre.ADVENTURE),
				new Game(GameRating.TEEN, GameGenre.SCIENCE_FICTION, 2012, "Star Wars 1st Class"),
				new Game(GameRating.RATING_PENDING, GameGenre.SCIENCE_FICTION, 2019, "They Came From Space")};
		
		
		RentalVisitor visitor = new RentalVisitorImpl();
		for (ItemElement element: items) {
			System.out.println (element);
			element.accept(visitor);
		} // print out all items that we rent
		
		System.out.println("Now for the statistics");
		System.out.println("Average year published was: " + visitor.averageYear());
		for (String line : visitor.counts()) {
			System.out.println(line);
		} // print out the counts
		
		System.out.println("Completed satisfactorily.");
		
	}

}