package arrayandstring;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/*
 *  Найти H-Index исследователя,
 */

public class HIndex {

	// алгоритм похож на алгоритм ключ значение значение ключ - при использовании
	// хэш таблиц
	// только тут мы меняем значение на индекс!!!
	// можем применять всегда - когда ответ не может превышать длину массива!!!
	public int hIndex(int[] citations) {

		// потенциально самый большой HIndex будет равен количеству пубикаций
		int len = citations.length;
		// создаем кэш потенциальных ответов
		int[] cache = new int[len + 1];
		for (int countCitation : citations) {
			// кэшируем возможные ответы
			// считаем количество одинаково цитируемых работ
			cache[Math.min(len, countCitation)]++;
		}

		int countWorks = 0;
		// потенциально в конце может быть наибольший из возможных hIdx
		// классическая ситуация для этого паттерна
		for (int hIdx = len; hIdx >= 0; --hIdx) {
			countWorks += cache[hIdx];
			// если мы получили достаточное количество работ то это и есть искомый hIdx
			if (countWorks >= hIdx) {
				return hIdx;
			}
		}
		return 0;
	}

	@Test
	public void case1() {
		int[] citations = { 3, 0, 6, 1, 5 };
		// в данном случае три исследовательские работы были процетированы

		int expected = 3;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] citations = { 1, 3, 1 };

		int expected = 1;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case4() {
		int[] citations = { 100 };

		int expected = 1;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case5() {
		int[] citations = { 0, 1 };

		int expected = 1;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case6() {
		int[] citations = { 11, 15 };

		int expected = 2;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}

	@Test
	public void case7() {
		int[] citations = { 1, 2, 2 };

		int expected = 2;
		int actual = hIndex(citations);

		assertEquals(expected, actual);
	}
}
