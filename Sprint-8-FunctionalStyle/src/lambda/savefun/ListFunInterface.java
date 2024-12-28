package lambda.savefun;

import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface Summator {
	int sum(int n1, int n2);
}

public class ListFunInterface {

	public static void main(String[] args) {
		Summator summator = (n1, n2) -> n1 + n2;
		// допишите код, использующий лямбду
		System.out.println("Сумма 23 и 65 равна " + summator.sum(23, 65));

		Function<Integer, String> intToString = num -> String.valueOf(num);
		System.out.println(intToString.apply(1000_0000));

		Predicate<Integer> isEven = num -> num % 2 == 0;

		if (isEven.test(12345)) {
			System.out.println("Число чётное");
		} else {
			System.out.println("Число нечётное");
		}

		Consumer<Double> outputDoubleConsumer = num -> System.out.println(String.format("Передано число %.2f", num));
		outputDoubleConsumer.accept(1234.5678);

		Supplier<LocalDateTime> currentDateTimeSupplier = () -> LocalDateTime.now();
		System.out.println("Текущая дата и время: " + currentDateTimeSupplier.get());
	}
}
