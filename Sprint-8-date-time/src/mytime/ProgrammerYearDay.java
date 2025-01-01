package mytime;

import java.time.LocalDate;

public class ProgrammerYearDay {
	public static final int PROGRAMMER_YEAR_DAY = 256;

	public static void main(String[] args) {
		System.out.println("День программиста отмечается в " + PROGRAMMER_YEAR_DAY + "-й день в году.");
		LocalDate today = LocalDate.now();
		int currentYear = today.getYear();
		System.out.println("Сейчас " + currentYear + " год.");

		LocalDate programmerDay = LocalDate.ofYearDay(currentYear, PROGRAMMER_YEAR_DAY);
		System.out.println("Значит, в этом году день программиста — " + programmerDay.getDayOfMonth() + " "
				+ programmerDay.getMonth());
		System.out.println("День недели — " + programmerDay.getDayOfWeek());
	}
}
