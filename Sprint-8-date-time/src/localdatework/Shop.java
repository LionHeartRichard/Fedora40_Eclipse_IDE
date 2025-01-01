package localdatework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Shop {
	public static void main(String[] args) {
		String input = "14 часов 09 минут. Месяц: 02, День: 14, Год: 1966.";

		printCorrectDateTime(input);
	}

	private static void printCorrectDateTime(String input) {
		DateTimeFormatter inputFormatter = DateTimeFormatter
				.ofPattern("HH часов mm минут. Месяц: MM, День: dd, Год: yyyy."); // определите входной формат
		LocalDateTime dateTime = LocalDateTime.parse(input, inputFormatter); // сконвертируйте исходную строку в
																				// LocalDateTime

		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd_MM_yyyy|HH:mm"); // определите выходной
																								// формат
		System.out.println(dateTime.format(outputFormatter)); // выведите результат на экран
	}
}
