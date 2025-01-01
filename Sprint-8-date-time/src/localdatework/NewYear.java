package localdatework;

import static java.time.Month.JANUARY;
import static java.time.Month.OCTOBER;
import java.time.LocalDateTime;

class NewYear {
	public static void main(String[] args) {
		LocalDateTime newYear = LocalDateTime.of(2022, JANUARY, 1, 0, 0);
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Сейчас " + now);
		if (now.isBefore(newYear)) {
			System.out.println("С наступающим!");
		}
		if (now.isAfter(newYear)) {
			System.out.println("С прошедшим!");
		}
		if (now.equals(newYear)) {
			System.out.println("С Новым годом!");
		}

	}
}
