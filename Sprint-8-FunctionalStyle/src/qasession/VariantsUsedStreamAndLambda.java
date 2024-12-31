package qasession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VariantsUsedStreamAndLambda {
	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();
		List<Car> carsJack = Arrays.asList(new Car("Порш"), new Car("БМВ"));
		Person personJack = new Person(1, "Jack", 40, carsJack);
		persons.add(personJack);
		List<Car> carsGarry = Arrays.asList(new Car("Бэнтли"), new Car("Митсубиши"));
		Person personGarry = new Person(2, "Garry", 50, carsGarry);
		persons.add(personGarry);
		List<Car> carsAlex = Arrays.asList(new Car("Мерседес"));
		Person personAlex = new Person(3, "Jack", 22, carsAlex);
		persons.add(personAlex);

		System.out.println("stream().filter()" + "_".repeat(200));
		// найти всех людей старше 25
		List<Person> personsOld = persons.stream().filter(person -> person.getAge() > 25)
				.peek(person -> System.out.println(person)).toList();

		System.out.println("------------------Map---------------------");
		Map<Integer, Person> personsMapOld = persons.stream().filter(Person::isOld)
				.collect(Collectors.toMap(Person::getId, Function.identity()));
		personsMapOld.forEach((k, v) -> System.out.println(k + " | " + v));

		System.out.println("------------------Collection---------------------");
		Collection<Person> collectionPersonOld = persons.stream().filter(Person::isOldStatic).peek(System.out::println)
				.collect(Collectors.toList());

		System.out.println("------------------Set---------------------");
		Set<Person> setPersonOld = persons.stream().filter(VariantsUsedStreamAndLambda::isOldStatic)
				.peek(System.out::println).collect(Collectors.toSet());

		System.out.println("stream().map()" + "_".repeat(200));
		System.out.println("------------------List<String> names---------------------");
		List<String> namesPerson = persons.stream().map(Person::getName).collect(Collectors.toList());

		System.out.println();
		System.out.println("stream().flatMap()" + "_".repeat(200));
		System.out.println("------------------FLAT MAP---------------------");
		List<Car> cars = persons.stream().flatMap(person -> person.getCars().stream()).collect(Collectors.toList());
		cars.forEach(car -> System.out.println(car));

		System.out.println();
		List<Car> carsFlatMap = persons.stream().map(Person::getCars).flatMap(List::stream).toList();
		carsFlatMap.forEach(System.out::println);

		List<Car> collect1 = persons.stream().map(Person::getCars).filter(Objects::nonNull).flatMap(List::stream)
				.collect(Collectors.toList());

		List<Car> collect2 = persons.stream().flatMap(person -> {
			List<Car> personCars = person.getCars();
			return personCars == null ? Stream.empty() : personCars.stream();
		}).collect(Collectors.toList());

		// разделить людей на группы по возрасту
		Map<Boolean, List<Person>> collect3 = persons.stream().collect(Collectors.groupingBy(Person::isOld));

		// группируем людей по годам
		Map<Integer, List<Person>> collect4 = persons.stream().collect(Collectors.groupingBy(Person::getAge));

		Map<Integer, Set<Person>> collect5 = persons.stream()
				.collect(Collectors.groupingBy(Person::getAge, Collectors.toSet()));

		Map<Integer, List<String>> collect6 = persons.stream().collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));

		Map<Integer, Person> collect7 = persons.stream().collect(Collectors.toMap(Person::getId, person -> person));

		Map<Integer, Person> collect8 = persons.stream().collect(Collectors.toMap(Person::getAge, Function.identity()));

		Map<Integer, String> collect = persons.stream().collect(Collectors.toMap(Person::getId, Person::getName));

		System.out.println();
		// Использование конструктора в стриме
		System.out.println("Конструктор" + "_".repeat(200));

		List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");
		List<Integer> bikeFrameSize = Arrays.asList(15, 20, 25, 30);

		Bicycle[] bicycles = bikeBrands.stream().map(Bicycle::new).toArray(Bicycle[]::new);
		Arrays.asList(bicycles).stream().peek(System.out::println).toList();
	}

	public static boolean isOldStatic(Person person) {
		return person.getAge() > 25;
	}
}
