package topalgorithm.roadmap.slidingwindow;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Вам дана строка s и массив строк-слов. Все строки слов имеют одинаковую длину.
 * Объединенная строка — это строка, содержащая ровно все строки любой перестановки объединенных слов. 
 */

public class TopSolutionSlidingWindow {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new AbstractList<Integer>() {
			List<Integer> result = null;

			public Integer get(int index) {
				if (result == null) {
					result = mapping(s, words);
				}
				return result.get(index);
			}

			public int size() {
				if (result == null) {
					result = mapping(s, words);
				}
				return result.size();
			}
		};
		return res;
	}

	private List<Integer> mapping(String s, String[] words) {

		Map<String, List<Integer>> map = new HashMap<>();
		int n = words.length;
		int lengthSubS = words[0].length() * n;
		boolean[] beginCh = new boolean[26];
		boolean[] endCh = new boolean[26];

		for (int i = 0; i < words.length; i++) {
			String w = words[i];
			beginCh[w.charAt(0) - 'a'] = true;
			endCh[w.charAt(w.length() - 1) - 'a'] = true;
			map.putIfAbsent(w, new ArrayList<>());
			map.get(w).add(i);
		}

		List<Integer> currentRes = new ArrayList<>();

		for (int i = 0; i <= s.length() - lengthSubS; i++) {

			if (beginCh[s.charAt(i) - 'a'] && endCh[s.charAt(i + lengthSubS - 1) - 'a']) {

				boolean contains = consider(i, i + lengthSubS, s, map, n);

				if (contains) {
					currentRes.add(i);
				}
			}
		}

		return currentRes;
	}

	private boolean consider(int begin, int end, String s, Map<String, List<Integer>> words, int size) {

		if (words.size() == 1) {
			String value = concat(words.keySet().iterator().next(), size);
			return value.equals(s.substring(begin, end));
		}

		int len = (end - begin) / size;
		boolean[] visited = new boolean[size];

		for (int i = begin; i < end; i += len) {

			String candidate = s.substring(i, i + len);

			if (words.containsKey(candidate)) {
				int idx = getUnvisited(words.get(candidate), visited);
				if (idx >= 0) {
					visited[idx] = true;
					continue;
				}
			}

			return false;
		}

		return true;
	}

	private String concat(String key, int n) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			builder.append(key);
		}
		return builder.toString();
	}

	private int getUnvisited(List<Integer> indexList, boolean[] visited) {
		for (int i = 0; i < indexList.size(); ++i) {
			if (!visited[indexList.get(i)]) {
				return indexList.get(i);
			}
		}
		return -1;
	}

}
