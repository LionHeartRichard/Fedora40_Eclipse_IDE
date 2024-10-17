package topalgorithm.sorting.impl;

import topalgorithm.sorting.ArraySort;

public class HeapArraySort<T extends Number & Comparable> implements ArraySort {

	@Override
	public void sort(T[] arr) {
		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; --i) {
			heapify(arr, n, i);
		}

		for (int i = n - 1; i >= 0; --i) {
			T tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			heapify(arr, i, 0);
		}
	}

	private void heapify(T[] arr, int n, int idx) {
		int i = idx;
		int left = i * 2 + 1;
		int right = left + 1;

		if (left < n && arr[left] > arr[i]) {
			i = left;
		}

		if (right < n && arr[right] > arr[i]) {
			i = right;
		}

		if (idx != i) {
			T tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;

			heapify(arr, n, i);
		}
	}

}
