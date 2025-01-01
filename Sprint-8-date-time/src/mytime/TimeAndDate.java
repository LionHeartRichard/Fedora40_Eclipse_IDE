package mytime;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeAndDate {
	public static void main(String[] args) {
		LocalTime currentTime = LocalTime.now();
		System.out.println(currentTime);

		// проверяем, больше ли местное время 10:50
		System.out.println(currentTime.isAfter(LocalTime.of(10, 50)));

		// создаём экземпляр LocalDate, в котором будет храниться дата 25 мая 2005 года
		LocalDate someDate = LocalDate.of(2005, 5, 25);
		System.out.println(someDate);

		// добавляем к 25 мая 2005 года 5 месяцев
		System.out.println(someDate.plusMonths(5));

	}
}
