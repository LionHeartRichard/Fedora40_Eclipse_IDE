package com.yandexpracticum.main.solutionworkbystring;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class CheckPrinter {
	public static void printCheck(String[] items) {
		for (String item : items) {
			String[] tmp = item.split(",");
			System.out.printf("%-10s%-7s%-8s\n", tmp[0], tmp[1], tmp[2]);
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
	public void testPrintCheck() {
		String[] items = { "Пицца, 1 шт., 310.50", "Чай, 2 шт., 113.30", "Печенье, 1 уп., 75.75" };
		printCheck(items);
	}
}