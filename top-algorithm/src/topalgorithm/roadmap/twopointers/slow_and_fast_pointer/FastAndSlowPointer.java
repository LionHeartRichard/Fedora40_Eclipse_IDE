package topalgorithm.roadmap.twopointers.slow_and_fast_pointer;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class FastAndSlowPointer {

	/*
	 * Быстрый и медленный указатель - третий шаблон ПАТТЕРНА ДВА УКАЗАТЕЛЯ
	 */

	/*
	 * Задача: Перемещение 0
	 * 
	 * Дан целочисленный массив, переместите все нули в его конец, сохраняя порядок
	 * ненулевых элементов. Обратите внимание, что вы должны сделать in-place - т.е
	 * не создавать копию массива
	 */

	public void fastAndSlowPointer(int[] arr) {
		int fast = 0;
		int slow = 0;
		int len = arr.length;
		while (fast < len) {
			if (arr[fast] != 0) {
				arr[slow++] = arr[fast];
			}
			++fast;
		}
		while (slow < len) {
			arr[slow++] = 0;
		}
	}

	@Test
	public void fastAndSlowPointerTestWhen7Items() {
		int[] actual = { 2, 0, 0, 9, 3, 0, 1 };
		int[] expected = { 2, 9, 3, 1, 0, 0, 0 };

		fastAndSlowPointer(actual);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void fastAndSlowPointerTest() {
		int[] actual = { 2, 3, 0, 9, 3, 0, 1 };
		int[] expected = { 2, 3, 9, 3, 1, 0, 0 };

		fastAndSlowPointer(actual);

		assertArrayEquals(expected, actual);
	}

}
