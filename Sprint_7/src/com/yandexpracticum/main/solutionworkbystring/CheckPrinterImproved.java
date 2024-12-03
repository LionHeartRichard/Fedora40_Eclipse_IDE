package com.yandexpracticum.main.solutionworkbystring;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class CheckPrinterImproved {

	private static int findMaxLength(String[] elements) {
		int max = 0;
		for (String e : elements) {
			if (e.length() > max) {
				max = e.length();
			}
		}
		return max;
	}

	public static void printCheck(String[] items) {
		int len = 0 - findMaxLength(items);
		for (String item : items) {
			String[] tmp = item.split(",");
			System.out.printf("%" + len + "s%" + len + "s%" + len + "s\n", tmp[0], tmp[1], tmp[2]);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите количество записей:");
		int n = Integer.parseInt(scanner.nextLine());
		String[] values = new String[n];
		for (int i = 0; i < n; ++i)
			values[i] = scanner.nextLine();
		printCheck(values);
		scanner.close();
	}

	@Test
	public void testPrintCheckNewFormater() {
		String[] items = { "Пицца, 1 шт., 310.50", "Чай, 2 шт., 113.30", "Печенье, 1 уп., 75.75" };
		printCheck(items);
	}
}
