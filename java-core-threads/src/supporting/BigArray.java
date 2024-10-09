package supporting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class BigArray {

	private static final int LENGTH_ARRAY = 1000000;

	public static void main(String[] args) throws IOException {
		Random random = new Random();
		int[] array = new int[LENGTH_ARRAY];
		for (int i = 0; i < array.length; ++i) {
			array[i] = random.nextInt(-1000, 1000);
		}
		String fileName = "/home/kerrigan_kein/eclipse-workspace/java-core-threads/src/resorces/bigArray.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		writer.append(Arrays.toString(array));
		writer.close();
	}

	public int[] getBigArrays() {
		int[] array = new int[LENGTH_ARRAY];
		Random random = new Random();
		for (int i = 0; i < array.length; ++i) {
			array[i] = random.nextInt(-1000, 1000);
		}
		return array;
	}

}
