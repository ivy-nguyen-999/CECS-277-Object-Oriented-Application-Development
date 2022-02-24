
public class GameOfWar {
	
	public static void main(String[] args) {
		// Creates a deck of cards that has 52 cards
		DeckOfCards originalDeck = new DeckOfCards();
		
		Card temp;
		// There are 4 suits of cards
		for (int suit = 0; suit < 4; suit++) {
			// For each suit, there are 13 cards with different ranks
			for (int rank = 0; rank < 13; rank++) {
				temp = new Card(rank, suit);
				originalDeck.add(temp);
			}
		}
		// Shuffles the deck of cards
		originalDeck.shuffle();
		
		// Creates a deck for each player
		DeckOfCards playerOne = new DeckOfCards();
		DeckOfCards playerTwo = new DeckOfCards();
		
		// Hands 26 cards to each player
		while (originalDeck.cardsLeft() > 0) {
			originalDeck.hand(playerOne);
			originalDeck.hand(playerTwo);
		}
		game(originalDeck, playerOne, playerTwo);
	}
	
	public static boolean enterWar(DeckOfCards deck, DeckOfCards one, 
			DeckOfCards two, int winner, Card cardOne, Card cardTwo) {
		
		if (one.cardsLeft() > 3 && two.cardsLeft() > 3) {
			System.out.println("war");
			
			// both players play three additional cards face down
			one.hand(deck);
			System.out.println("war card for player 1 Card is xx");
			two.hand(deck);
			System.out.println("war card for player 2 Card is xx");
			one.hand(deck);
			System.out.println("war card for player 1 Card is xx");
			two.hand(deck);
			System.out.println("war card for player 2 Card is xx");
			one.hand(deck);
			System.out.println("war card for player 1 Card is xx");
			two.hand(deck);
			System.out.println("war card for player 2 Card is xx");
			
			// both players play one card face up
			cardOne = one.hand(deck);
			System.out.println("war card for player 1 Card is " +
					cardOne.displayCard());
			cardTwo = two.hand(deck);
			System.out.println("war card for player 2 Card is " +
					cardTwo.displayCard());
			winner = cardOne.toCompare(cardTwo);
			
			// Compare to see who win the war round
			if (winner != 0) {
				if (winner == 1) {
					System.out.println("Player 1 wins the war round");
					deck.handAll(one);
				}
				else {
					System.out.println("Player 2 wins the war round");
					deck.handAll(two);
				}
			}
			// If they have to enter the war again, use recursion
			else {
					enterWar(deck, one, two, winner, cardOne, cardTwo);
			}
			return true;
		}
		return false;
	}
	
	public static void game(DeckOfCards deck, DeckOfCards one, 
			DeckOfCards two) {
		
		Card cardOne, cardTwo;
		int winner;
		boolean enoughCard = true;
		
		// Enter the battle if both player have enough cards to play
		while (one.cardsLeft() > 0 && two.cardsLeft() > 0 && enoughCard) {
			cardOne = one.hand(deck);
			System.out.println("player 1 plays Card is " +
					cardOne.displayCard());
			cardTwo = two.hand(deck);
			System.out.println("player 2 plays Card is " +
					cardTwo.displayCard());
			winner = cardOne.toCompare(cardTwo);
			// if their cards do not equal
			if (winner != 0) {
				if (winner == 1) {
					System.out.println("Player 1 wins the round");
					deck.handAll(one);
				}
				else {
					System.out.println("Player 2 wins the round");
					deck.handAll(two);
				}
			}
			else {
				enoughCard = enterWar(deck, one, two, winner, cardOne, cardTwo);
			}
		}
		
		if (one.cardsLeft() > two.cardsLeft()) {
			System.out.println("game over");
			System.out.println("player 1 wins the game");
		}
		else {
			System.out.println("game over");
			System.out.println("player 2 wins the game");
		}
	}
	
}
