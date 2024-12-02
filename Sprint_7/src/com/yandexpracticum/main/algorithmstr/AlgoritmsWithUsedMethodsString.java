package com.yandexpracticum.main.algorithmstr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

	public boolean utilMethodsStartsWith(String initial, String other) {
		return initial.startsWith(other);
	}

	@Test
	public void startsWithWhenSubstringInitialThenReturnTrue() {
		String initial = "Ivanov";
		String other = "Iva";
		assertTrue(startsWith(initial, other));
		assertTrue(utilMethodsStartsWith(initial, other));
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

	public boolean standartMethodEndsWith(String initial, String other) {
		return initial.endsWith(other);
	}

	@Test
	public void endsWithWhenSubstringInitialThenReturnTrue() {
		String initial = "жираф";
		String other = "раф";
		assertTrue(endsWith(initial, other));
		assertTrue(standartMethodEndsWith(initial, other));
	}

	@Test
	public void endsWithWhenNotSubstringInInitialThenReturnFalse() {
		String initial = "кошка";
		String other = "каша";
		assertFalse(endsWith(initial, other));
	}

	/*
	 * Всего в String три метода для поиска подстроки: boolean contains(String
	 * other) возвращает true, если подстрока будет обнаружена в любом месте строки,
	 * иначе false; boolean startsWith(String other) вернёт true, если подстрока
	 * находится в начале строки, иначе false; boolean endsWith(String other) вернёт
	 * true, если подстрока в конце строки, иначе false.
	 */

	/*
	 * Например, в банковских приложениях запрещено показывать номер карты без
	 * согласия пользователя из-за требований к защите информации. Поэтому строка
	 * "1111 2222 3333 4444" должна быть заменена на строку "1111 **** **** 4444".
	 * Для этого нужно получить подстроку из первых 4 4 цифр номера карты, добавить
	 * к ней 8 8 недостающих символов '*', а затем ещё подстроку из 4 4 последних
	 * цифр. Попробуйте реализовать такое сокрытие строки самостоятельно — напишите
	 * метод maskCardNumber, который принимает строку с номером карты из 16 16
	 * символов и оставляет в ней только первые четыре и последние четыре символа.
	 * Остальные замените на *.
	 */

	public String maskCardNumber(String cardNumber) {
		int len = cardNumber.length();
		int visibilityArea = 4;
		int hidenArea = 8;
		String mask = "*".repeat(hidenArea);
		String result = cardNumber.substring(0, visibilityArea) + mask + cardNumber.substring(len - visibilityArea);
		return result;
	}

	@Test
	public void maskCardNumberTest() {
		String actual = maskCardNumber("1234567890123456");
		String expected = "1234********3456";

		assertEquals(expected, actual);
	}

	/*
	 * Напишите метод int numberOfRepeats(String text, String substring), который
	 * будет возвращать число повторения подстроки substring в переданном тексте
	 * text.
	 */

	public int numberOfRepeats(String text, String substring) {
		int count = 0;
		int beginIdx = 0;
		int len = substring.length();
		while (beginIdx + len <= text.length()) {
			text = text.substring(beginIdx);
			beginIdx = text.indexOf(substring);
			if (beginIdx == -1)
				break;
			beginIdx += len;
			++count;
		}
		return count;
	}

	@Test
	public void numberOfRepeatsTest() {
		int actual = numberOfRepeats("раз два три, раз два три", "раз");
		int expected = 2;

		assertEquals(expected, actual);
	}

	@Test
	public void numberOfRepeatsTest3Elemnts() {
		int actual = numberOfRepeats("ttt", "t");
		int expected = 3;

		assertEquals(expected, actual);
	}

	@Test
	public void numberOfRepeatsTestRealText() {
		String text = "Команда Ctrl/Alt + F (⌘ + F для Mac) — пожалуй, самый известный пример организации "
				+ "поиска подстрок и символов внутри текста. При нажатии открывается небольшое окошко, куда "
				+ "вбивается текст, и в результате вы получаете количество повторов искомого текста или символа. "
				+ "\n Попробуйте реализовать такой подсчёт на Java. Напишите метод int numberOfRepeats(String text, String substring), "
				+ "который будет возвращать число повторения подстроки substring в переданном тексте text. ";
		String substring = "под";

		int actual = numberOfRepeats(text, substring);
		int expected = 3;

		assertEquals(expected, actual);
	}

	/*
	 * Маленькие дети часто забывают, что нужно начинать новое предложение с большой
	 * буквы. Помогите им! Реализуйте метод capitalize(). Он должен переводить
	 * первый символ в переданной строке в верхний регистр при помощи метода
	 * toUpperCase() и возвращать полученную строку.
	 */

	public String capitalize(String str) {
		str = (str.charAt(0) + "").toUpperCase() + str.substring(1);
		return str;
	}

	@Test
	public void capitalizeTest() {
		System.out.println(capitalize("я не волшебник, я только учусь!"));
	}
}
