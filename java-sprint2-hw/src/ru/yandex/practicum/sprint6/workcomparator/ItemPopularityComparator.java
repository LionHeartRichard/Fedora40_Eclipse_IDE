package ru.yandex.practicum.sprint6.workcomparator;

import java.util.Comparator;

public class ItemPopularityComparator implements Comparator<Item> {

	/*
	 * Небольшой лайфхак: при реализации int compare(T,T) важен только знак
	 * возвращаемого целого числа. Другими словами, -20 и -1 интерпретируются
	 * одинаково. В нашем примере это значит, что если цена первого товара больше
	 * второго, то результат их вычитания будет положительным числом, если меньше —
	 * отрицательным, если цены равны — нулём. Зная это, код переопределяемого
	 * метода можно значительно упростить:
	 */

	@Override
	public int compare(Item item1, Item item2) {
		return item1.popularity - item2.popularity;
	}

}
