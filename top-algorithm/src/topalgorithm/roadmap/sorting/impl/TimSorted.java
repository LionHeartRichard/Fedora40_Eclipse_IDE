package topalgorithm.roadmap.sorting.impl;

import topalgorithm.roadmap.sorting.ArraySort;

public class TimSorted implements ArraySort {

	private static int THRESHOLD = 32;

	@Override
	public void sort(int[] arr) {
		int len = arr.length;
		for (int beginIdx = 0; beginIdx < len; beginIdx += THRESHOLD) {
			int lengthEnd = Math.min(len, beginIdx + THRESHOLD);
			insertionSort(arr, beginIdx, lengthEnd);
		}

		for (int sizeSubarray = THRESHOLD; sizeSubarray < len; sizeSubarray *= 2) {
			for (int beginIdx = 0; beginIdx < len; beginIdx += sizeSubarray * 2) {

				int midIdx = beginIdx + sizeSubarray - 1;
				int endIdx = Math.min(beginIdx + sizeSubarray * 2 - 1, len - 1);

				if (midIdx < endIdx) {
					merge(arr, beginIdx, midIdx, endIdx);
				}
			}
		}
	}

	private void insertionSort(int[] arr, int beginIdx, int lengthEnd) {
		int currentIdx, swapIdx, tempElement;

		for (currentIdx = beginIdx + 1; currentIdx < lengthEnd; ++currentIdx) {

			tempElement = arr[currentIdx];
			swapIdx = currentIdx - 1;

			while (swapIdx >= beginIdx && arr[swapIdx] > tempElement) {
				arr[swapIdx + 1] = arr[swapIdx--];
			}
			arr[++swapIdx] = tempElement;
		}
	}

	private void merge(int[] arr, int beginIdx, int midIdx, int endIdx) {

		int leftIdx, rightIdx, currentIdx;

		int lenLeft = midIdx - beginIdx + 1;
		int lenRight = endIdx - midIdx;

		int[] arrayLeft = new int[lenLeft];
		int[] arrayRight = new int[lenRight];

		for (leftIdx = 0; leftIdx < lenLeft; ++leftIdx) {
			arrayLeft[leftIdx] = arr[leftIdx + beginIdx];
		}

		for (rightIdx = 0; rightIdx < lenRight; ++rightIdx) {
			arrayRight[rightIdx] = arr[rightIdx + midIdx + 1];
		}

		currentIdx = beginIdx;
		leftIdx = 0;
		rightIdx = 0;

		while (leftIdx < lenLeft && rightIdx < lenRight) {
			if (arrayLeft[leftIdx] <= arrayRight[rightIdx]) {
				arr[currentIdx++] = arrayLeft[leftIdx++];
			} else {
				arr[currentIdx++] = arrayRight[rightIdx++];
			}
		}

		while (leftIdx < lenLeft) {
			arr[currentIdx++] = arrayLeft[leftIdx++];
		}

		while (rightIdx < lenRight) {
			arr[currentIdx++] = arrayRight[rightIdx++];
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
