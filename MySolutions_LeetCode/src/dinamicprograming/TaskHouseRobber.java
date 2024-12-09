package dinamicprograming;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskHouseRobber {

	private int[] cach = new int[400];

	public int rob(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int n = nums.length - 1;
		return recursionWithCach(nums, n);
	}

	private int recursionWithCach(int[] nums, int n) {
		if (n < 0)
			return 0;
		if (cach[n] == 0) {
			cach[n] = Math.max(nums[n - 1], nums[n - 2]);
			return cach[n];
		}
		return Math.max(recursionWithCach(nums, n - 1), recursionWithCach(nums, n - 2));
	}

	@Test
	public void case1() {
		int[] nums = { 1, 2, 3, 1 };

		int expected = 4;
		int actual = rob(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] nums = { 2, 7, 9, 3, 1 };

		int expected = 12;
		int actual = rob(nums);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		int[] nums = { 2, 1, 1, 2 };

		int expected = 4;
		int actual = rob(nums);

		assertEquals(expected, actual);
	}
}
