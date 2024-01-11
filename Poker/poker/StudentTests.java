package poker;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTests {

	@Test
	public void hasPairTest1() {
		Card[] cards = new Card[5];
		cards[0] = new Card(1,1);
		cards[1] = new Card(4,1);
		cards[2] = new Card(2,1);
		cards[3] = new Card(7,1);
		cards[4] = new Card(2,1);
		
		assertTrue(PokerHandEvaluator.hasPair(cards));
		
	}
	@Test
	public void hasPairTest2() {
		Card[] cards = new Card[5];
		cards[0] = new Card(1,1);
		cards[1] = new Card(4,1);
		cards[2] = new Card(2,1);
		cards[3] = new Card(7,1);
		cards[4] = new Card(3,1);
		
		assertEquals(false, PokerHandEvaluator.hasPair(cards));
		
	}

	@Test
	public void hasTwoPairTest1() {
		Card[] cards = new Card[5];
		cards[0] = new Card(1,1);
		cards[1] = new Card(2,2);
		cards[2] = new Card(4,2);
		cards[3] = new Card(1,3);
		cards[4] = new Card(4,0);
		
		assertTrue(PokerHandEvaluator.hasTwoPair(cards));
		
	}
	

	@Test
	public void hasTwoPairTest2() {
		Card[] cards = new Card[5];
		cards[0] = new Card(2,1);
		cards[1] = new Card(3,2);
		cards[2] = new Card(2,2);
		cards[3] = new Card(3,1);
		cards[4] = new Card(2,3);
		
		assertEquals(true, PokerHandEvaluator.hasTwoPair(cards));
		
	}
	
	@Test
	public void hasTwoPairTest3() {
		Card[] cards = new Card[5];
		cards[0] = new Card(2,1);
		cards[1] = new Card(3,2);
		cards[2] = new Card(2,2);
		cards[3] = new Card(3,1);
		cards[4] = new Card(3,3);
		
		assertEquals(true, PokerHandEvaluator.hasTwoPair(cards));
		
	}


	@Test
	public void hasThreeOfAKindTest1() {
		Card[] cards = new Card[5];
		cards[0] = new Card(4,1);
		cards[1] = new Card(8,2);
		cards[2] = new Card(8,0);
		cards[3] = new Card(3,1);
		cards[4] = new Card(8,3);
		
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(cards));
		
	}
	
	@Test
	public void hasThreeOfAKindTest2() {
		Card[] cards = new Card[5];
		cards[0] = new Card(4,1);
		cards[1] = new Card(8,2);
		cards[2] = new Card(8,0);
		cards[3] = new Card(3,1);
		cards[4] = new Card(2,3);
		
		assertEquals(false, PokerHandEvaluator.hasThreeOfAKind(cards));
		
	}
	
	@Test
	public void hasStraightTest1() {
		Card[] cards = new Card[5];
		cards[0] = new Card(10,2);
		cards[1] = new Card(12,3);
		cards[2] = new Card(11,1);
		cards[3] = new Card(9,2);
		cards[4] = new Card(13,1);
		
		assertTrue(PokerHandEvaluator.hasStraight(cards));
		
	}
	@Test
	public void hasStraightTest2() {
		Card[] cards = new Card[5];
		cards[0] = new Card(10,1);
		cards[1] = new Card(11,2);
		cards[2] = new Card(12,2);
		cards[3] = new Card(12,1);
		cards[4] = new Card(1,2);
		
		assertEquals(false, PokerHandEvaluator.hasStraight(cards));
		
	}
	
	@Test
	public void hasStraightTest3() {
		Card[] cards = new Card[5];
		cards[0] = new Card(12,1);
		cards[1] = new Card(11,1);
		cards[2] = new Card(8,1);
		cards[3] = new Card(10,2);
		cards[4] = new Card(8,2);
		
		assertEquals(false, PokerHandEvaluator.hasStraight(cards));
		
	}
	

	@Test
	public void hasFlushTest1() {
		Card[] cards = new Card[5];
		cards[0] = new Card(1,1);
		cards[1] = new Card(3,1);
		cards[2] = new Card(2,1);
		cards[3] = new Card(4,1);
		cards[4] = new Card(5,1);
		
		assertTrue(PokerHandEvaluator.hasFlush(cards));
		
	}
	@Test
	public void hasFlushTest2() {
		Card[] cards = new Card[5];
		cards[0] = new Card(1,1);
		cards[1] = new Card(3,1);
		cards[2] = new Card(2,2);
		cards[3] = new Card(4,1);
		cards[4] = new Card(5,1);
		
		assertEquals(false,PokerHandEvaluator.hasFlush(cards));
		
	}
	@Test
	public void hasFullHouseTest1() {
		
		Card[] cards = new Card[5];
		cards[0] = new Card(7,1);
		cards[1] = new Card(3,1);
		cards[2] = new Card(7,2);
		cards[3] = new Card(3,2);
		cards[4] = new Card(7,3);
		
		
		assertTrue(PokerHandEvaluator.hasFullHouse(cards));
		
	}
	@Test
	public void hasFullHouseTest2() {
		
		Card[] cards = new Card[5];
		cards[0] = new Card(3,2);
		cards[1] = new Card(2,1);
		cards[2] = new Card(2,2);
		cards[3] = new Card(1,2);
		cards[4] = new Card(1,3);
	
		assertEquals(false, PokerHandEvaluator.hasFullHouse(cards));
		
	}
	@Test
	public void hasFourOfAKindTest1() {
		Card[] cards = new Card[5];
		cards[0] = new Card(5,0);
		cards[1] = new Card(5,1);
		cards[2] = new Card(2,1);
		cards[3] = new Card(5,2);
		cards[4] = new Card(5,3);
		
		assertTrue(PokerHandEvaluator.hasFourOfAKind(cards));
		
	}
	@Test
	public void hasFourOfAKindTest2() {
		Card[] cards = new Card[5];
		cards[0] = new Card(5,0);
		cards[1] = new Card(3,1);
		cards[2] = new Card(2,1);
		cards[3] = new Card(5,2);
		cards[4] = new Card(5,3);
		
		assertEquals(false, PokerHandEvaluator.hasFourOfAKind(cards));
		
	}
	@Test
	public void hasStraightFlushTest1() {
		Card[] cards = new Card[5];
		cards[0] = new Card(1,1);
		cards[1] = new Card(2,1);
		cards[2] = new Card(3,1);
		cards[3] = new Card(4,1);
		cards[4] = new Card(5,1);
		
		assertTrue(PokerHandEvaluator.hasStraightFlush(cards));
		
	}
	@Test
	public void hasStraightFlushTest2() {
		Card[] cards = new Card[5];
		cards[0] = new Card(1,1);
		cards[1] = new Card(3,1);
		cards[2] = new Card(2,1);
		cards[3] = new Card(3,2);
		cards[4] = new Card(5,1);
		
		assertEquals(false, PokerHandEvaluator.hasStraightFlush(cards));
		
	}
	@Test
	public void hasStraightFlushTest3() {
		Card[] cards = new Card[5];
		cards[0] = new Card(1,1);
		cards[1] = new Card(3,1);
		cards[2] = new Card(6,1);
		cards[3] = new Card(4,1);
		cards[4] = new Card(5,1);
		
		assertEquals(false, PokerHandEvaluator.hasStraightFlush(cards));
		
	}


}