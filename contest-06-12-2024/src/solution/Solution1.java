package solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {

	private static final String DATA_SOURCE = "input1.txt"; // "input.txt";

	private static int LEN;
	private static int ROWS;
	private static int COLUMNS;

	public static StringBuilder[] readStr() {
		try (BufferedReader reader = new BufferedReader(new FileReader(DATA_SOURCE))) {
			String source = reader.readLine();
			String[] rowsAndColumns = source.split(" ");
			ROWS = Integer.parseInt(rowsAndColumns[0]);
			COLUMNS = Integer.parseInt(rowsAndColumns[1]);
			LEN = COLUMNS + ROWS;
			StringBuilder[] builder = new StringBuilder[LEN];
			char[][] chars = new char[ROWS][COLUMNS];
			for (int i = 0; i < ROWS; ++i) {
				builder[i] = new StringBuilder();
				String tmp = reader.readLine();
				builder[i].append(tmp);
				int j = 0;
				for (char ch : tmp.toCharArray()) {
					chars[i][j++] = ch;
				}
			}

			for (int idx = 0; idx < COLUMNS; ++idx) {
				builder[idx + ROWS] = new StringBuilder();
				for (int i = 0; i < ROWS; ++i) {
					builder[idx + ROWS].append(chars[i][idx]);
				}
			}
			return builder;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws IOException {
		StringBuilder[] builder = readStr();
		String result = SortWords(builder);
		writingResult(result);

	}

	private static String SortWords(StringBuilder[] builder) {
		List<String> swap = new ArrayList<>();
		int idx = 0;
		for (idx = 0; idx < builder.length; ++idx) {
			String curStr = builder[idx].toString();
			if (curStr.indexOf("#") != -1) {
				String[] tmp = curStr.split("#");
				for (String s : tmp) {
					swap.add(s);
				}
			} else {
				swap.add(curStr);
			}
		}

		Collections.sort(swap);
		for (String s : swap) {
			if (s.length() > 1)
				return s;
		}
		return null;
	}

	private static void writingResult(String result) {
		try (FileWriter writer = new FileWriter("output1.txt")) {
			writer.write(result);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
