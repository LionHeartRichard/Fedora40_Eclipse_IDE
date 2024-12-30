package qasession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class VariantsUsedStreamAndLambda {
	public static void main(String[] args) {

		List<Car> carsJack = Arrays.asList(new Car("Порш"), new Car("БМВ"));
		Person person = new Person(1, "Jack", 11, carsJack);

		// Использование конструктора в стриме
		System.out.println("-".repeat(50) + "Конструктор" + "-".repeat(50));
		List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");
		List<Integer> bikeFrameSize = Arrays.asList(15, 20, 25, 30);

		Bicycle[] bicycles = bikeBrands.stream().map(Bicycle::new).toArray(Bicycle[]::new);
		Arrays.asList(bicycles).stream().peek(System.out::println).toList();
	}
}
