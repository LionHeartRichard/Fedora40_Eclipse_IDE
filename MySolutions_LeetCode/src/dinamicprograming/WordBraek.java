package dinamicprograming;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class WordBraek {
	// 28 - this count english letters

	public boolean wordBreakMySolution(String source, List<String> words) {
		int[] mapping = getMappingSource(source);
		Set<String> uniqueWords = getContainsUniqueWords(words, mapping);

		int n = source.length();
		boolean[] dp = new boolean[n + 1];

		dp[0] = true;
		int maxLen = getMaxLen(uniqueWords);

		for (int i = 1; i <= n; ++i) {
			int len = Math.max(0, i - maxLen - 1);
			for (int j = i - 1; j >= len; --j) {
				String swap = source.substring(j, i);
				if (dp[j] && uniqueWords.contains(swap)) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[n];
	}

	private Set<String> getContainsUniqueWords(List<String> words, int[] mapping) {
		Set<String> result = new HashSet<>();
		for (String word : words) {
			if (isContains(word, mapping))
				result.add(word);
		}
		return result;
	}

	private int getMaxLen(Set<String> uniqueWords) {
		int maxLen = 0;
		for (String current : uniqueWords) {
			maxLen = Math.max(maxLen, current.length());
		}
		return maxLen;
	}

	private boolean isContains(String word, int[] mapping) {
		for (char ch : word.toCharArray()) {
			if (mapping[ch - 'a'] == 0)
				return false;
		}
		return true;
	}

	private int[] getMappingSource(String source) {
		int[] mapping = new int[28];
		for (char ch : source.toCharArray()) {
			mapping[ch - 'a'] = 1;
		}
		return mapping;
	}

	// --------------------TOP------------------Solutions!!!!!!!!!!!!!!!

	public boolean wordBreak(String s, List<String> wordDict) {
		boolean visits[] = new boolean[s.length() + 1];

		return check(s, visits, 0, wordDict);
	}

	private boolean check(String a, boolean[] visits, int start, List<String> wordDict) {
		int len = a.length();

		if (visits[start])
			return false;
		if (len == start)
			return true;

		for (String word : wordDict) {
			int offset = start + word.length();
			if (offset <= len && !visits[offset] && a.startsWith(word, start)) {
				if (check(a, visits, offset, wordDict)) {
					return true;
				}
				visits[offset] = true;
			}
		}
		return false;
	}

	////////////////////////////// --------tests--------////////////////////////////////////

	@Test
	public void case1() {

		String s = "leetcode";
		List<String> wordDict = Arrays.asList("leet", "code");
		System.out.println("case1()");

		boolean actual = wordBreak(s, wordDict);
		assertTrue(actual);

		actual = wordBreakMySolution(s, wordDict);
		assertTrue(actual);
	}

	@Test
	public void case2() {
		String s = "applepenapplepenapple";
		List<String> wordDict = Arrays.asList("apple", "pen");
		System.out.println("case2()");

		boolean actual = wordBreak(s, wordDict);
		assertTrue(actual);

		actual = wordBreakMySolution(s, wordDict);
		assertTrue(actual);
	}

	@Test
	public void case3() {
		String s = "catsandog";
		System.out.println("case3()");
		List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

		boolean actual = wordBreak(s, wordDict);
		assertFalse(actual);

		actual = wordBreakMySolution(s, wordDict);
		assertFalse(actual);

	}

	@Test
	public void case4() {
		String s = "bb";
		System.out.println("case4()");
		List<String> wordDict = Arrays.asList("a", "b", "bbb", "bbbb");

		boolean actual = wordBreak(s, wordDict);
		assertTrue(actual);

		actual = wordBreakMySolution(s, wordDict);
		assertTrue(actual);
	}

	@Test
	public void case5() {
		String s = "a";
		System.out.println("case5()");
		List<String> wordDict = Arrays.asList("b");

		boolean actual = wordBreak(s, wordDict);
		assertFalse(actual);

		actual = wordBreakMySolution(s, wordDict);
		assertFalse(actual);
	}

	@Test
	public void case6() {
		String s = "aaaaaaa";
		System.out.println("case6()");
		List<String> wordDict = Arrays.asList("aaaa", "aa");

		boolean actual = wordBreak(s, wordDict);
		assertFalse(actual);

		actual = wordBreakMySolution(s, wordDict);
		assertFalse(actual);
	}

	@Test
	public void case7() {
		String s = "cars";
		System.out.println("case7()");
		List<String> wordDict = Arrays.asList("car", "ca", "rs");

		boolean actual = wordBreak(s, wordDict);
		assertTrue(actual);

		actual = wordBreakMySolution(s, wordDict);
		assertTrue(actual);
	}

	@Test
	public void case8() {
		String s = "dogs";
		System.out.println("case8()");
		List<String> wordDict = Arrays.asList("dog", "s", "gs");

		boolean actual = wordBreak(s, wordDict);
		assertTrue(actual);

		actual = wordBreakMySolution(s, wordDict);
		assertTrue(actual);
	}

}
