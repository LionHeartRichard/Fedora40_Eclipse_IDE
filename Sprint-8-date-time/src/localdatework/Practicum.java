package localdatework;

import java.time.LocalDateTime;

import static java.time.Month.FEBRUARY;

class Practicum {
	public static void main(String[] args) {
		// передаём все единицы времени
		// год, месяц, день, часы, минуты, секунды, наносекунды
		LocalDateTime newMillennium = LocalDateTime.of(2000, 1, 1, 0, 0, 0, 0);
		System.out.println(newMillennium);
		// не передаём секунды и наносекунды
		LocalDateTime alsoNewMillennium = LocalDateTime.of(2000, 1, 1, 0, 0);
		System.out.println(alsoNewMillennium);

		// используем месяц из констант перечисления java.time.Month
		LocalDateTime dateTimeOfTwos = LocalDateTime.of(2222, FEBRUARY, 2, 22, 22);
		System.out.println(dateTimeOfTwos);

		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println("Сейчас " + currentDateTime);

		LocalDateTime newDateTime = currentDateTime.plusMonths(3).plusWeeks(2);
		System.out.println("Через три с половиной месяца будет " + newDateTime);
	}
}