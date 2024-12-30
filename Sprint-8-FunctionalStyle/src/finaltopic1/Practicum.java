package finaltopic1;

import java.util.Optional;

public class Practicum {
	public static void main(String[] args) {
		// Доработайте данный метод, чтобы на экран выводилось
		// сообщение в соответствии с заданием

		SearchService searchService = new SearchService();

		Optional<Candy> candy = searchService.search("Африка");
		if (candy.isPresent())
			System.out.println(candy.get());
		else
			System.out.println("Данный товар не найден");
	}
}