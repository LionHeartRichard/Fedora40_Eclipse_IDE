package topalgorithm.roadmap.slidingwindow.fixedlength;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import topalgorithm.roadmap.slidingwindow.SlidingWindow;

public class SlidingWindowFixedLength implements SlidingWindow {
	/*
	 * Дан целочисленный массив нужно вернуть максимальную сумму k-подряд идущих
	 * элементов
	 * 
	 * Input: nums = {3,2,5,9,4,1}; k = 3; Output: 18
	 */

	public int findMaxSumSlidingWindow(int[] nums, int k) {

		int maxSum = 0;
		for (int idx = 0; idx < k; ++idx) {
			maxSum += nums[idx];
		}

		int currentSum = maxSum;
		for (int idx = k; idx < nums.length; ++idx) {
			currentSum = currentSum - nums[idx - k] + nums[idx];
			if (maxSum < currentSum)
				maxSum = currentSum;
		}
		return maxSum;
	}

	@Test
	public void findMaxSumSlidingWindowWhenSlidingWindow3ThenReturn18() {
		int[] nums = { 3, 2, 5, 9, 4, 1 };
		int k = 3;

		int expected = 18;
		int actual = findMaxSumSlidingWindow(nums, k);

		assertEquals(expected, actual);
	}

	/*
	 * Дан целочисленный массив нужно вернуть максимальное произведение k-подряд
	 * идущих элементов
	 * 
	 * Input: nums = {4,0,5,2,4,1,0}; k = 3; Output: 40
	 */

	public int findMaxMulSlidingWindow(int[] nums, int k) {
		int maxMul = 0;
		int countZero = 0;

		for (int idx = 0; idx < k; ++idx) {
			if (nums[idx] == 0)
				++countZero;
			else
				maxMul *= nums[idx];
		}

		int currentMul = maxMul;
		for (int idx = k; idx < nums.length; ++idx) {
			if (nums[idx] == 0)
				++countZero;
			if (nums[idx - k] != 0)
				--countZero;
			if (countZero <= 0) {
				currentMul = currentMul / nums[idx - k] * nums[idx];
				if (maxMul < currentMul)
					maxMul = currentMul;
			}
		}
		return maxMul;
	}

	@Test
	public void findMaxMulSlidingWindowWhenSlidingWindow3ThenReturn40() {
		int[] nums = { 4, 0, 5, 2, 4, 1, 0 };
		int k = 3;

		int expected = 40;
		int actual = findMaxMulSlidingWindow(nums, k);

		assertEquals(expected, actual);
	}

}
