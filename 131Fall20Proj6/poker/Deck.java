package poker;

public class Deck {

	private Card[] cards;

	/*
	 * Deck constructor that initializes 52 card objects from the first card ace
	 * of spades to the last card king diamonds
	 */
	public Deck() {
		cards = new Card[52];
		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 1; value <= 13; value++) {
				cards[index] = new Card(value, suit);
				index++;
			}
		}

	}

	// Copy constructor that initializes the parameter other to the array of
	// cards
	public Deck(Deck other) {
		cards = other.cards;
	}
	/*
	 * Gets the card at a particular position on the deck
	 * 
	 * @position the specified location of a card in the deck
	 */

	public Card getCardAt(int position) {
		int value = cards[position].getValue();
		int suit = cards[position].getSuit();
		Card cardAt = new Card(value, suit);
		return cardAt;
	}

	// Returns the number of cards in the deck
	public int getNumCards() {
		return cards.length;
	}

	/*
	 * Shuffle method rearranges the cards in an array of cards from the first
	 * card of the deck then
	 * 
	 * the first card of the second half of the deck
	 */
	public void shuffle() {
		Card[] even_shuffle = new Card[cards.length];
		for (int index = 0; index < cards.length; index++) {
			even_shuffle[index] = cards[index];
		}
		if (cards.length % 2 == 0) { // even
			for (int index = 0; index < cards.length / 2; index++) {
				cards[index * 2] = even_shuffle[index];
				cards[index * 2 + 1] = even_shuffle[even_shuffle.length / 2
						+ index];
			}
		} else {
			cards[cards.length / 2] = even_shuffle[cards.length / 2 + 1];
			for (int index = 0; index < cards.length / 2; index++) {
				cards[index * 2] = even_shuffle[index];
				cards[index * 2 + 1] = even_shuffle[even_shuffle.length / 2
						+ index + 1];
			}
			cards[cards.length - 1] = even_shuffle[even_shuffle.length / 2];
		}

	}

	/*
	 * Cut method divides a deck into two packets the top half and the bottom
	 * half when the cards are cut the position specified will become the first
	 * card in the index and the cards before it will be placed at the pack of
	 * the deck
	 * 
	 * @position this parameter returns the position of the card in the deck and
	 * cuts the cards before that specific location
	 */
	public void cut(int position) {
		Card[] newCards = new Card[cards.length];
		for (int index = 0; index < newCards.length; index++) {
			newCards[index] = cards[index];
		}
		for (int index = 0; index < position; index++) {
			cards[cards.length - position + index] = getCardAt(index);
		}
		for (int index = 0; index < cards.length - position; index++) {
			cards[index] = newCards[position + index];
		}
	}

	/*
	 * This method will remove the specified number of cards from the top of the
	 * deck and return them as an array. For example, if the parameter is 4,
	 * then the first four cards in the deck will be returned as an array of
	 * size 4. Important: The cards will be removed from the front of the
	 * "cards" array, not the back.
	 * 
	 * @Numcards is the amount of cards that are dealt in the array
	 */
	public Card[] deal(int numCards) {
		Card[] newCards = new Card[numCards];

		for (int index = 0; index < numCards; index++) {
			newCards[index] = cards[index];
		}
		Card[] smaller = new Card[cards.length - numCards];
		for (int index = 0; index < smaller.length; index++) {
			smaller[index] = cards[numCards + index];
		}
		cards = smaller;
		// Returns a new array of cards which is smaller than the original size
		return newCards;

	}
}
