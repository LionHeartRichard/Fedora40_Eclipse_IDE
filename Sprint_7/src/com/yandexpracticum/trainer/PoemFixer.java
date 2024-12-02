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
		int len = substring.length();
		int idx = builder.indexOf(substring);

		while (idx != -1) {
			++count;
			int endIdx = len + idx;
			builder.delete(idx, endIdx);
			idx = builder.indexOf(substring);
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
	public void numberOfRepeatsTest() {
		String text = "java, java, javaScript, Perfect Origin - java!!!";
		String substring = "java";
		int expected = 4;

		int actual = numberOfRepeats(text, substring);

		assertEquals(expected, actual);
	}
}
