package com.yandexpracticum.main;

public class Main {

	public static void main(String[] args) {
		String moscow = "Москва";
		System.out.println(moscow.toString().toString().toString().toString());

		String blank = "   ";
		String notBlank = "Тут пробелы или строка?!";
		System.out.println(blank.isBlank()); // true
		System.out.println(notBlank.isBlank()); // false

		String withBlanks = "  Привет, у меня тут лишние пробелы!";
		String trimmed = withBlanks.trim();
		System.out.println(trimmed);

		String text = "Привет, я Java!";
		System.out.println(text.toUpperCase()); // выведет "ПРИВЕТ, Я JAVA!"
		System.out.println(text.toLowerCase()); // выведет "привет, я java!"

		String start = "Hello, world!";
		System.out.println(start.indexOf("world"));

		System.out.println(start.indexOf("world", 10));

		System.out.println("_".repeat(50));
		System.out.println("Так много методов!".indexOf("м", 3) == 4);
		int length = "Как их все запомнить?!".length();
		System.out.println("Как их все запомнить?!".charAt(length - 2) == '?');
		System.out.println("Шиншилла".lastIndexOf("и") == 4);

		System.out.println("_".repeat(50));
		System.out.println("раз два три".contains("раз")); // true
		System.out.println("раз два три".contains("два")); // true
		System.out.println("раз два три".contains("три")); // true

		System.out.println("раз два три".startsWith("раз")); // true
		System.out.println("раз два три".startsWith("два")); // false
		System.out.println("раз два три".startsWith("три")); // false

		System.out.println("раз два три".endsWith("раз")); // false
		System.out.println("раз два три".endsWith("два")); // false
		System.out.println("раз два три".endsWith("три")); // true

		System.out.println("_".repeat(50));
		String example = "раз два, раз два";
		System.out.println(example.replace("раз", "три")); // выведет "три два, три два"
		System.out.println(example.replaceFirst("раз", "три")); // выведет "три два, раз два"

		String vegetables = "Томат — зелёный, а морковка — оранжевая";
		System.out.println(vegetables.replace("а", "А").replaceFirst("зелёный", "красный"));
		// Выведет: "ТомАт — красный, А морковкА — орАнжевАя"
	}

}
