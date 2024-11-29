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
	}

}
