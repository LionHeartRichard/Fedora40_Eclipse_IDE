package competition;

public class Competition {

	int[] scores;

	public Competition(int participiantCount) {
		scores = new int[participiantCount];
	}

	public void like(int participiantId) {
		changeScores(participiantId, 1);
	}

	public void dislike(int participiantId) {
		changeScores(participiantId, -1);
	}

	private void changeScores(int idx, int score) {
		scores[idx] += score;
	}

	public int[] getBestWorks(int countWork) {
		if (scores.length < 1)
			return null;
		heapReversSort(scores);
		if (scores.length <= countWork)
			return scores;
		int[] result = new int[countWork];
		for (int i = 0; i < countWork; ++i)
			result[i] = scores[i];
		return result;
	}

	public void heapReversSort(int[] array) {
		int len = array.length;
		for (int idx = len / 2 - 1; idx >= 0; --idx) {
			heapifyRevers(array, len, idx);
		}

		for (int idx = len - 1; idx >= 0; --idx) {
			int swapItem = array[0];
			array[0] = array[idx];
			array[idx] = swapItem;

			heapifyRevers(array, idx, 0);
		}
	}

	private void heapifyRevers(int[] array, int len, int idx) {
		int currentIdx = idx;
		int leftIdx = currentIdx * 2 + 1;
		int rightIdx = leftIdx + 1;

		if (leftIdx < len && array[currentIdx] > array[leftIdx])
			currentIdx = leftIdx;
		if (rightIdx < len && array[currentIdx] > array[rightIdx])
			currentIdx = rightIdx;

		if (idx != currentIdx) {
			int swapItem = array[currentIdx];
			array[currentIdx] = array[idx];
			array[idx] = swapItem;

			heapifyRevers(array, len, currentIdx);
		}
	}

}
