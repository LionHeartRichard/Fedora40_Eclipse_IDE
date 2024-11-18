package ru.yandex.practicum;

class Practicum {
	public static void main(String[] args) {
		int[] array1 = new int[] { 1, 3, 4, 6, 8 };
		int[] array2 = new int[] { 1, 2, 3, 8, 9 };
		int[] resultArray = merge(array1, array2);

		for (int e : resultArray) {
			System.out.print(e + ", ");
		}
	}

	private static int[] merge(int[] arrayLeft, int[] arrayRight) {

		int lenLeft = arrayLeft.length;
		int lenRight = arrayRight.length;
		int[] result = new int[lenLeft + lenRight];

		int leftIdx = 0;
		int rightIdx = 0;
		int idx = 0;

		while (leftIdx < lenLeft && rightIdx < lenRight) {
			if (arrayLeft[leftIdx] <= arrayRight[rightIdx]) {
				result[idx++] = arrayLeft[leftIdx++];
			} else {
				result[idx++] = arrayRight[rightIdx++];
			}
		}

		while (leftIdx < lenLeft) {
			result[idx++] = arrayLeft[leftIdx++];
		}

		while (rightIdx < lenRight) {
			result[idx++] = arrayRight[rightIdx++];
		}

		return result;
	}
}
