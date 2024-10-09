package timsorted;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import supporting.BigArray;

public class TimeSorted {

	private static final int THRESHOLD = 32;

	public void timSorted(int[] array) {
		int n = array.length;
		for (int i = 0; i < n; i += THRESHOLD) {
			int lengthSorted = Math.min(n, i + THRESHOLD);
			insertionSorted(array, i, lengthSorted);
		}

		for (int size = THRESHOLD; size < n; size *= 2) {
			for (int begin = 0; begin < n; begin += size * 2) {
				int mid = begin + size - 1;
				int end = Math.min(n - 1, begin + size * 2 - 1);

				if (mid < end) {
					merge(array, begin, mid, end);
				}
			}
		}
	}

	private void insertionSorted(int[] array, int begin, int n) {
		int i, j, temp;
		for (i = begin + 1; i < n; ++i) {
			j = i - 1;
			temp = array[i];
			while (j >= begin && array[j] > temp) {
				array[j + 1] = array[j--];
			}
			array[++j] = temp;
		}
	}

	private void merge(int[] array, int begin, int mid, int end) {
		int i, j, k;
		int n1 = mid - begin + 1;
		int n2 = end - mid;

		int[] left = new int[n1];
		int[] right = new int[n2];

		for (i = 0; i < n1; ++i) {
			left[i] = array[i + begin];
		}

		for (j = 0; j < n2; ++j) {
			right[j] = array[j + mid + 1];
		}

		i = 0;
		j = 0;
		k = begin;

		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				array[k++] = left[i++];
			} else {
				array[k++] = right[j++];
			}
		}

		while (i < n1) {
			array[k++] = left[i++];
		}
		while (j < n2) {
			array[k++] = right[j++];
		}
	}

	@Test
	public void test1() {
		int[] actual = new int[] { 12, 2, 4, 5, 23, 44, 55, 23, 11, 0, -2, -4, -23, 34, 45, 0, 23, 34, 45, 1, 2, -5, 39,
				19, -44, -30, 30, 99, 100, -100, 22, -22, 44, 99, 9, 22, 40, 29, 47, 88, -88, 23 };
		int[] expected = Arrays.copyOf(actual, actual.length);
		Arrays.sort(expected);

		timSorted(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test2() {
		int[] actual = { 5, 1, 6, 2, 3, 4 };
		int[] expected = { 1, 2, 3, 4, 5, 6 };
		timSorted(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test3() {
		int[] actual = { -58, 12, 6, -25, 63, 4, 19, 0, 8, -3, 894, 0, -234, 0, 457, 457, 34987, -7, 94, 0, 0, 89, -45,
				67, 77, -55, 45, 897, -3, 5, -5689, 34, 34, 90, 89, 45, 45, 34, 23, 12, 12, 12, 57, 90, 456, -786,
				-9040, 459, 43758, 45, 9, 12, 2, 4, 5, 23, 44, 55, 23, 11, 0, -2, -4, -23, 34, 45, 0, 23, 34, 45, 1, 2,
				-5, 39, 19, -44, -30, 30, 99, 100, -100, 22, -22, 44, 99, 9, 22, 40, 29, 47, 88, -88, 23, 5, 1, 6, 2, 3,
				4, 5, 1, 6, 2, 3, 4, 5, 1, 6, 2, 3, 4, 5, 1, 6, 2, 3, 4, 5, 1, 6, 2, 3, 4, 5, 1, 6, 2, 3, 4 };
		int[] expected = Arrays.copyOf(actual, actual.length);
		Arrays.sort(expected);
		timSorted(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testBigArray() {
		BigArray supportObject = new BigArray();
		int[] array = supportObject.getBigArrays();
		timSorted(array);
		int[] expected = Arrays.copyOf(array, array.length);
		Arrays.sort(expected);
		assertArrayEquals(expected, array);
	}

}
