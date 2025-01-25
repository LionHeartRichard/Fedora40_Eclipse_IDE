package topalgorithm.roadmap.sorting.impl;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class HeapSort {

	// time: O [n*log n]
	// memory: O [n*log n]

	public void sort(int[] arr) {
		int len = arr.length;

		for (int idx = len / 2 - 1; idx >= 0; --idx) {
			heapify(arr, len, idx);
		}

		for (int idx = len - 1; idx >= 0; --idx) {
			int swapItem = arr[0];
			arr[0] = arr[idx];
			arr[idx] = swapItem;

			heapify(arr, idx, 0);
		}
	}

	private void heapify(int[] arr, int len, int idx) {
		int currentIdx = idx;
		int leftIdx = currentIdx * 2 + 1;
		int rightIdx = leftIdx + 1;

		if (leftIdx < len && arr[leftIdx] > arr[currentIdx])
			currentIdx = leftIdx;
		if (rightIdx < len && arr[rightIdx] > arr[currentIdx])
			currentIdx = rightIdx;

		if (idx != currentIdx) {
			int swapItem = arr[idx];
			arr[idx] = arr[currentIdx];
			arr[currentIdx] = swapItem;

			heapify(arr, len, currentIdx);
		}
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
