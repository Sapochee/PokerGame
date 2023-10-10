package poker;

/*
 * this class contains the deck as well as various methods that manipulate the
 * deck such as shuffling or cutting
 */
public class Deck {

	private Card[] cards;
	private final int KING = 13;
	private final int QUEEN = 12;
	private final int JACK = 11;
	private final int SPADE = 0;
	private final int HEART = 1;
	private final int CLUB = 2;
	private final int DIAMOND = 3;
	
	/*
	 * creates the deck of cards
	 */
	public Deck() {
		cards = new Card[52];
		//creates the deck where the first parameter sets the values of the card
		//and the second parameter sets the suits of the card
		for(int i=0; i<cards.length; i++) {
			if(i<KING) {
				cards[i] = new Card(i+1, SPADE);
			} else if(i<26) {
				cards[i] = new Card(i-12, HEART);
			} else if(i<39) {
				cards[i] = new Card(i-25, CLUB);
			} else {
				cards[i] = new Card(i-38, DIAMOND);
			}
		}
	}

	/*
	 * creates a standard copy constructor with a shallow copy of the array of
	 * cards
	 */
	public Deck(Deck other) {
		cards = new Card[other.getNumCards()];
		for(int i=0; i<other.getNumCards(); i++) {
			cards[i] = other.getCardAt(i);
		}
	}

	/*
	 * returns the card specified at the position within the deck by searching
	 * for the parameter in the array list
	 */
	public Card getCardAt(int position) {
		return cards[position];
	}

	/*
	 * returns the size of the deck by counting the size of the array list
	 */
	public int getNumCards() {
		return cards.length;
	}

	/*
	 * this shuffles the deck by shuffling around the array list order
	 */
	public void shuffle() {
		Card[] topDeck, botDeck;
		if(getNumCards()%2 == 0) {
			topDeck = new Card[getNumCards()/2];
			botDeck = new Card[getNumCards()/2];
		} else {
			topDeck = new Card[getNumCards()/2+1];
			botDeck = new Card[getNumCards()/2];
		}
		for(int i=0; i<getNumCards(); i++) {
			if(i<topDeck.length) {
				topDeck[i] = cards[i];
			} else {
				botDeck[i-topDeck.length] = cards[i];
			}
		}
		for(int i=0; i<getNumCards(); i++) {
			if(i%2 == 0) {
				cards[i] = topDeck[i/2];
			} else {
				cards[i] = botDeck[i/2];
			}
		}
	}

	/*
	 * divides the array list into two and switches the positions of the first
	 * and second half of the array list by putting the second half of the deck
	 * on top of the first half
	 */
	public void cut(int position) {
		Card [] botDeck = new Card[position];
		Card [] topDeck = new Card[getNumCards()-position];
		for(int i=0; i<position; i++) {
			botDeck[i] = cards[i];	
		}
		for(int i=position; i<getNumCards(); i++) {
			topDeck[i-position] = cards[i];
		}
		for(int i=0; i<topDeck.length; i++) {
			cards[i] = topDeck[i];
		}
		for(int i=topDeck.length; i<getNumCards(); i++) {
			cards[i] = botDeck[i-topDeck.length];
		}
	}

	/*
	 * the specified number in the parameter will be taken away from the front
	 * of the array list
	 */
	public Card[] deal(int numCards) {
		Card[] smaller = new Card[getNumCards()-numCards];
		Card[] numCardsDealt = new Card[numCards];
		for(int i=0; i<getNumCards()-numCards; i++) {
			smaller[i] = cards[i+numCards];
		}
		for(int i=0; i<numCards; i++) {
			numCardsDealt[i] = cards[i];
		}
		cards = smaller;
		return numCardsDealt;
	}

}
