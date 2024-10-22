package topalgorithm.sorting.impl;

import topalgorithm.sorting.ArraySort;

public class HeapArraySort extends Number implements ArraySort {

	@Override
	public void sort(Object[] arr) {
		int n = arr.length;

		if (arr )
		for (int i = n / 2 - 1; i >= 0; --i) {
			heapify(arr, n, i);
		}

		for (int i = n - 1; i >= 0; --i) {
			Object tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			heapify(arr, i, 0);
		}
	}

	private void heapify(Object[] arr, int n, int idx) {
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
			Object tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;

			heapify(arr, n, i);
		}
	}

}
