package topalgorithm.roadmap.twopointers.pointer_for_each;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PointerForEach {

	/*
	 * Паттерн каждому по указателю
	 * 
	 * Задача: Найти пересечение двух отсортированных массивов
	 */

	public Integer[] pointerForEachTwoArrays(int[] arrayA, int[] arrayB) {
		List<Integer> result = new ArrayList<>();
		int pointerA = 0;
		int pointerB = 0;
		while (pointerA < arrayA.length && pointerB < arrayB.length) {
			if (arrayA[pointerA] == arrayB[pointerB]) {
				result.add(arrayA[pointerA]);
				++pointerA;
				++pointerB;
			} else if (arrayA[pointerA] < arrayB[pointerB]) {
				++pointerA;
			} else if (arrayB[pointerB] < arrayA[pointerA]) {
				++pointerB;
			}
		}
		Integer[] res = new Integer[result.size()];
		res = result.toArray(res);
		return res;
	}

	@Test
	public void pointerForEachTwoArraysTest() {
		int[] arrayA = { 2, 2, 5, 8, 14, 19, 29, 30 };
		int[] arrayB = { -3, 0, 1, 2, 2, 8, 19 };
		Integer[] expected = { 2, 2, 8, 19 };

		Integer[] actual = pointerForEachTwoArrays(arrayA, arrayB);

		assertArrayEquals(expected, actual);
	}

}
