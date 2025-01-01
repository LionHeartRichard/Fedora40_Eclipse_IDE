package localdatework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class PrintFormateDateAndTime {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Было: " + now);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy|HH:mm");
		String formatDateTime = now.format(formatter);
		System.out.println("Стало: " + formatDateTime);

		LocalDateTime dateTime = LocalDateTime.parse("2021-12-21T21:21:21");
		System.out.println(dateTime);

		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");

		LocalDateTime anotherDateTime = LocalDateTime.parse("22.02.2022, 22:22", formatter1);
		System.out.println(anotherDateTime);

		System.out.println(dateTime.isAfter(anotherDateTime));
	}
}
