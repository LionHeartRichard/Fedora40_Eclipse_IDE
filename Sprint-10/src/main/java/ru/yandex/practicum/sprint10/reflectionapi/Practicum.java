package ru.yandex.practicum.sprint10.reflectionapi;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class Practicum {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// тип переменной setClass — Class, и ей присвоен литерал класса Set
		Class<Set> setClass = Set.class;
		System.out.println(setClass); // выведет: interface java.util.Set

		// ----------------------------------------------------------------

		// Тип переменной setOfStrings — Set, но конкретным классом объекта является
		// HashSet
		Set<String> setOfStrings = new HashSet<>();
		/*
		 * Получаем представление класса объекта — в нашем случае это будет класс,
		 * расширяющий интерфейс Set, поэтому и параметр типа записан как <? extends
		 * Set>.
		 */
		Class<? extends Set> clazz = setOfStrings.getClass();
		System.out.println(clazz); // Выведет class java.util.HashSet

		Method method = GetMethodsUseReflection.class.getMethod("getData", String.class, int.class);
		System.out.println("Метод: " + method);

		Method[] methods = GetMethodsUseReflection.class.getMethods();
		System.out.println("Все методы:");
		for (Method m : methods) {
			System.out.println(m);
		}
	}
}
