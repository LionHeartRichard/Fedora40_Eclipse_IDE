package ru.yandex.practicum;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Вас приветствует приложение <<Счётчик калорий>>");

		StepTracker stepTracker = new StepTracker(scanner);

		while (true) {
			printMenu();
			if (scanner.hasNextInt()) {
				int command = scanner.nextInt();
				if (command == 1) {
					stepTracker.addNewNumberStepsPerDay();
				} else if (command == 2) {
					stepTracker.changeStepGoal();
				} else if (command == 3) {
					stepTracker.printStatistic();
				} else if (command == 0) {
					break;
				} else {
					System.out.println("Введена неизвестная комманда!!!");
				}
			} else {
				scanner.next();
				System.out.println("Введены не валидные данные!!!");
				continue;
			}
			System.out.println();
			System.out.println("-".repeat(20));
		}
		System.out.println("Работа программы завершена!!! Отличного настроения!!!");
		scanner.close();
	}

	private static void printMenu() {
		System.out.println("ВЫБЕРЕТЕ КОМАНДУ:");
		System.out.println("ввести количество шагов за день            - 1");
		System.out.println("изменить цель по количеству шагов в день   - 2");
		System.out.println("статистика за месяц                        - 3");
		System.out.println("завершение работы программы                - 0");
	}

}
