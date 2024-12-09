package solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {

	private static final String DATA_SOURCE = "input2.txt"; // "input.txt";
	private static int k;
	private static Set<Integer> cash = new HashSet<>();

	public static int[] readStr() {
		try (BufferedReader reader = new BufferedReader(new FileReader(DATA_SOURCE))) {
			String source = reader.readLine();
			String[] row1 = source.split(" ");
			int n = Integer.parseInt(row1[0]);
			k = Integer.parseInt(row1[1]);
			int[] array = new int[n];
			String[] row2 = reader.readLine().split(" ");
			for (int i = 0; i < n; ++i) {
				array[i] = Integer.parseInt(row2[i]);
			}
			return array;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws IOException {
		int[] arr = readStr();
		if (arr.length == 1) {
			writingResult(1 + "");
		}
		int count = getCount(arr);
		System.out.println(count);
		writingResult(count + "");
	}

	private static int getCount(int[] arr) {
		int beginIdx = -1;
		int len = arr.length;
		for (int idx = 0; idx < len; ++idx) {
			if (arr[idx] == k) {
				beginIdx = idx;
				break;
			}
		}

		if (beginIdx == -1)
			return 0;

		int left = beginIdx;
		int right = beginIdx;
		int count = bactracking(arr, left, right, k, 0) + 1;
		return count;
	}

	private static int bactracking(int[] arr, int left, int right, int sum, int count) {
		if (left < 0 && right >= arr.length)
			return 0;
		int range = right - left;
		if (range != 0 && sum / range == k)
			++count;
		if (!cash.contains(count)) {
			if (left - 1 >= 0) {
				count = bactracking(arr, --left, right, sum + arr[left], count);
				cash.add(count);
			}
			if (right + 1 < arr.length) {
				count = bactracking(arr, left, ++right, sum + arr[right], count);
				cash.add(count);
			}
		}
		return count;
	}

	private static void writingResult(String result) {
		try (FileWriter writer = new FileWriter("output.txt")) {
			writer.write(result);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
