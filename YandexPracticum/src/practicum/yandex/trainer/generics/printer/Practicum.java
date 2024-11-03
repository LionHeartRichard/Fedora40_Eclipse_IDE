package practicum.yandex.trainer.generics.printer;

import java.util.ArrayList;

class Practicum {

	public static void main(String[] args) {
		// первый магазин продаёт дорогие товары и хочет передавать копейки типом Long
		ArrayList<Long> longList = new ArrayList<>();
		longList.add(Long.MAX_VALUE);

		new Printer<>(longList).print();

		// второй магазин продаёт товары подешевле и использует для передачи копеек тип
		// Integer
		ArrayList<Integer> intList = new ArrayList<>();
		intList.add(100000);

		new Printer<>(intList).print();

		ArrayList<String> stringList = new ArrayList<>();
		stringList.add("Hello");

		// этот вариант должен вызывать ошибку компиляции
		// new Printer<>(stringList).print();
	}

}

class Printer<T extends Number> {
	private final ArrayList<T> list;

	public Printer(ArrayList<T> list) {
		this.list = list;
	}

	public void print() {
		for (int i = 0; i < list.size(); i++) {
			double price = list.get(i).doubleValue() / 100;
			System.out.println("Цена товара: " + price + " руб.");
		}
	}
}
