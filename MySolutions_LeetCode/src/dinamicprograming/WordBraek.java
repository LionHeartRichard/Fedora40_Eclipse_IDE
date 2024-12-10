package dinamicprograming;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WordBraek {

	public boolean wordBreak(String s, List<String> wordDict) {
		int[] mappingStr = new int[28];
		int[] mapping = new int[28];
		for (char ch : s.toCharArray()) {
			++mappingStr[ch - 'a'];
		}
		for (String word : wordDict) {
			for (char ch : word.toCharArray()) {
				++mapping[ch - 'a'];
			}
		}

		for (int i = 0; i < 28; ++i) {
			int a = mappingStr[i];
			int b = mapping[i];
			if (a > 0 && b < 0)
				return false;
		}

		return true;
	}

	@Test
	public void case1() {
		String s = "leetcode";
		List<String> wordDict = Arrays.asList("leet", "code");

		boolean actual = wordBreak(s, wordDict);

		assertTrue(actual);
	}

	@Test
	public void case2() {
		String s = "applepenapple";
		List<String> wordDict = Arrays.asList("apple", "pen");

		boolean actual = wordBreak(s, wordDict);

		assertTrue(actual);
	}

	@Test
	public void case3() {
		String s = "catsandog";
		List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

		boolean actual = wordBreak(s, wordDict);

		assertFalse(actual);
	}

	@Test
	public void case4() {
		String s = "bb";
		List<String> wordDict = Arrays.asList("a", "b", "bbb", "bbbb");

		boolean actual = wordBreak(s, wordDict);

		assertTrue(actual);
	}
}
