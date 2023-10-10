package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {

	@Test
	public void testHasPair() {
		Card[] hand = {new Card(1,0), new Card(1,0), new Card(1,0), 
				new Card(1,0), new Card(1,0)};
		assertTrue(PokerHandEvaluator.hasPair(hand));
		Card[] hand1 = {new Card(5,3), new Card(5,0), new Card(6,3), 	
				new Card(3,2), new Card(4,1)};
		assertTrue(PokerHandEvaluator.hasPair(hand1));
		Card[] hand2 = {new Card(8,2), new Card(3,0), new Card(2,0), 
				new Card(1,3), new Card(10,1)};
		assertFalse(PokerHandEvaluator.hasPair(hand2));
	}

	@Test
	public void testThreeOfAKind() {
		Card[] hand = {new Card(1,0), new Card(1,0), new Card(1,0), 
				new Card(1,0), new Card(1,0)};
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(hand));
		Card[] hand2 = {new Card(5,0), new Card(10,0), new Card(2,0),
				new Card(8,0), new Card(8,0)};
		assertFalse(PokerHandEvaluator.hasThreeOfAKind(hand2));
	}

	@Test
	public void testHasFlush() {
		Card[] hand = {new Card(6,0), new Card(1,0), new Card(8,0), 
				new Card(12,0), new Card(2,0)};
		assertTrue(PokerHandEvaluator.hasFlush(hand));	
		Card[] hand1 = {new Card(6,1), new Card(1,0), new Card(8,0), 
				new Card(12,0), new Card(2,0)};
		assertFalse(PokerHandEvaluator.hasFlush(hand1));
	}

	@Test
	public void testHasFullHouse() {
		Card[] hand = {new Card(7,1), new Card(7,2), new Card(7,3),
				new Card(12,0), new Card(12,0)};
		assertTrue(PokerHandEvaluator.hasFullHouse(hand));
		Card[] hand1 = {new Card(8,1), new Card(8,2), new Card(8,3),
				new Card(12,0), new Card(13,0)};
		assertFalse(PokerHandEvaluator.hasFullHouse(hand1));	
	}

	@Test	
	public void testHasStraightFlush() {
		Card[] hand = {new Card(1,1), new Card(2,1), new Card(3,1), 	
				new Card(4,1), new Card(5,1)};	
		assertTrue(PokerHandEvaluator.hasStraightFlush(hand));	
		Card[] hand2 = {new Card(8,1), new Card(9,1), new Card(10,1), 
				new Card(11,1), new Card(12,1)};
		assertTrue(PokerHandEvaluator.hasStraightFlush(hand2));
	}	
}

