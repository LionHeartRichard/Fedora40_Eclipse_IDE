package topalgorithm.roadmap.sorting.impl;

import topalgorithm.roadmap.sorting.ArraySort;

public class HeapSort implements ArraySort {
	
	//time: O [N log N]
	//memory: O [N log N]

	@Override
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

}
