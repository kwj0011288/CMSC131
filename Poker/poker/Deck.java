package poker;

public class Deck {

	private Card[] cards;
	//card total number is 52
	//assign value and suit to the card object
	public Deck() {
		cards = new Card[52];
		int rest = 0;
		int deck = cards.length;
		for (int i = 0; i < deck; i++) {
			rest = (i + 1) % 13;
			if (rest == 0) {
				rest = 13;
			}
			cards[i] = new Card(rest, i/13);
		}
	}

	public Deck(Deck other) { // make a shallow copy of Deck

		cards = new Card[other.cards.length];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = other.cards[i];	
		}
	}
	// get value and suit of the card and assign them to the new Card object
	public Card getCardAt(int position) { 
		int value = cards[position].getValue();
		int suit = cards[position].getSuit();
		Card cards = new Card (value, suit);

		return cards;
	}
	// get cards.length for the number
	public int getNumCards() {
		return cards.length;	
	}

	public void shuffle() {
		//divided card pack into two
		Card[] top;
		Card[] bottom;
		//check if number of the card is even or odd
		if (cards.length % 2 == 0) {
			top = new Card[cards.length/2];
		} else {
			top = new Card[(cards.length/2) + 1];
		}
		//assign card on the top 
		for (int i = 0; i < top.length; i++) {
			top[i] = cards[i];
		}
		int cardStack = top.length;
		bottom = new Card[cards.length - cardStack];
		//assign card to the bottom
		for (int i = 0; i < bottom.length; i++) {
			bottom[i] = cards[cardStack++];	
		}
		//mix them up but zigzag
		int odd = 0;
		int even = 0;
		for (int i = 0; i < cards.length; i++) {
			if (i % 2 == 0) {
				cards[i] = top[odd++];
			} else {
				cards[i] = bottom[even++];
			}
		}
	}

	public void cut(int position) {
		// divide card pack into two
		Card[] cut = new Card[position];
		Card[] rest = new Card[cards.length - position];
		int index = 0;
		//get cut card first and get rest of them
		for (int i = 0; i < cut.length; i++) {
			cut[i] = cards[i];
		}
		for (int i = 0; i < rest.length; i++) {
			rest[i] = cards[position++];
		}
		// put them together but put rest first
		for (int i = 0; i < cards.length; i++) {
			if (i < rest.length) {
				cards[i] = rest[i];
			} else {
				cards[i] = cut[index++];
			}
		}
	}
	
	public Card[] deal(int numCards) {
		//check how many cards are going to put down on the table
		//and assign them into the new array
		Card[] deal = new Card[numCards];
		for (int i = 0; i < numCards; i++) {
			deal[i] = cards[i];
		}
		//reduce the numCards from the deck of cards
		Card[] smaller = new Card[cards.length - numCards];
		for (int i = 0; i < smaller.length; i++) {
			smaller[i] = cards[numCards++]; // assign them without deal
		}
		//put all the values from smaller to cards
		cards = new Card[smaller.length];
		for (int i = 0; i< cards.length; i++){
			cards[i] = smaller[i];
		}

		return deal;
	}
}
