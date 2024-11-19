package ru.yandex.practicum.sprint6.workcomparator;

import java.util.ArrayList;
import java.util.List;

class Practicum {

	public static void main(String[] args) {

		// создаём список товаров
		List<Item> items = new ArrayList<>();
		items.add(new Item("Рубашка", 4500, 37));
		items.add(new Item("Носки", 55, 8));
		items.add(new Item("Толстовка", 1399, 74));
		items.add(new Item("Носки", 169, 19));

		System.out.println("До сортировки:");
		System.out.println(items);

		// создаём объект-компаратор по цене
		ItemPriceComparator itemPriceComparator = new ItemPriceComparator();

		// применяем компаратор
		items.sort(itemPriceComparator);

		System.out.println("После сортировки:");
		System.out.println(items);
	}
}
