package ru.yandex.practicum.sprint6.workcomparator;

import java.util.Comparator;

public class ItemPriceComparator implements Comparator<Item> {

	@Override
	public int compare(Item item1, Item item2) {
		// сравниваем товары — более дорогой должен быть дальше в списке
		if (item1.price > item2.price)
			return 1;

		// более дешёвый — ближе к началу списка
		if (item1.price < item2.price)
			return -1;
		return 0;
	}

}
