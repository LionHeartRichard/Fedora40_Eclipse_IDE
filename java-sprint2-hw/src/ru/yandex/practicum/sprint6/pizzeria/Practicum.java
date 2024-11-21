package ru.yandex.practicum.sprint6.pizzeria;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Practicum {
	// Создадим хеш-таблицу для хранения заказов.
	// В качестве ключа будет имя клиента.
	// В качестве значения — количество заказов от этого клиента.
	private Map<String, Integer> orders = new HashMap<>();

	public static void main(String[] args) {
		Practicum pizzeria = new Practicum();
		pizzeria.openPizzeria();
		pizzeria.printStatistics();
	}

	// Начинаем принимать заказы! 🍕
	private void openPizzeria() {
		newOrder("Леонардо");
		newOrder("Донателло");
		newOrder("Рафаэль");
		newOrder("Леонардо");
		newOrder("Микеланджело");
		newOrder("Шреддер");
		newOrder("Донателло");
	}

	private void newOrder(String clientName) {
		// Сохраните новый заказ в хеш-таблицу. При обновлении счётчика заказов
		// не забудьте учесть заказы, которые уже были сделаны ранее.
		if (orders.containsKey(clientName)) {
			int count = orders.get(clientName);
			orders.put(clientName, ++count);
		} else {
			orders.put(clientName, 1);
		}

	}

	private void printStatistics() {
		// Выведите собранную статистику в консоль и посчитайте общее количество
		// заказов.
		//
		// Формат для вывода данных в консоль:
		// Заказов от Микеланджело: 15
		// Заказов от Леонардо: 4
		// Всего заказов: 19
		int count = 0;
		for (Entry<String, Integer> e : orders.entrySet()) {
			System.out.println("Заказов от " + e.getKey() + ": " + e.getValue());
			count += e.getValue();
		}
		System.out.println("Всего заказов: " + count);
	}
}