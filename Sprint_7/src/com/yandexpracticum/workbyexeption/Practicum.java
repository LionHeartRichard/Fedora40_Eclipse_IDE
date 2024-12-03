package com.yandexpracticum.workbyexeption;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Practicum {
	public static void main(String[] args) {
		System.out.println(parseStringToUri("https://ya.ru"));
		System.out.println(parseStringToUri("\\\\"));
		System.out.println(parseStringToUri(null));

		System.out.println(addToMap(new HashMap<>(), "test", "test"));
		System.out.println(addToMap(new HashMap<>(), null, null));

		System.out.println(addToMap(new TreeMap<>(), "test", "test"));
		System.out.println(addToMap(new TreeMap<>(), null, null));

		System.out.println(addToMap(Map.of(), "test", "test"));

		// ------------------------------------------------------
		System.out.println(convertToString(0));
	}

	// ------Обработка исключений согласно иерархии иначе не скомпилируется!!!
	// Иерархия по стеку...
	private static String convertToString(Object x) {
		try {
			return (String) x;
		} catch (ClassCastException e) {
			System.out.println("Некорректное приведение типов");
		} catch (RuntimeException e) {
			System.out.println("Ошибка во время выполнения");
		} catch (Exception e) {
			System.out.println("Произошла неизвестная ошибка");
		}
		return null;
	}

	public static URI parseStringToUri(final String input) {
		try {
			return new URI(input);
		} catch (URISyntaxException exp) { // ловим исключение URISyntaxException
			System.out.println("Ошибка: неверный синтаксис URI!");
		} catch (NullPointerException exp) { // ловим исключение NullPointerException
			System.out.println("Ошибка: передан неинициализированный объект!");
		}
		return null;
	}

	public static Map<String, Object> addToMap(final Map<String, Object> storage, final String key,
			final Object value) {
		try {
			storage.put(key, value);
			return storage;
		} catch (NullPointerException e) {
			System.out.println("Реализация не поддерживает неинициализированные объекты.");
		} catch (UnsupportedOperationException e) {
			System.out.println("Реализация не поддерживает добавление новых объектов.");
		}
		return null;
	}
}
