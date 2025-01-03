package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BestTimeToBuyAndSellStock2 {

	public int maxProfit(int[] prices) {

		int totalSum = 0;

		for (int i = 1; i < prices.length; ++i) {
			if (prices[i - 1] < prices[i]) {
				totalSum += prices[i] - prices[i - 1];
			}
		}

		return totalSum;
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

	@Test
	public void case4() {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int expected = 8;

		int actual = maxProfit(prices);

		assertEquals(expected, actual);
	}

}
