package mytime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/*
 * Инструкция по декодированию:
 * Объединить экземпляр даты и экземпляр времени в экземпляр LocalDateTime.
 * От полученного момента времени вычесть 2 месяца, 25 дней и 100 минут
 * В полученном результате перемножить порядковый номер дня в году и число часов.
 */

public class EncryptIgor {

	public static void main(String[] args) {
		LocalDate secretDate = LocalDate.of(2020, 1, 10);
		LocalTime secretTime = LocalTime.of(12, 30);

		int result = decode(secretDate, secretTime);
		System.out.println(result);
	}

	private static int decode(LocalDate secretDate, LocalTime secretTime) {
		// объедините secretDate и secretTime
		LocalDateTime newTime = LocalDateTime.of(secretDate, secretTime);

		// вычтите 2 месяца, 25 дней и 100 минут
		LocalDateTime secretMoment = newTime.minusMonths(2);
		secretMoment = secretMoment.minusDays(25);
		secretMoment = secretMoment.minusMinutes(100);
		// найдите произведение порядкового номера дня в году и часов из secretMoment
		int dayNumberOfYear = secretMoment.getDayOfYear();
		int hour = secretMoment.getHour();
		return dayNumberOfYear * hour;
	}
}
