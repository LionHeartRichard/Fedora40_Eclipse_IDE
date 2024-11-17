package topalgorithm.roadmap.binarysearch;

import java.util.Random;
import java.util.Scanner;

public class ThisBinarySearch {

	private static final int FIND_NUMBER = 30;
	private static final int THRESHOLD = 1000;

	public static void main(String[] args) {
		int[] array = { 1, 2, 5, 8, 12, 13, 20, 22, 24, 30, 32 };

		System.out.println("Индекс искомого элемента: " + findBinary(array, FIND_NUMBER));
		System.out.println();

		System.out.println("Загадываю случайное число от 1 до " + THRESHOLD);
		guessingGame(THRESHOLD);

	}

	public static int findBinary(int[] array, int findItem) {
		int lowIdx = 0;
		int highIdx = array.length;
		while (lowIdx <= highIdx) {
			int mid = lowIdx + ((highIdx - lowIdx) / 2);
			if (array[mid] == findItem) {
				return mid;
			}
			if (array[mid] < findItem) {
				lowIdx = mid + 1;
			} else {
				highIdx = mid - 1;
			}
		}
		return -1;
	}

	public static void guessingGame(int threshold) {
		Random random = new Random();
		int target = random.nextInt(threshold) + 1;
		System.out.println("Я загадал число от 1 до " + threshold + ". Попробуйте угадать!");

		Scanner scanner = new Scanner(System.in);
		int userGuess = -1;
		while (userGuess != target) {
			userGuess = scanner.nextInt();
			if (userGuess < target) {
				System.out.println("Ваше число меньше");
			} else if (userGuess > target) {
				System.out.println("Ваше число больше");
			}
		}
		System.out.println("Правильный ответ");
		scanner.close();
	}
}
