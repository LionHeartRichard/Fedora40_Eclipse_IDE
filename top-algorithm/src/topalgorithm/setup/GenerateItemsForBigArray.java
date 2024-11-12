package topalgorithm.setup;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateItemsForBigArray {

	private static String FILE_NAME = "/home/kerrigan_kein/Documents/bigArray.txt";
	private static int LEN_ARRAY = 10_000_000;

	public static void main(String[] args) throws IOException {
		Random random = new Random();
		FileWriter writer = new FileWriter(FILE_NAME);

		for (int idx = 0; idx < LEN_ARRAY; ++idx) {
			int item = random.nextInt(100);
			writer.write(item + " ");
		}
		writer.close();
	}

	public static String getFileName() {
		return FILE_NAME;
	}

	public static int getLengthArray() {
		return LEN_ARRAY;
	}
}
