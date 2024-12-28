package topic1;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Candy {

	final String name;
	final String producer;
	final int price;
	// проданное количество
	final int amountSold;

	final Set<String> alternateNames;

	public Candy(String name, String producer, int price, int amountSold, Collection<String> alternateNames) {
		this.name = name;
		this.producer = producer;
		this.price = price;
		this.amountSold = amountSold;
		this.alternateNames = Set.copyOf(alternateNames);
	}

	public static int compareByName(Candy c1, Candy c2) {
		return c1.name.compareTo(c2.name);
	}
}

class CandyBox {
	final String boxTitle;
	final List<Candy> candies;
	final long numberOfCandies;

	private static final List<String> prohibitedProducers = List.of("Триумф");

	public CandyBox(String boxTitle, List<Candy> candies, long numberOfCandies) {
		super();
		this.boxTitle = boxTitle;
		this.candies = candies;
		this.numberOfCandies = numberOfCandies;
	}

	public static boolean isProducerAllowed(Candy candy) {
		return !prohibitedProducers.contains(candy.producer);
	}

	public void printContent() {
		System.out.println("Набор " + boxTitle + ", содержит " + numberOfCandies + " конфет");
		candies.forEach(
				candy -> System.out.println(candy.name + " производства " + candy.producer + ", цена: " + candy.price));
	}
}

public class CandyBoxesStore {

	public static void main(String[] args) {
		Candy candy1 = new Candy("Мишка на севере", "Первая кондитерская фабрика", 28, 4,
				Set.of("Мишка косолапый", "Мишка"));
		Candy candy2 = new Candy("Мишка в лесу", "Триумф", 32, 2, Set.of("Мишка косолапый"));
		Candy candy3 = new Candy("Трюфель", "Триумф", 44, 5, Set.of("Трюфель классический", "Трюфель шоколадный"));
		Candy candy4 = new Candy("Победа", "Первая кондитерская фабрика", 14, 12, Set.of("ПОБЕДА"));

		List<Candy> candies = List.of(candy1, candy2, candy3, candy4);

		List<Candy> candiesForBox = candies.stream().filter(CandyBox::isProducerAllowed).map(c -> {
			return new Candy(c.name, c.producer, c.price - 5, c.amountSold, c.alternateNames);
		}).sorted(Candy::compareByName).collect(Collectors.toList());

		CandyBox candyBox = new CandyBox("С Новым Годом", candiesForBox, candiesForBox.size());

		candyBox.printContent();
	}
}
