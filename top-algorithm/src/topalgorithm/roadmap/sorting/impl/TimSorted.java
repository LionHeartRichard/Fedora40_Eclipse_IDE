package topalgorithm.roadmap.sorting.impl;

public class TimSorted {

	// time: O [n*log n]
	// memory: O [n*log n]

	private static int THRESHOLD = 32;

	public void sort(int[] arr) {
		int len = arr.length;
		for (int beginIdx = 0; beginIdx < len; beginIdx += THRESHOLD) {
			int endLen = Math.min(len, beginIdx + THRESHOLD);
			insertionSort(arr, beginIdx, endLen);
		}

		for (int sizeSubarray = THRESHOLD; sizeSubarray < len; sizeSubarray *= 2) {
			for (int beginIdx = 0; beginIdx < len; beginIdx += sizeSubarray * 2) {
				int midIdx = beginIdx + sizeSubarray - 1;
				int endIdx = Math.min(midIdx + sizeSubarray, len - 1);

				if (midIdx < endIdx) {
					merge(arr, beginIdx, midIdx, endIdx);
				}
			}
		}
	}

	private void insertionSort(int[] arr, int beginIdx, int endLen) {
		int pivotItem, fastIdx, slowIdx;
		for (slowIdx = beginIdx + 1; slowIdx < endLen; ++slowIdx) {
			pivotItem = arr[slowIdx];
			fastIdx = slowIdx - 1;

			while (fastIdx >= beginIdx && pivotItem < arr[fastIdx]) {
				arr[fastIdx + 1] = arr[fastIdx--];
			}
			arr[++fastIdx] = pivotItem;
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
}
