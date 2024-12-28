package optionalwork;

import java.util.stream.Stream;

public class OptionalInStreams {
	public static void main(String[] args) {
		Stream.of(1, 2, 3, 4, 5).filter(number -> number % 2 == 0).findFirst().ifPresentOrElse(System.out::println,
				() -> System.out.println("Чётное число не найдено"));
	}
}
