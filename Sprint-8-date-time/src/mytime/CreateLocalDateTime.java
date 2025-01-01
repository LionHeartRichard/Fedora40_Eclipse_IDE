package mytime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CreateLocalDateTime {
	public static void main(String[] args) {
		// создадим по отдельности дату и время
		LocalTime time = LocalTime.now();
		LocalDate date = LocalDate.now();

		// соберём их вместе — в экземпляр LocalDateTime
		LocalDateTime newDateTime = LocalDateTime.of(date, time);
		System.out.println(newDateTime);
	}
}
