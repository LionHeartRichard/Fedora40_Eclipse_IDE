package ru.yandex.practicum.sprint6.workcomparator;

import java.util.ArrayList;
import java.util.Comparator;
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
		items.sort(itemPriceComparator);
		System.out.println("После сортировки PRICE:");
		System.out.println(items);
		// REVERSED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		items.sort(itemPriceComparator.reversed());
		System.out.println("После сортировки PRICE:");
		System.out.println(items);

		// создаём объект-компаратор по цене
		ItemPopularityComparator itemPooularityComparator = new ItemPopularityComparator();
		items.sort(itemPooularityComparator);
		System.out.println("После сортировки POPULARITY:");
		System.out.println(items);

		// создаём объект-компаратор лексикограической сортировки
		ItemStringInSensitiveNameComparator comparator = new ItemStringInSensitiveNameComparator();
		items.sort(comparator);
		System.out.println("После сортировки CASE_INSENSITIVE_ORDER:");
		System.out.println(items);
	}

	static class ItemStringInSensitiveNameComparator implements Comparator<Item> {

		/*
		 * String.CASE_INSENSITIVE_ORDER принимает строки в качестве аргументов, поэтому
		 * передадим названия товаров в его метод .compare(...)
		 */
		@Override
		public int compare(Item item1, Item item2) {
			return String.CASE_INSENSITIVE_ORDER.compare(item1.name, item2.name);
		}
	}

	static class ItemPriceComparatorWithUsedIntegerComparator implements Comparator<Item> {

		@Override
		public int compare(Item item1, Item item2) {
			return Integer.compare(item1.price, item2.price);
		}

	}
}
