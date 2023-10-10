package poker;

/*
 * this class evaluates the player's hand to see if their card contains any
 * poker combinations varying from pairs to flushes
 */
public class PokerHandEvaluator {

	/*
	 * this method sorts the cards in the player's hand in order to better count
	 * for duplicate cards next to each other
	 */
	public static void sortHand(Card[] cards) {
		for(int i=0; i<cards.length; i++) {
			for(int value=0; value<cards.length-1; value++) {
				if(cards[value].getValue() > cards[value+1].getValue()) {
					Card playerCards = cards[value];
					cards[value] = cards[value+1];
					cards[value+1] = playerCards;
				}
			}
		}
	}

	public static boolean hasPair(Card[] cards) {
		for(int i=0; i<4; i++) {
			for(int value=i+1; value<5; value++) {
				if(cards[i].getValue() == cards[value].getValue()) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean hasTwoPair(Card[] cards) {
		sortHand(cards);
		int pair = 0;
		int numPairs = 0;
		for(int i=0; i<4; i++) {
			if(pair!=cards[i].getValue() && 
					cards[i].getValue() == 
					cards[i+1].getValue()) {
				numPairs++;
				pair = cards[i].getValue();
			}
		}
		if(numPairs == 2) {
			return true;
		}
		return false;
	}

	public static boolean hasThreeOfAKind(Card[] cards) {
		sortHand(cards);
		for(int i=0; i<3; i++) {
			if(cards[i].getValue() == cards[i+1].getValue() &&
					cards[i+1].getValue() == cards[i+2].getValue()) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasStraight(Card [] cards) {
		sortHand(cards);
		boolean isStraight = true;
		for(int i=0; i<4; i++) {
			if(cards[i].getValue()+1 != cards[i+1].getValue()) {
				isStraight = false;
			}
		}
		if (cards[0].getValue() == 1 &&
				cards[1].getValue() == 10 &&
				cards[2].getValue() == 11 &&
				cards[3].getValue() == 12 && 
				cards[4].getValue() == 13) {
			return true;
		} else {
			return isStraight;
		}
	}

	public static boolean hasFlush(Card[] cards) {
		int compare = cards[0].getSuit();
		return cards[1].getSuit() == compare &&
				cards[2].getSuit() == compare &&
				cards[3].getSuit() == compare &&
				cards[4].getSuit() == compare;
	}

	public static boolean hasFullHouse(Card[] cards) {
		sortHand(cards);
		for(int i=0; i<2; i++) {
			if(cards[i].getValue() == cards[i+1].getValue() &&
					cards[i+1].getValue() == cards[i+2].getValue() &&
					cards[i+3].getValue() == cards[i+4].getValue()) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasFourOfAKind(Card[] cards) {
		sortHand(cards);
		for(int i=0; i<3; i++) {
			if(cards[i].getValue() == cards[i+1].getValue() &&
					cards[i+1].getValue() == cards[i+2].getValue() &&
					cards[i+2].getValue() == cards[i+3].getValue()) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasStraightFlush(Card[] cards) {
		return hasStraight(cards) && hasFlush(cards);
	}
}

