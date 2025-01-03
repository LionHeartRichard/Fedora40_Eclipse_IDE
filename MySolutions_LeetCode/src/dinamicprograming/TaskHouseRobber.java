package dinamicprograming;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskHouseRobber {

	public int rob(int[] nums) {
		int len = nums.length;
		if (len == 1)
			return nums[0];

		int[] cach = new int[len];

		cach[0] = nums[0];
		cach[1] = Math.max(nums[0], nums[1]);

		for (int idx = 2; idx < len; ++idx) {
			cach[idx] = Math.max(cach[idx - 1], nums[idx] + cach[idx - 2]);
		}

		return cach[len - 1];
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
