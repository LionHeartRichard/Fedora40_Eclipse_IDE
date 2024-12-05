package topalgorithm.roadmap.slidingwindow.notintersectingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SlidingWindowNotIntersectingWindows {
	/*
	 * Task-1 Дан массив уникальных чисел, отсортированный по возрастанию далее
	 * смотри пример ввода/вывода Пример задачи Ввод: counter =
	 * [1,2,3,4,5,8,10,15,16,20]; Вывод: ["1->5","8","10","15->16","20"];
	 */

	public List<String> formatCounter(int[] counter) {
		int idx = 0;
		int quickIdx = 0;
		int len = counter.length;
		List<String> result = new ArrayList<>();
		while (idx < len) {
			while (quickIdx + 1 < len && counter[quickIdx] == counter[quickIdx + 1] - 1) {
				++quickIdx;
			}
			int sizeSlidingWindow = quickIdx - idx + 1;

			if (sizeSlidingWindow > 1) {
				result.add(counter[idx] + "=>" + counter[quickIdx]);
			} else {
				result.add(counter[idx] + "");
			}
			++quickIdx;
			idx = quickIdx;
		}
		return result;
	}

	@Test
	public void testFormatCounter() {
		int[] counter = { 1, 2, 3, 4, 5, 8, 10, 15, 16, 20 };
		StringBuilder builder = new StringBuilder();

		List<String> actual = formatCounter(counter);
		actual.forEach(v -> builder.append(v + ","));
		String expected = "1=>5,8,10,15=>16,20,";

		assertEquals(expected, builder.toString());
	}

	/*
	 * Сжать строку!!! Task-2 Input: String="xxyzzz"; Output = "x,2,y,z,3"; Variant
	 * 2__________ Input: String = "yyxxxxxxxxxxxxyy"; Output String =
	 * "y,2,x,1,2,y,2"
	 */

	public String compress(String str) {
		StringBuilder result = new StringBuilder();
		int idx = 0;
		int quickIdx = 0;
		int len = str.length();
		char[] arr = str.toCharArray();
		while (idx < len) {
			while (quickIdx + 1 < len && arr[quickIdx] == arr[quickIdx + 1]) {
				++quickIdx;
			}
			int sizeSlidingWindow = quickIdx - idx + 1;
			result.append(arr[quickIdx] + ",");
			if (sizeSlidingWindow > 1) {
				result.append(sizeSlidingWindow + ",");
			}
			++quickIdx;
			idx = quickIdx;
		}
		return result.toString();
	}

	public List<Character> compress(List<Character> chars) {
		int idx = 0;
		int quickIdx = 0;
		int len = chars.size();
		List<Character> result = new ArrayList<>();

		while (idx < len) {
			while (quickIdx + 1 < len && chars.get(quickIdx).equals(chars.get(quickIdx + 1))) {
				++quickIdx;
			}
			int windowSize = quickIdx - idx + 1;
			result.add(chars.get(quickIdx));
			if (windowSize > 1) {
				for (char ch : String.valueOf(windowSize).toCharArray()) {
					result.add(ch);
				}
			}
			++quickIdx;
			idx = quickIdx;
		}
		return result;
	}

	// _________________________Test______forStr
	@Test
	public void testCompressWhenSmollLineThenReturnStr() {
		String str = "abc";

		String expected = "a,b,c,";
		String actual = compress(str);

		assertEquals(expected, actual);
	}

	@Test
	public void testCompressThenReturnStr() {
		String str = "yyxxxxxxxxxxxxyy";

		String expected = "y,2,x,12,y,2,";
		String actual = compress(str);

		assertEquals(expected, actual);
	}

	@Test
	public void testCompressWhenLongStrThenReturnStr() {
		String str = "aaaaaaaaaadddddddddddddddkkkkkkkkkklllllllllqqqqqqqqqAAAAAaaaaajjjjjjjjjjj";

		String expected = "a,10,d,15,k,10,l,9,q,9,A,5,a,5,j,11,";
		String actual = compress(str);

		assertEquals(expected, actual);
	}
	// _________________________Tests_____forList________________________________

	@Test
	public void testCompressThenReturnList() {
		String str = "yyxxxxxxxxxxxxyy";
		List<Character> chars = new ArrayList<>();
		for (char ch : str.toCharArray()) {
			chars.add(ch);
		}

		String expected = "y,2,x,1,2,y,2,";
		List<Character> actualList = compress(chars);
		StringBuilder actual = new StringBuilder();
		actualList.forEach(v -> actual.append(v + ","));

		assertEquals(expected, actual.toString());
	}

	@Test
	public void testCompressWhenLongStrThenReturnList() {
		String str = "aaaaaaaaaadddddddddddddddkkkkkkkkkklllllllllqqqqqqqqqAAAAAaaaaajjjjjjjjjjj";
		List<Character> chars = new ArrayList<>();
		for (char ch : str.toCharArray()) {
			chars.add(ch);
		}

		String expected = "a,1,0,d,1,5,k,1,0,l,9,q,9,A,5,a,5,j,1,1,";
		List<Character> actualList = compress(chars);
		StringBuilder actual = new StringBuilder();
		actualList.forEach(v -> actual.append(v + ","));

		assertEquals(expected, actual.toString());
	}

	@Test
	public void testCompressWhenSmollLineThenReturnList() {
		String str = "abc";
		List<Character> chars = new ArrayList<>();
		for (char ch : str.toCharArray()) {
			chars.add(ch);
		}

		String expected = "a,b,c,";
		List<Character> actualList = compress(chars);
		StringBuilder actual = new StringBuilder();
		actualList.forEach(v -> actual.append(v + ","));

		assertEquals(expected, actual.toString());
	}
}
