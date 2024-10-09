package com.sprint3;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> animals = new ArrayList<>();
		animals.add("Шиншилла");
		animals.add("Крокодил");
		animals.add("Лев");
		animals.add("Медведь");
		animals.add("Слон");

		while (true) {
			printMenu();
			int command = scanner.nextInt();
			if (command == 1) {
				System.out.println("Сейчас в зоопарке можно увидеть " + animals.size() + " животных:");
				animals.forEach(v -> System.out.println(v));
			} else if (command == 2) {
				System.out.println("Какое животное хотите добавить?");
				String animal = scanner.next();
				animals.add(animal);
			} else if (command == 3) {
				System.out.println("Какое животное нужно удалить?");
				String animal = scanner.next();
				if (!animals.isEmpty()) {
					animals.remove(animal);
				}
			} else if (command == 4) {
				animals.clear();
				System.out.println("Все животные перевезены в другой зоопарк. Список пуст.");
			} else if (command == 5) {
				System.out.println("Какое животное вы хотите увидеть в зоопарке?");
				String animal = scanner.next();
				if (animals.contains(animal)) {
					System.out.println(animal + " на месте! Приходите посмотреть.");
					continue;
				}
				System.out.println("Такого животного сейчас нет в нашем зоопарке.");
			} else {
				break;
			}
		}
		scanner.close();
	}

	public static void printMenu() {
		System.out.println("1 - Показать список животных в зоопарке.");
		System.out.println("2 - Добавить животное в список.");
		System.out.println("3 - Удалить животное из списка.");
		System.out.println("4 - Очистить список.");
		System.out.println("5 - Проверить, есть ли в зоопарке животное.");
		System.out.println("Любая другая цифра - Выйти из приложения.");
	}

}
