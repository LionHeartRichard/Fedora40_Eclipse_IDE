package com.yandexpracticum.trainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PoemFixer {

	public String fixPoem(String[] poem) {
		StringBuilder builder = new StringBuilder();
		for (String s : poem) {
			builder.append(s.trim());
		}
		return builder.toString();
	}

	public int numberOfRepeats(String text, String substring) {
		int count = 0;
		StringBuilder builder = new StringBuilder(text);
		while (builder.indexOf(substring) > -1) {
			++count;
			builder.delete(0, builder.indexOf(substring) + 1);
		}
		return count;
	}

	@Test
	public void fixPoemTest() {
		String[] poem = { " Я помню чудное мгновенье:", "   Передо мной явилась ты,   ", "", "   ",
				" Как мимолётное виденье,", " ", "Как гений чистой красоты.", "" };
		String expected = "Я помню чудное мгновенье:Передо мной явилась ты,Как мимолётное виденье,Как гений чистой красоты.";

		String actual = fixPoem(poem);

		assertEquals(expected, actual);
	}

	@Test
	public void numberOfRepeatsWhenStandartStringThenReturn4() {
		String text = "java, java, javaScript, Perfect Origin - java!!!";
		String substring = "java";
		int expected = 4;

		int actual = numberOfRepeats(text, substring);

		assertEquals(expected, actual);
	}

	@Test
	public void numberOfRepeatsWhenSingleSymbolTo7ThenReturn7() {
		String text = "jjjjjjj";
		String substring = "j";
		int expected = 7;

		int actual = numberOfRepeats(text, substring);

		assertEquals(expected, actual);
	}

	@Test
	public void numberOfRepeatsWhenSingleSymbolTo2BeginAndEndStrThenReturn2() {
		String text = "jaaaj";
		String substring = "j";
		int expected = 2;

		int actual = numberOfRepeats(text, substring);

		assertEquals(expected, actual);
	}
}
