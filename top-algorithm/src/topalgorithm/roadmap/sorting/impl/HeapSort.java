package topalgorithm.roadmap.sorting.impl;

import topalgorithm.sorting.ArraySort;

public class HeapSort implements ArraySort {

	@Override
	public void sort(int[] arr) {
		int len = arr.length;
		for (int idx = len / 2; idx >= 0; --idx) {
			heapify(arr, len, idx);
		}
	}

	private void heapify(int[] arr, int len, int idx) {
		int currentIdx = idx;
		int leftIdx = currentIdx * 2;
		int rightIdx = leftIdx + 1;
		if (leftIdx < len && arr[leftIdx] > arr[currentIdx])
			currentIdx = leftIdx;
		if (rightIdx < len && arr[rightIdx] > arr[currentIdx])
			currentIdx = rightIdx;
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
