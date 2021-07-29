package poker;

public class PokerHandEvaluator {
	/*
	 * A hand where two of your cards have the same value (e.g. you have
	 * "two fives", or maybe you have "two Aces").
	 *
	 * @Cards which is an array of five cards
	 */
	public static boolean hasPair(Card[] cards) {
		int pair = 0;

		for (int i = 1; i <= 4; i++) {
			if (cards[0].getValue() == cards[i].getValue()) {
				pair = pair + 1;
			}
		}
		for (int i = 2; i <= 4; i++) {
			if (cards[1].getValue() == cards[i].getValue()) {
				pair = pair + 1;
			}
		}
		for (int i = 3; i <= 4; i++) {
			if (cards[2].getValue() == cards[i].getValue()) {
				pair = pair + 1;
			}
		}
		for (int i = 4; i <= 4; i++) {
			if (cards[3].getValue() == cards[i].getValue()) {
				pair = pair + 1;
			}
		}
		// Returns true if there is a pair of cards that have the same value and
		// false otherwise
		if (pair == 1 || pair > 1) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * As the name implies, a hand is considered "Two Pair" if you can find two
	 * pairs of matching values. For example, if you are holding two eights and
	 * two Jacks, then your hand would be considered "Two Pair
	 *
	 * @cards which is an array of 5 cards used to determine whether there is a
	 * two pair of cards
	 */
	public static boolean hasTwoPair(Card[] cards) {

		int pair = 0;

		for (int deck = 1; deck <= 4; deck++) {
			if (cards[0].getValue() == cards[deck].getValue()) {
				pair = pair + 1;
			}
		}
		for (int deck = 2; deck <= 4; deck++) {
			if (cards[1].getValue() == cards[deck].getValue()) {
				pair = pair + 1;
			}
		}
		for (int deck = 3; deck <= 4; deck++) {
			if (cards[2].getValue() == cards[deck].getValue()) {
				pair = pair + 1;
			}
		}
		for (int deck = 4; deck <= 4; deck++) {
			if (cards[3].getValue() == cards[deck].getValue()) {
				pair = pair + 1;
			}
		}
		// returns true if there is a two pair of cards and false otherwise
		if (pair == 4 || pair == 2) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * The name says it all: If your hand has three cards with matching values,
	 * then it qualifies as "Three of a Kind". For example, if you are holding
	 * three Queens, then your hand could be considered "Three of a Kind".
	 *
	 * @cards which is an array of 5 cards used to determine a three of a kind
	 */
	public static boolean hasThreeOfAKind(Card[] cards) {
		int pair = 0;

		for (int row = 1; row <= 4; row++) {
			if (cards[0].getValue() == cards[row].getValue()) {
				pair = pair + 1;
			}
		}
		for (int row = 2; row <= 4; row++) {
			if (cards[1].getValue() == cards[row].getValue()) {
				pair = pair + 1;
			}
		}
		for (int row = 3; row <= 4; row++) {
			if (cards[2].getValue() == cards[row].getValue()) {
				pair = pair + 1;
			}
		}
		for (int row = 4; row <= 4; row++) {
			if (cards[3].getValue() == cards[row].getValue()) {
				pair = pair + 1;
			}
		}
		// returns true of there is a three of a kind and false otherwise
		if (pair >= 3) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean hasHighestNumbers(Card[] cards) {
		int count = 0;
		for (int row = 0; row < 5; row++) {
			int pairing = 0;
			for (int col = 0; col < 5; col++) {
				if (cards[row].getValue() != cards[col].getValue()
						&& row != col) {
					pairing++;
					if (pairing == 4) {
						if (cards[row].getValue() == 1
								|| cards[row].getValue() == 10
								|| cards[row].getValue() == 11
								|| cards[row].getValue() == 12
								|| cards[row].getValue() == 13) {
							count++;
							break;
						}

					}
				}

			}
		}
		return count == 5;
	}

	/*
	 * Five cards (not four) with values that are consecutive is called a
	 * "Straight". For example: 6, 7, 8, 9, 10. Keep in mind that the usual
	 * order of card values is: A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, but the
	 * ace can be used strangely both as a high and a low card
	 * 
	 * @cards which is an array of 5 cards used to determine a straight
	 */
	public static boolean hasStraight(Card[] cards) {

		int count = 0;
		int pairing = 0;
		if (PokerHandEvaluator.hasHighestNumbers(cards) == true) {
			return true;
		} else {
			for (int index = 0; index < 5; index++) {
				for (int col = 0; col < 5; col++) {
					if (cards[index].getValue() != cards[col].getValue()
							&& index != col) {
						pairing++;
					}

				}

			}
			if (pairing == 20) {
				for (int index = 0; index < 5; index++) {
					for (int cols = 0; cols < 5; cols++) {
						if (cards[index].getValue() + 1 == cards[cols]
								.getValue()) {
							count++;
						}

					}

				}

			}
			return count == 4;
		}
		// Returns true if the five cards are straight and false otherwise

	}

	/*
	 * flush method is to determine whether five cards have the same value of
	 * suit.
	 * 
	 * @cards which is an array of 5 cards used to determine a straight
	 */
	public static boolean hasFlush(Card[] cards) {
		int pair = 0;
		for (int row = 1; row <= 4; row++) {
			if (cards[0].getSuit() == cards[row].getSuit()) {
				pair++;
			}
		}
		// returns true if all the cards have the same suit
		if (pair >= 4) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * A "full house" is a hand where a pair of cards share the same value, and
	 * the other three cards share a second value. For example, if you are
	 * holding a pair of nines and three jacks, then you have a "full house".
	 * 
	 * 
	 * @cards which is an array of 5 cards used to determine a straight
	 */
	public static boolean hasFullHouse(Card[] cards) {
		int pair = 0;

		for (int row = 1; row <= 4; row++) {
			if (cards[0].getValue() == cards[row].getValue()) {
				pair = pair + 1;
			}
		}
		for (int row = 2; row <= 4; row++) {
			if (cards[1].getValue() == cards[row].getValue()) {
				pair = pair + 1;
			}
		}
		for (int row = 3; row <= 4; row++) {
			if (cards[2].getValue() == cards[row].getValue()) {
				pair = pair + 1;
			}
		}
		for (int row = 4; row <= 4; row++) {
			if (cards[3].getValue() == cards[row].getValue()) {
				pair = pair + 1;
			}
		}
		// Returns true if the five cards are a full house three of the same
		// cards and other 2 cards are different but have the same value
		// And false otherwise
		if (pair == 4) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Four of a kind method is a method that determines whether the five cards
	 * in the deck have the same value, if they have the same value this method
	 * returns true if not this method returns false
	 * 
	 * @cards which is an array of 5 cards used to determine whether 4 or more
	 * of the cards have the same values
	 */
	public static boolean hasFourOfAKind(Card[] cards) {
		int pair = 0;

		for (int row = 1; row <= 4; row++) {
			if (cards[0].getValue() == cards[row].getValue()) {
				pair = pair + 1;
			}
		}
		for (int row = 2; row <= 4; row++) {
			if (cards[1].getValue() == cards[row].getValue()) {
				pair = pair + 1;
			}
		}
		for (int row = 3; row <= 4; row++) {
			if (cards[2].getValue() == cards[row].getValue()) {
				pair = pair + 1;
			}
		}
		for (int row = 4; row <= 4; row++) {
			if (cards[3].getValue() == cards[row].getValue()) {
				pair = pair + 1;
			}
		}
		// returns true if there is a four of a kind and false otherwise
		if (pair >= 6) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * The "straight flush" is the most unusual (hence most valuable) rank. You
	 * hardly ever see them during games! To have a straight flush, you must
	 * hold 5 cards that qualify both as a straight and as a flush. In other
	 * words you must hold 5 cards with consecutive values and identical suits.
	 * 
	 * @cards an array of five cards used to determine whether there is a
	 * straight flush
	 */
	public static boolean hasStraightFlush(Card[] cards) {
		if (hasStraight(cards) && hasFlush(cards)) {
			// returns true if there is a straight flush and false otherwise
			return true;
		} else {
			return false;
		}
	}
}
