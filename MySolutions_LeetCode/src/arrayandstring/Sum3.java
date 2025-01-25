package arrayandstring;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

/*
 * Дан целочисленный массив nums, вернуть все триплеты [nums[i], nums[j], nums[k]] такие, 
 * что i != j, i != k и j != k, и nums[i] + nums[j] + nums[k] == 0.
 * 
 * Constraints:
 	3 <= nums.length <= 3000
 */

public class Sum3 {

	Set<Integer> cache;

	public List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		// создаем кэш, для хранения промежуточных ответов
		cache = new HashSet<>();
		// сортируем массив
		Arrays.sort(nums);
		Set<List<Integer>> ans = new HashSet<>();
		// создаем 3 указателя - выбираем из них опорный, который будет медленно
		// перемещятся по всему массиву
		// два других будут расчитыватся исходя из опорного
		// пусть опорным будет i
		for (int i = 0; i < len; ++i) {
			// декомпозируем задачу
			cache.add(i);
			int[] arrFindIdx = twoSum(nums, -nums[i], len);
			if (arrFindIdx.length != 0) {
				ans.add(new ArrayList<>(Arrays.asList(nums[arrFindIdx[0]], nums[arrFindIdx[1]], nums[i])));
			}
			if (cache.size() == len)
				break;
		}
		return new ArrayList<>(ans);
	}

	// реализация через правый и левый указатель
	private int[] twoSum(int[] nums, int findNumber, int len) {
		int leftIdx = 0;
		int rightIdx = len - 1;
		while (leftIdx < rightIdx) {
			while (leftIdx < rightIdx && cache.contains(leftIdx)) {
				++leftIdx;
			}
			while (rightIdx > leftIdx && cache.contains(rightIdx))
				--rightIdx;
			int sum = nums[leftIdx] + nums[rightIdx];
			if (sum == findNumber) {
				cache.add(leftIdx);
				cache.add(rightIdx);
				return new int[] { leftIdx, rightIdx };
			}
			if (sum < findNumber) {
				++leftIdx;
			} else {
				--rightIdx;
			}
		}
		return new int[] {};
	}

	@Test
	public void case1() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };

		List<List<Integer>> expected = new ArrayList<>();
		List<Integer> expectedSubListA = new ArrayList<>(Arrays.asList(-1, -1, 2));
		List<Integer> expectedSubListB = new ArrayList<>(Arrays.asList(-1, 0, 1));
		expected.add(expectedSubListA);
		expected.add(expectedSubListB);
		List<List<Integer>> actual = threeSum(nums);

		for (int idx = 0; idx < actual.size(); ++idx) {
			List<Integer> currentExpected = expected.get(idx);
			List<Integer> currentActual = actual.get(idx);
			assertThat(currentExpected).containsExactlyInAnyOrderElementsOf(currentActual);
		}
	}

	@Test
	public void case2() {
		int[] nums = { 0, 0, 0 };

		List<List<Integer>> expected = new ArrayList<>();
		List<Integer> expectedSubListA = new ArrayList<>(Arrays.asList(0, 0, 0));
		expected.add(expectedSubListA);
		List<List<Integer>> actual = threeSum(nums);

		for (int idx = 0; idx < actual.size(); ++idx) {
			List<Integer> currentExpected = expected.get(idx);
			List<Integer> currentActual = actual.get(idx);
			assertThat(currentExpected).containsExactlyInAnyOrderElementsOf(currentActual);
		}
	}
}
