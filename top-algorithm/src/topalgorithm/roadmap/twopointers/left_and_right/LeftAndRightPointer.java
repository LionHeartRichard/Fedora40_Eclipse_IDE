package topalgorithm.roadmap.twopointers.left_and_right;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LeftAndRightPointer {

	/*
	 * левый и правый указатель является сачтным случаем паттерна двух указателей
	 * 
	 * Пример использования: Дан массив целых чисел, отсортированный в неубывающем
	 * порядке. Вернуть массив квадратов каждого числа, отсортированный в неубыающем
	 * порядке
	 */

	public int[] leftAndRightPointerForSolutionSquareOfTheNumber(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int idx = right;
		int[] result = new int[idx + 1];
		while (left < right && idx >= 0) {
			int leftValue = arr[left] * arr[left];
			int rightValue = arr[right] * arr[right];
			if (leftValue >= rightValue) {
				result[idx--] = leftValue;
				++left;
			} else {
				result[idx--] = rightValue;
				--right;
			}
		}
		return result;
	}

	@Test
	public void leftAndRightPointerTest5Items() {
		int[] actual = { -4, -1, 0, 3, 10 };
		int[] expected = { 0, 1, 9, 16, 100 };

		actual = leftAndRightPointerForSolutionSquareOfTheNumber(actual);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void leftAndRightPointerTest10Items() {
		int[] actual = { -4, -1, 0, 3, 10, -4, -1, 0, 3, 10 };
		Arrays.sort(actual);
		int[] expected = { 0, 0, 1, 1, 9, 9, 16, 16, 100, 100 };

		actual = leftAndRightPointerForSolutionSquareOfTheNumber(actual);

		assertArrayEquals(expected, actual);
	}

	/*
	 * Классическая задача на поиск в массиве чисел которые в сумме дают искомое
	 * число сдесь тоже если массив отсортирован то применяем этот паттерн
	 */

	public int[] getTargetSumWithTwoNum(int[] arr, int targetSum) {
		int len = arr.length;
		int left = 0;
		int right = len - 1;

		while (left < right) {
			int currentSum = arr[left] + arr[right];
			if (currentSum == targetSum)
				return new int[] { arr[left], arr[right] };
			if (currentSum > targetSum) {
				--right;
			} else {
				++left;
			}
		}
		return new int[] {};
	}

	@Test
	public void getTargetSumWithTwoNumTest() {
		int[] arr = { -30, -15, -5, -2, 0, 30, 60, 90, 100 };
		int target = 55;
		int[] expected = { -5, 60 };

		int[] actual = getTargetSumWithTwoNum(arr, target);

		assertArrayEquals(expected, actual);
	}
}
