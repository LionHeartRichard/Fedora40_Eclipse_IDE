package repeat;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class KeyValue_ValueKey {

	/*
	 * Алгоритм когда мы заполняем мапу ключь-значение а потом переворачиваем
	 * значение-ключь
	 */

	/*
	 * Задача: Дан целочисленный масив nums, и целое число k, нужно вернуть k
	 * наиболее частых элементов. Можно вернуть в любом порядке
	 */

	public int[] valueKey_keyValue(int[] nums, int k) {
		// 1) Алоцируем мапу в которой КЛЮЧ = ЗНАЧЕНИЕ
		Map<Integer, Integer> mapCache = new HashMap<>();
		for (int value : nums) {
			mapCache.put(value, mapCache.getOrDefault(value, 0) + 1);
		}
		// 2.1) Алоцируем массив пустых списков
		int len = nums.length;
		List<Integer>[] cache = new List[len + 1];
		for (int idx = 1; idx <= len; ++idx) {
			cache[idx] = new ArrayList<>();
		}
		// 2.2) Меняем местами ключ-значение
		for (int key : mapCache.keySet()) {
			cache[mapCache.get(key)].add(key);
		}
		// 3) Формируем ответ
		List<Integer> ans = new ArrayList<>();
		for (int idx = len; idx > 0; --idx) {
			List<Integer> currentAns = cache[idx];
			for (int value : currentAns) {
				if (k <= 0)
					return ans.stream().mapToInt(v -> v).toArray();
				ans.add(value);
				--k;
			}
		}
		return ans.stream().mapToInt(v -> v).toArray();
	}

	@Test
	public void case1() {
		int[] nums = { 5, 3, 1, 5, 5, 3, 7 };
		int k = 2;
		Set<Integer> expected = new HashSet<>();
		expected.add(3);
		expected.add(5);

		int[] actual = valueKey_keyValue(nums, k);

		for (int item : actual) {
			assertTrue(expected.contains(item));
		}
	}

	@Test
	public void case2() {
		int[] nums = { 0, 0, 0, 0, 0, 0, 0 };
		int k = 3;
		Set<Integer> expected = new HashSet<>();
		expected.add(0);

		int[] actual = valueKey_keyValue(nums, k);

		for (int item : actual) {
			assertTrue(expected.contains(item));
		}
	}

}
