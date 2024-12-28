package lambda;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PrimeNumbers {

	public static void main(String[] args) {

		Supplier<Integer> randomInt = () -> ThreadLocalRandom.current().nextInt(0, 100);

		Predicate<Integer> isPrime = number -> {
			int count = 0;
			for (int i = 1; i <= number; ++i) {
				if (number % i == 0) {
					++count;
				}
			}
			return count == 2;
		};

		BiConsumer<Integer, String> outputConsumer = (num, str) -> System.out.println("Число " + num + " " + str);

		for (int i = 0; i < 10; i++) {
			Integer number = randomInt.get();

			if (isPrime.test(number)) {
				outputConsumer.accept(number, "является простым.");
			} else {
				outputConsumer.accept(number, "не является простым.");
			}
		}
	}
}