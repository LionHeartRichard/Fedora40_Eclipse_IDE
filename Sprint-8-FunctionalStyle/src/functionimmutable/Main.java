package functionimmutable;

import java.util.List;
import java.util.Set;
import java.util.stream.*;

public class Main {

	public static void main(String[] args) {
		Candy candy1 = new Candy("Мишка на севере", "Первая кондитерская фабрика", 28, 4,
				Set.of("Мишка косолапый", "Мишка"));
		Candy candy2 = new Candy("Мишка в лесу", "Триумф", 32, 2, Set.of("Мишка косолапый"));
		Candy candy3 = new Candy("Трюфель", "Триумф", 44, 5, Set.of("Трюфель классический", "Трюфель шоколадный"));
		Candy candy4 = new Candy("Победа", "Первая кондитерская фабрика", 14, 12, Set.of("ПОБЕДА"));

		List<Candy> candies = List.of(candy1, candy2, candy3, candy4);
		System.out.println("Список до изменений");
		candies.forEach(v -> System.out.println(v));

		/*
		 * С помошью циклов мы бы не смогли задать значения так как объект неизменяемый
		 * С помошью стримов мы создаем новый список с необходимыми объектами
		 */

		System.out.println("Список ПОСЛЕ изменений");
		List<Candy> candiesRepriced = candies.stream().map(candy -> {
			if (candy.price < 30) {
				return new Candy(candy.name, candy.producer, 30, candy.amountSold, candy.alternateNames);
			} else {
				return candy;
			}
		}).peek(System.out::println).collect(Collectors.toList());

		System.out.println("Сортировка по имени");
		List<Candy> sortCandyByNames = candiesRepriced.stream().sorted(Candy::compareByName).peek(System.out::println)
				.toList();
	}
}
