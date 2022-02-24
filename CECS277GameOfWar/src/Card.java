
public class Card {
	
	// RANK instance variable that contains all the ranks of cards
	private final String[] RANK = {"2", "3", "4", "5", "6", "7", "8",
			"9", "10", "Jack", "Queen", "King", "Ace"};
	// SUIT instance variable that contains all the suits of cards
	private final String[] SUIT = {"Hearts", "Diamonds", "Clubs",
			"Spaces"};
	// mCard an array that has 2 elements, its first element is
	// its rank and its second element is its suit
	private int[] mCard = new int[2];
	
	/**
	 * Constructor assigns the card a rank and a suit.
	 * @param rank the given rank for the card
	 * @param suit the given suit for the card
	 */
	public Card(int rank, int suit) {
		mCard[0] = rank;
		mCard[1] = suit;
	}
	
	/**
	 * Returns the index of a rank.
	 */
	public int getRankValue() {
		return mCard[0];
	}
	
	/**
	 * Returns the index of a suit.
	 */
	public int getSuitValue() {
		return mCard[1];
	}
	
	/**
	 * Returns a single string that combines rank and suit together.
	 */
	public String displayCard() {
		return (RANK[mCard[0]] + " of " + SUIT[mCard[1]]);
	}
	
	/**
	 * Compares the rank value of two cards.
	 * @param cardB the card that to compare to
	 * @return -1 if cardB has greater value, 0 if they have the
	 * same rank, and 1 if cardB has smaller value
	 */
	public int toCompare(Card cardB) {
		if (mCard[0] < cardB.getRankValue()) {
			return -1;
		}
		else if (mCard[0] > cardB.getRankValue()) {
			return 1;
		}
		return 0;
	}
}
