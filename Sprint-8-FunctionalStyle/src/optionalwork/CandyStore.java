package optionalwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.Optional;

public class CandyStore {

	public static void main(String[] args) {
		Candy candy1 = new Candy("Мишка на севере", "Первая кондитерская фабрика", 28, 4,
				Set.of("Мишка косолапый", "Мишка"));
		Candy candy2 = new Candy("Мишка в лесу", "Триумф", 32, 2, Set.of("Мишка косолапый"));

		List<Candy> candies = new ArrayList<>();
		candies.add(candy1);
		candies.add(candy2);

		candies.add(new Candy("Шоколадный полет", "Главная шоколадная фабрика", 84, 0, Set.of("ШОКОЛАДНЫЙ ПОЛЕТ")));

		candies.stream()
				// выбираем только конфеты «Главной шоколадной фабрики»
				.filter(candy -> candy.producer.equals("Главная шоколадная фабрика"))
				// получаем первую из них
				.findFirst().ifPresentOrElse(
						// если Optional не пуст
						candy -> System.out.println(candy.name),
						// если Optional пуст
						() -> System.out.println("Такой конфеты не существует"));
	}
}

class Candy {
	final String name;
	final String producer;
	final int price;
	final int amountSold;
	final Set<String> alternateNames;

	public Candy(String name, String producer, int price, int amountSold, Collection<String> alternateNames) {
		this.name = name;
		this.producer = producer;
		this.price = price;
		this.amountSold = amountSold;
		this.alternateNames = Set.copyOf(alternateNames);
	}

}
