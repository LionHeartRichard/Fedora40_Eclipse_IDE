package arrayandstring;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/*
 *  Найти H-Index исследователя,
 *  смотри википедию
 */

public class HIndex {
	public int hIndex(int[] citations) {

	}

	@Test
	public void case1() {
		int[] citations = { 3, 0, 6, 1, 5 };

		int expected = 3;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] citations = { 1, 3, 1 };

		int expected = 1;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}
}
