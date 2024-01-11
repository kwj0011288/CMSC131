package poker;

public class PokerHandEvaluator {

	// check if values are same values by checking every cards value
	public static boolean hasPair(Card[] cards) {
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					return true; 
				}
			}
		}
		return false; 
	}
	public static boolean hasTwoPair(Card[] cards) {

		boolean check = false;
		int count = 0;
		int repeat = 0;
		/* check values as loops go, but consider that there must be only 
		 * two pairs, not more than that by putting repeat value to check
		 * if they are not repeating.
		 * */
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (cards[i].getValue()  != repeat
						&& cards[i].getValue() == cards[j].getValue() ) {
					repeat = cards[i].getValue();
					count++;
				}
			}
		}
		if (count >= 2) {
			check = true;
		}
		return check;
	}

	public static boolean hasThreeOfAKind(Card[] cards) {

		int count = 0;
		/* check if values are same as loops go */
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					count++;
				}
			}
			/* if counter is more or less than 2, reset 
			 */
			if (count != 2) {
				count = 0;
			} else {
				return true;
			}
		}
		return false;
	}

	public static boolean hasStraight(Card[] cards) {

		/* need to find min and max
		 */
		int max = 0;
		int min = 14;
		for (int i = 0; i < 5; i++) {
			if (cards[i].getValue() > max) { //assign max value
				max = cards[i].getValue();
			}
			if (cards[i].getValue() < min) {
				min = cards[i].getValue(); // assign min value
			}
		}
		// if values are not equal, increment dif
		int dif = 0;
		boolean different = false;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (cards[i].getValue() != cards[j].getValue()) {
					dif++;
				}
			}
		}
		/* since there are only 10 cases to check 
		the index of array, return true
		 */
		if (dif == 10) { 
			different = true;
		}
		if (different) { // need to check if the numbers are sequence
			if (max - min == 4) {
				return true; 
			}
		}
		//check if ace is 14 not 1
		int count = 0;
		for (int i = 0; i < 5; i++) {
			if (different == true) {
				if (cards[i].getValue() == 10 ||
						cards[i].getValue() == 11 ||
						cards[i].getValue() == 12 ||
						cards[i].getValue() == 13 ||
						cards[i].getValue() == 1 ) {
					count++;
				}
			}
		}
		//if count is equals 5, return true
		if (count == 5) {
			return true;
		} 
		return false;	
	}

	public static boolean hasFlush(Card[] cards) {
		/* if suit from 0 are equals to every cards beyond, 
		 * update count
		 */
		int count = 0;
		for (int i = 1; i < 5; i++) {
			if (cards[0].getSuit() == cards[i].getSuit()) {
				count++;
			}
			/* if counter is 4, which means if suits are the same
			 * return true
			 */
			if (count == 4) {

				return true;
			} 
		}
		return false;

	}

	public static boolean hasFullHouse(Card[] cards) {
		int count = 0;
		int repeat = 0;
		/*check if there are no same numbers and make sure that 
		 * the numbers are equal for 3 cards 
		 * 
		 */
		boolean answer1 = false;
		boolean answer2 = false;

		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					count++;
					repeat = cards[i].getValue();
				}
			}
			/*sometimes, three of kind could be pair, 
			 * so set up that if they are pair, reset the count.
			 * 
			 */
			if (count != 2) { 
				count = 0;
			} else if (count == 2){
				answer1 = true;
			} else {
				return false;
			}
		}
		/*check if there are no same numbers and make sure that 
		 * the numbers are equal for 3 cards 
		 * make sure that both works for pair and three of kind
		 */
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (cards[i].getValue() == cards[j].getValue() 
						&& repeat != cards[i].getValue() ) {
					answer2 = true;
				}
			}
		}
		/*if both pair and three of kind are working
		 * return true 
		 */
		if (answer1 && answer2) {
			return true;
		}else {
			return false; 

		}
	}

	public static boolean hasFourOfAKind(Card[] cards) {
		int count = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					count++;
				}
			}

			/* just like three of a kind and pair, reset counter if 
			 * they are not equals to 3, reset count.
			 */
			if (count != 3) {
				count = 0;
			} else {
				return true;
			}
		}
		return false;
	}

	/* Since straightflush is straight + flush
	 * use those methods to return true
	 */
	public static boolean hasStraightFlush(Card[] cards) {
		if (hasStraight(cards) && hasFlush(cards)) {
			return true;
		} else {
			return false;
		}
	}

}
