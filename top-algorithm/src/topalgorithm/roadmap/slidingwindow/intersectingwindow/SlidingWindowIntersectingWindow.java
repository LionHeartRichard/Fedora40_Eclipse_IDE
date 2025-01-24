package topalgorithm.roadmap.slidingwindow.intersectingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class SlidingWindowIntersectingWindow {

	/*
	 * Задача 1- Цепочка уникальных генов?! Найти самую длинную цепочку генов без
	 * повторов
	 * 
	 * Ввод: gen = "yxyabcxyx". Вывод: 5 Объяснение: "xyabc" или "yabcx"
	 */

	public int findUniqueGen(String gen) {
		int len = gen.length();
		int maxLenGen = 0;

		int quickIdx = 0;
		int idx = 0;

		char[] arrayCh = gen.toCharArray();
		Set<Character> uniqueGen = new HashSet<>();

		while (quickIdx < len) {
			if (uniqueGen.contains(arrayCh[quickIdx])) {
				uniqueGen.remove(arrayCh[idx++]);
			} else {
				uniqueGen.add(arrayCh[quickIdx++]);
				maxLenGen = Math.max(maxLenGen, uniqueGen.size());
			}
		}
		return maxLenGen;
	}

	// str consists of English letters, digits, symbols and spaces.
	public int lengthOfLongestSubstring(String str) {
		int maxlen = 0, quickIdx = 0, idx = 0;
		int[] mapping = new int[128]; // Array to keep track of last seen index of the particular ascii val character
		Arrays.fill(mapping, -1);

		for (quickIdx = 0; quickIdx < str.length(); ++quickIdx) {
			char ch = str.charAt(quickIdx);
			if (mapping[ch] >= idx) {
				idx = mapping[ch] + 1; // shifting val of left to last seen index + 1
			}
			mapping[ch] = quickIdx;
			maxlen = Math.max(maxlen, quickIdx - idx + 1);
		}
		return maxlen;
	}

	@Test
	public void findUniqueGenWhenInputNormalStrThenReturn5() {
		String gen = "yxyabcxyx";

		int expected = 5;
		int actual = findUniqueGen(gen);

		assertEquals(expected, actual);
	}

	@Test
	public void lengthOfLongestSubstringWhenNormalStrReturn5() {
		String gen = "yxyabcxyx";

		int expected = 5;
		int actual = lengthOfLongestSubstring(gen);

		assertEquals(expected, actual);
	}

	/*
	 * Задача 2 - Даны дни когда акции росли и падали (1/0) нам нужно заменить
	 * к-элементов на 1 таким образом чтобы получить максимальный отрезок дней когда
	 * акции росли
	 * 
	 */

}
