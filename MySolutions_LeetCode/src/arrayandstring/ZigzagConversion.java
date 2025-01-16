package arrayandstring;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Строка "PAYPALISHIRING" написана зигзагом в заданном количестве строк, как здесь: 
 * (вы можете захотеть отобразить этот шаблон фиксированным шрифтом для лучшей читаемости)

P A H N
A P L S I I G
Y I R
А
 
 * затем прочитайте строку за строкой: "PAHNAPLSIIGYIR"
 * Напишите код, который возьмет строку и выполнит это преобразование с заданным количеством строк:
 */

public class ZigzagConversion {
	public String convert(String source, int numbersRows) {

		if (numbersRows == 1 || numbersRows >= source.length())
			return source;

		StringBuilder[] rows = new StringBuilder[Math.min(numbersRows, source.length())];
		for (int i = 0; i < rows.length; ++i)
			rows[i] = new StringBuilder();

		int curRow = 0;
		boolean goingDown = false;

		for (char c : source.toCharArray()) {
			rows[curRow].append(c);
			if (curRow == 0 || curRow == numbersRows - 1)
				goingDown = !goingDown;
			curRow += goingDown ? 1 : -1;
		}

		StringBuilder ans = new StringBuilder();
		for (StringBuilder row : rows)
			ans.append(row);

		return ans.toString();
	}

	@Test
	public void case0() {

		String source = "МсГеАмОьМяДТАЫ";
		int numbersRows = 3;

		String expected = "МАМАсемьяТЫГОД";
		String actual = convert(source, numbersRows);

		assertEquals(expected, actual);
	}

	@Test
	public void case1() {
		String source = "PAYPALISHIRING";
		int numbersRows = 3;

		String expected = "PAHNAPLSIIGYIR";
		String actual = convert(source, numbersRows);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		String source = "PAYPALISHIRING";
		int numbersRows = 4;

		String expected = "PINALSIGYAHRPI";
		String actual = convert(source, numbersRows);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		String source = "A";
		int numbersRows = 1;

		String expected = "A";
		String actual = convert(source, numbersRows);

		assertEquals(expected, actual);
	}
}
