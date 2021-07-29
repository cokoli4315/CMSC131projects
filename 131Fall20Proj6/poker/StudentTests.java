package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {

	/*
	 * Use the @Test annotation for JUnit 4 [This is just an example, please
	 * erase it and write some real tests.]
	 */
	@Test
	public void test() {

	}

	@Test
	public void testBasicDesk() {
		Card Clubs = new Card(2, 1);
		Card Spades = new Card(11, 0);
		Deck x = new Deck();

		assertEquals(52, x.getNumCards());
		assertEquals("2 of h", Clubs.toString());
		assertEquals("J of s", Spades.toString());

	}

	@Test
	public void testDeckCopyConstructer() {
		Card clubs = new Card(2, 1);
		Card jack = new Card(11, 0);
		Deck x = new Deck();
		Deck y = new Deck(x);
		assertEquals("2 of h", clubs.toString());
		assertEquals("J of s", jack.toString());
		assertEquals(x.getNumCards(), y.getNumCards());

	}

	@Test
	public void testGetCardAt() {
		Deck x = new Deck();
		assertEquals("2 of h", x.getCardAt(14).toString());
		assertEquals("J of s", x.getCardAt(10).toString());
	}

	@Test
	public void testGetNumCards() {
		Deck totalCards = new Deck();
		assertEquals(52, totalCards.getNumCards());

	}

	@Test
	public void shuffe() {

	}

	@Test
	public void hasPair() {
		Card clubs = new Card(2, 1);
		Card clubs1 = new Card(2, 0);
		Card clubs2 = new Card(2, 3);
		Card clubs3 = new Card(2, 2);
		Card clubs4 = new Card(3, 2);
		Card clubs5 = new Card(4, 2);
		clubs.getValue();
		Card[] cards = new Card[5];
		cards[0] = new Card(2, 1);
		cards[1] = new Card(4, 1);
		cards[2] = new Card(4, 1);
		cards[3] = new Card(2, 1);
		cards[4] = new Card(2, 1);
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

		assertTrue(clubs.getValue() == clubs1.getValue());
		assertEquals(true, PokerHandEvaluator.hasTwoPair(cards));

	}

	@Test
	public void hasFlush() {
		Card[] cards = new Card[5];
		cards[0] = new Card(2, 1);
		cards[1] = new Card(3, 1);
		cards[2] = new Card(4, 1);
		cards[3] = new Card(5, 1);
		cards[4] = new Card(6, 1);

		int pair = 0;
		for (int i = 1; i <= 4; i++) {
			if (cards[0].getSuit() == cards[i].getSuit()) {
				pair++;
			}
		}
		assertEquals(4, pair);
		assertEquals(true, PokerHandEvaluator.hasStraightFlush(cards));

	}

	@Test
	public void hasThreeofAKind() {
		Card[] cards = new Card[5];
		cards[0] = new Card(5, 2);
		cards[1] = new Card(4, 2);
		cards[2] = new Card(3, 2);
		cards[3] = new Card(1, 2);
		cards[4] = new Card(2, 2);

	}

	@Test
	public void hasStraight() {
		Card[] cards = new Card[5];
		cards[0] = new Card(13, 2);
		cards[1] = new Card(10, 2);
		cards[2] = new Card(11, 2);
		cards[3] = new Card(12, 2);
		cards[4] = new Card(1, 2);
		int count = 0;
		int y = 0;
		for (int index = 0; index < 5; index++) {
			int x = 0;

			for (int j = 0; j < 5; j++) {
				if (cards[index].getValue() + 1 == cards[j].getValue()
						&& cards[index].getValue() != y
						&& cards[0].getSuit() == cards[index].getSuit()&&index!=j) {
					x++;
					if (x == 1) {
						count++;
						y = cards[index].getValue();
						break;
					}

				}
			}
		}
		System.out.println(count);

	}

	@Test
	public void hasFullHouse() {
		Card[] cards = new Card[5];
		cards[0] = new Card(5, 2);
		cards[1] = new Card(4, 2);
		cards[2] = new Card(5, 2);
		cards[3] = new Card(4, 2);
		cards[4] = new Card(4, 2);
		int pair = 0;

		for (int i = 0; i <= 4; i++) {
			if (cards[0].getValue() == cards[1].getValue()
					&& cards[2].getValue() == cards[i].getValue() && i != 0
					&& i != 1) {
				pair = pair + 1;
			}
		}
		for (int i = 0; i <= 4; i++) {
			if (cards[1].getValue() == cards[2].getValue()
					&& cards[0].getValue() == cards[i].getValue() && i != 1
					&& i != 2) {
				pair = pair + 1;
			}
		}
		for (int i = 0; i <= 4; i++) {
			if (cards[2].getValue() == cards[3].getValue()
					&& cards[0].getValue() == cards[i].getValue() && i != 2
					&& i != 3) {
				pair = pair + 1;
			}
		}
		for (int i = 0; i <= 4; i++) {
			if (cards[3].getValue() == cards[4].getValue()
					&& cards[0].getValue() == cards[i].getValue() && i != 3
					&& i != 4) {
				pair = pair + 1;
			}
		}

	}

	@Test
	public void Straight() {
		Card[] cards = new Card[5];
		cards[0] = new Card(3, 2);
		cards[1] = new Card(2, 2);
		cards[2] = new Card(1, 2);
		cards[3] = new Card(4, 2);
		cards[4] = new Card(5, 2);
		int count = 0;
		int y = 0;
		for (int i = 0; i < 5; i++) {
			int x = 0;

			for (int j = 0; j < 5; j++) {
				if (cards[i].getValue() + 1 == cards[j].getValue()
						&& cards[i].getValue() != y) {
					x++;
					if (x == 1) {
						count++;
						y = cards[i].getValue();
						break;
					}

				}
			}
		}

	}
}
