package arrayandstring;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/*
 * Учитывая целочисленный массив nums, верните массив answer, такой что answer[i] равен произведению 
 * всех элементов nums, кроме nums[i]. 
 * Произведение любого префикса или суффикса nums гарантированно помещается в 32-битное целое число.
 * Вы должны написать алгоритм, который выполняется за время O(n) и без использования операции деления.
 */

public class ProductArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {

		int[] ans = new int[nums.length];
		Arrays.fill(ans, 1);

		int prefix = 1;
		for (int i = 0; i < nums.length; i++) {
			ans[i] *= prefix;
			prefix *= nums[i];
		}

		int suffix = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			ans[i] *= suffix;
			suffix *= nums[i];
		}

		return ans;
	}

	@Test
	public void case1() {
		int[] nums = { 1, 2, 3, 4 };

		int[] expected = { 24, 12, 8, 6 };
		int[] actual = productExceptSelf(nums);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] nums = { -1, 1, 0, -3, 3 };

		int[] expected = { 0, 0, 9, 0, 0 };
		int[] actual = productExceptSelf(nums);

		assertArrayEquals(expected, actual);
	}
}
