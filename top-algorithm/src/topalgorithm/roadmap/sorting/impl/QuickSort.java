package topalgorithm.roadmap.sorting.impl;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import topalgorithm.roadmap.sorting.ArraySort;

public class QuickSort implements ArraySort {

	@Override
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
				int swap = arr[currentIdx];
				arr[currentIdx++] = arr[idx];
				arr[idx] = swap;
			}
		}

		int swap = arr[currentIdx];
		arr[currentIdx] = arr[end];
		arr[end] = swap;
		return currentIdx;
	}

	@Override
	public void sort(long[] arr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sort(double[] arr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sort(float[] arr) {
		// TODO Auto-generated method stub

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