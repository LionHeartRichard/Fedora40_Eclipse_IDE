package mytime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ExtractLocalDateTime {
	public static void main(String[] args) {
		LocalDateTime dateTime = LocalDateTime.now();

		// извлечём время
		LocalTime time = dateTime.toLocalTime();
		System.out.println(time);

		// извлечём дату
		LocalDate date = dateTime.toLocalDate();
		System.out.println(date);
	}
}
