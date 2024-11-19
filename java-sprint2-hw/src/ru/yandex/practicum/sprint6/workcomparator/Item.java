package ru.yandex.practicum.sprint6.workcomparator;

public class Item {

	public final String name; // название товара
	public final int price; // цена
	public final int popularity; // популярность

	public Item(String name, int price, int popularity) {
		this.name = name;
		this.price = price;
		this.popularity = popularity;
	}

	// сразу переопределим toString(), чтобы потом выводить содержание списка
	@Override
	public String toString() {
		return "Item{" + "name='" + name + '\'' + ", price=" + price + ", popularity=" + popularity + '}';
	}
}
