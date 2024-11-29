package com.yandexpracticum.main.algorithmstr;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AlgoritmsWithUsedMethodsString {

	/*
	 * вам нужно написать метод, который будет проверять, что какая-то подстрока
	 * встречается в строке только один раз. Назовём его, например, boolean
	 * onlySingleSubstring(String initialString, String substring).
	 */

	public boolean onlySingleSubstring(String initialString, String substring) {
		return initialString.indexOf(substring) == initialString.lastIndexOf(substring);
	}

	/*
	 * Вам нужно реализовать метод boolean startsWith(String initial, String other),
	 * который возвращает true, если фамилия работника initial начинается с
	 * подстроки other, иначе false.
	 */

	public boolean startsWith(String initial, String other) {
		return initial.indexOf(other) == 0;
	}

	@Test
	public void startsWithWhenSubstringInitialThenReturnTrue() {
		String initial = "Ivanov";
		String other = "Iva";
		assertTrue(startsWith(initial, other));
	}

	@Test
	public void startsWithWhenSubstringInitialNo0IdxThenReturnFalse() {
		String initial = "Ivanov";
		String other = "va";
		assertFalse(startsWith(initial, other));
	}

	/*
	 * Теперь вам нужно реализовать метод boolean endsWith(String initial, String
	 * other) — для поиска не по началу слова, а по окончанию. Метод должен
	 * возвращать true, если строка initial заканчивается на строку other, иначе
	 * false. Например, для сочетания «жираф» и «раф», результат должен быть true,
	 * так как строка «жираф» заканчивается на слово «раф», а вот для сочетания
	 * «кошка» и «каша» должно вернуться false.
	 */

	public boolean endsWith(String initial, String other) {
		int findIdx = initial.length() - other.length();
		return initial.lastIndexOf(other) == findIdx;
	}

	@Test
	public void endsWithWhenSubstringInitialThenReturnTrue() {
		String initial = "жираф";
		String other = "раф";
		assertTrue(endsWith(initial, other));
	}

	@Test
	public void endsWithWhenNotSubstringInInitialThenReturnFalse() {
		String initial = "кошка";
		String other = "каша";
		assertFalse(endsWith(initial, other));
	}
}
