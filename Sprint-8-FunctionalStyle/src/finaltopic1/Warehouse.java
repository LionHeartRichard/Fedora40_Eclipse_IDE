package finaltopic1;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Warehouse {

	private List<Candy> candies;

	public Warehouse() {
		this.candies = List.of(new Candy("Мишка в лесу", 32, 2, Set.of("Мишка косолапый")),
				new Candy("Трюфель", 44, 5, Set.of("Трюфель классический", "Трюфель шоколадный")));
	}

	public Optional<Candy> search(String name) {
		return candies.stream().filter(c -> c.name.equals(name)).findFirst();
	}
}