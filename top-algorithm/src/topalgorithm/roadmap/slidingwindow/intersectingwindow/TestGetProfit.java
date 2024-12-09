package topalgorithm.roadmap.slidingwindow.intersectingwindow;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import static topalgorithm.roadmap.slidingwindow.intersectingwindow.GetProfit.*;

class TestGetProfit {
	@Test
	public void test1() {
		int[] prices = { 3, 2, 6, 5, 1, 3 };
		int[] actual = getIndexes(prices, 2);
		int[] expected = { 1, 2, 4, 5 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test2() {
		int[] prices = { 1, 2, 1, 6, 5, 1, 3 };
		int[] actual = getIndexes(prices, 3);
		int[] expected = { 0, 1, 2, 3, 5, 6 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void positiveTest3() {
		int[] prices = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] actual = getIndexes(prices, 2);
		int[] expected = { 0, 9, 0, 0 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test4() {
		int[] prices = { 1, 1, 2, 9, 4, 5, 6, 7 };
		int[] actual = getIndexes(prices, 1);
		int[] expected = { 1, 3 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test5() {
		int[] prices = new int[] { 1, 4, 2, 3, 3, 5 };
		int[] actual = getIndexes(prices, 2);
		int[] expected = { 0, 1, 4, 5 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test6() {
		int[] prices = new int[] { 3, 2, 2 };
		int[] actual = getIndexes(prices, 2);
		assertArrayEquals(new int[] { 0, 0, 0, 0 }, actual);
	}

	@Test
	public void test7() {
		int[] prices = new int[] { 3, 5, 9, 10, 2, 3, 29, 1, 2, 4, 5, 1, 22 };
		int[] actual = getIndexes(prices, 2);
		int[] expected = { 4, 6, 11, 12 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test8() {
		int[] prices = new int[] { 10, 5, 5, 7, 6 };
		int[] actual = getIndexes(prices, 2);
		int[] expected = { 2, 3, 0, 0 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test9() {
		int[] prices = new int[] { 3, 4, 6, 5, 7, 9, 1 };
		int[] actual = getIndexes(prices, 2);

		int[] expected = { 0, 2, 3, 5 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test10() {
		int[] prices = new int[] { 5, 6, 7, 9, 8, 9, 12, 11, 13, 14, 13, 11, 15, 4, 5, 7 };
		int[] actual = getIndexes(prices, 3);
		int[] expected = { 0, 3, 4, 6, 11, 12 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test11() {
		int[] prices = new int[] { 6, 7, 5, 8, 10, 8, 9, 12, 9 };
		int[] actual = getIndexes(prices, 2);
		int[] expected = { 2, 4, 5, 7 };
		assertArrayEquals(expected, actual);
	}
}
