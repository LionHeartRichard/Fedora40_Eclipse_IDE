package dinamicprograming;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class WordBraek {

	private String[] cach;
	private Set<String> setCach;

	public boolean wordBreak(String source, List<String> words) {
		cach = new String[20];
		setCach = new HashSet<>(20);
		source = recursionWithCach(source, words, 0);
		System.out.println(Arrays.toString(cach));
		System.out.println("source = " + source);
		setCach.forEach(v -> System.out.print(false));
		return source.isEmpty() ? true : false;
	}

	private String recursionWithCach(String source, List<String> words, int n) {
		if (source.length() == 0 || n >= words.size()) {
			return source;
		}
		if (cach[n] == null) {
			String word = words.get(n);
			int idx = source.indexOf(word);
			if (idx != -1) {
				source = source.substring(0, idx) + source.substring(idx + word.length());
				setCach.add(source);
			}
			cach[n] = recursionWithCach(source, words, n + 1);
		}
		return cach[n];
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

	@Test
	public void case5() {
		String s = "a";
		List<String> wordDict = Arrays.asList("b");

		boolean actual = wordBreak(s, wordDict);

		assertFalse(actual);
	}

	@Test
	public void case6() {
		String s = "aaaaaaa";
		List<String> wordDict = Arrays.asList("aaaa", "aa");

		boolean actual = wordBreak(s, wordDict);

		assertFalse(actual);
	}
}
