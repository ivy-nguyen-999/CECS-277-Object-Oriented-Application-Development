import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
	
	// mDeck array list that will contain cards
	private ArrayList<Card> mDeck = new ArrayList<Card>();
	// mNumOfCards to keep track number of card in a list
	private int mNumOfCards;
	
	/**
	 * Returns the list that contains all the cards.
	 */
	public ArrayList<Card> deck() {
		return mDeck;
	}
	
	/**
	 * Returns the number of cards in the list.
	 */
	public int cardsLeft() {
		return mNumOfCards;
	}
	
	/**
	 * Adds card to the list.
	 * @param card the given card to add to the list of cards.
	 */
	public void add(Card card) {
		mDeck.add(card);
		mNumOfCards += 1;
	}
	
	/**
	 * Gets a card from the list.
	 * @param index of the card.
	 * @return the card with given index.
	 */
	public Card getCard(int index) {
		return mDeck.get(index);
	}

	
	/**
	 * Shuffles the list of cards.
	 */
	public void shuffle() {
		Collections.shuffle(mDeck);
	}
	
	/**
	 * Removes a card from deck and hand it to deckB.
	 * @param deckB the deck that will be handed the card to.
	 * @return the card that gets removed from the original list.
	 */
	public Card hand(DeckOfCards deckB) {
		Card temp = getCard(0);
		mDeck.remove(0);
		mNumOfCards -= 1;
		deckB.add(temp);
		return temp;
	}
	
	/**
	 * Moves all the card from a deck to another deck.
	 * @param deckB the deck that receives all the cards.
	 */
	public void handAll(DeckOfCards deckB) {
		while (mNumOfCards > 0) {
			hand(deckB);
		}
	}
}
