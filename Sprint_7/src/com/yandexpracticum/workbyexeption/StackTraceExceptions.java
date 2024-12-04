package com.yandexpracticum.workbyexeption;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StackTraceExceptions {
	public static void main(String[] args) {
		System.out.print("Введите целое число => ");
		Scanner scanner = new Scanner(System.in);
		final String inputValue = scanner.next();
		scanner.close();
		try {
			final int parsedValue = IntegerParser.parseInt(inputValue);
			System.out.println(parsedValue);
		} catch (NullPointerException exception) {
			printException("Введена пустая строка.", exception);
		} catch (IllegalArgumentException exception) {
			printException("Вы ввели не целое число.", exception);
		} catch (NoSuchElementException exception) {
			printException("Введённое число слишком большое.", exception);
		} catch (Exception exception) {
			printException("Неизвестное исключение", exception);
		}
	}

	private static void printException(final String message, Exception e) {
		System.out.println(message);
		if (e.getMessage() != null) {
			System.out.println(e.getMessage());
		} else {	
			e.printStackTrace();
		}
	}
}
