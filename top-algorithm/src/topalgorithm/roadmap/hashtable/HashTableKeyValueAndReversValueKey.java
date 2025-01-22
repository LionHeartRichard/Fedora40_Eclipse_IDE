package topalgorithm.roadmap.hashtable;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class HashTableKeyValueAndReversValueKey implements HashTable {

	/*
	 * Алгоритм когда мы заполняем мапу ключь-значение а потом переворачиваем
	 * значение-ключь
	 */

	/*
	 * Задача: Дан целочисленный масив nums, и целое число k, нужно вернуть k
	 * наиболее частых элементов. Можно вернуть в любом порядке
	 */

	public int[] algoritmKeyValueAndReversValueKey(int[] nums, int k) {
		// time O[n]
		// memory O[n]

		// Первая стадия создаем мапу
		Map<Integer, Integer> count = new HashMap<>();
		for (int num : nums) {
			count.put(num, count.getOrDefault(num, 0) + 1);
		}

		// Вторая стадия меняем местами ключ-значение на ЗНАЧЕНИЕ-Ключ
		// Алацируем массив пустых списков
		List<Integer>[] frequancyArray = new List[nums.length + 1];
		for (int i = 0; i < frequancyArray.length; ++i) {
			frequancyArray[i] = new ArrayList<>();
		}
		// ----Непосредственно МЕНЯЕМ МЕСТАМИ кллюч-значение
		for (int num : count.keySet()) {
			int frequency = count.get(num);
			frequancyArray[frequency].add(num);
		}
		// Трятья - Формируем результат
		List<Integer> result = new ArrayList<>();
		for (int i = frequancyArray.length - 1; i > 0; --i) {
			List<Integer> currentFrequancyList = frequancyArray[i];
			for (int num : currentFrequancyList) {
				if (k <= 0) {
					return result.stream().mapToInt(v -> v).toArray();
				}
				result.add(num);
				--k;
			}
		}
		return result.stream().mapToInt(v -> v).toArray();
	}

	@Test
	public void test() {
		int[] nums = { 5, 3, 1, 5, 5, 3, 7 };
		int k = 2;
		Set<Integer> expected = new HashSet<>();
		expected.add(3);
		expected.add(5);

		int[] actual = algoritmKeyValueAndReversValueKey(nums, k);

		for (int item : actual) {
			assertTrue(expected.contains(item));
		}
	}

}
