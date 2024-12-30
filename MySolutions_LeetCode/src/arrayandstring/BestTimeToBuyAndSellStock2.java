package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BestTimeToBuyAndSellStock2 {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n <= 1)
			return 0;

		int[] changes = new int[n - 1];
		for (int i = 0; i < n - 1; ++i) {
			changes[i] = prices[i + 1] - prices[i];
		}

		int maxEndingHere = changes[0];
		int maxSoFar = changes[0];

		for (int i = 1; i < n - 1; ++i) {
			maxEndingHere = Math.max(changes[i], maxEndingHere + changes[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}

		return Math.max(maxSoFar, 0);
	}

	@Test
	public void case1() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int expected = 7;

		int actual = maxProfit(prices);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] prices = { 1, 2, 3, 4, 5 };
		int expected = 4;

		int actual = maxProfit(prices);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		int[] prices = { 7, 6, 4, 3, 1 };
		int expected = 0;

		int actual = maxProfit(prices);

		assertEquals(expected, actual);
	}

}
