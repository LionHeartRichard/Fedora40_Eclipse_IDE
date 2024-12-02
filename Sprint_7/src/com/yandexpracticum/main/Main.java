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

		System.out.println("_".repeat(50) + "StringBuilder" + "_".repeat(50));
		StringBuilder builder = new StringBuilder("Helo!");
		builder.insert(3, "l"); // добавили "l" на 3-ю позицию перед "o"
		System.out.println(builder.toString());
		builder.append(" World!");
		builder.replace(1, 2, "ё");
		builder.replace(7, 13, "java!");
		System.out.println(builder.toString());

		builder = new StringBuilder("Hhellllllo!");
		builder.deleteCharAt(1); // удалит элемент 'h'
		builder.delete(2, 6); // удалит все лишние символы 'l'
		System.out.println(builder.toString()); // выведет строку "Hello!"
		builder.reverse();
		System.out.println(builder.toString());
		builder = new StringBuilder("hellodghkwennalmc/ skm");
		builder.setLength(5); // останется только пять символов
		System.out.println(builder.toString()); // выведет строку "hello"

		StringBuilder initial = new StringBuilder("Большая красная кнопка");

		initial.replace(8, 15, "белая");
		initial.delete(14, 30);
		initial.append("груша");
		initial.setLength(7);
		initial.reverse();

		System.out.println(initial.toString().toLowerCase());
	}

}
