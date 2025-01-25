package topalgorithm.roadmap.sorting.impl;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class QuickSort {

	public void sort(int[] arr) {
		int len = arr.length;
		int begin = 0;
		int end = len - 1;
		quickSort(arr, begin, end);
	}

	private void quickSort(int[] arr, int begin, int end) {
		if (begin < end) {
			int partitionIdx = getPartitionIdx(arr, begin, end);
			quickSort(arr, begin, partitionIdx - 1);
			quickSort(arr, partitionIdx + 1, end);
		}
	}

	private int getPartitionIdx(int[] arr, int begin, int end) {
		int pivotItem = arr[end];
		int currentIdx = begin;

		for (int idx = begin; idx <= end; ++idx) {
			if (arr[idx] < pivotItem) {
				int swapItem = arr[currentIdx];
				arr[currentIdx++] = arr[idx];
				arr[idx] = swapItem;
			}
		}

		int swapItem = arr[currentIdx];
		arr[currentIdx] = arr[end];
		arr[end] = swapItem;
		return currentIdx;
	}

	@Test
	public void sortArrayIntTest() {
		int[] actual = { 6, -9, 10, 97, 0, 56, -1, 30, 10 };
		int[] expected = Arrays.copyOf(actual, actual.length);
		Arrays.sort(expected);

		sort(actual);

		assertArrayEquals(expected, actual);
	}

}
