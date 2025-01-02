package zoneidwork;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class MyZoneId {
	public static void main(String[] args) {
		// создаём экземпляр местного времени и даты
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);

		// создаём экземпляр временной зоны
		ZoneId zone = ZoneId.of("UTC+3");
		System.out.println(zone);

		// создаём экземпляр ZonedDateTime
		ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zone);
		System.out.println(zonedDateTime);

		LocalDateTime dateTime2 = LocalDateTime.now();
		ZoneId zone2 = ZoneId.of("Europe/Moscow");
		ZonedDateTime zonedDateTime2 = ZonedDateTime.of(dateTime2, zone2);

		System.out.println(zonedDateTime2);

		// сохраняем временную отметку запуска первого искусственного спутника
		Instant moment = Instant.ofEpochSecond(-386310686L);
		System.out.println("Timestamp: " + moment);

		// сохраняем её как московское время:
		ZoneId zone3 = ZoneId.of("Europe/Moscow");
		ZonedDateTime zonedDateTime3 = ZonedDateTime.ofInstant(moment, zone);

		System.out.println(zonedDateTime3);

		Instant now = Instant.now();
		// сохраняем московское время:
		ZoneId moscowZone = ZoneId.of("Europe/Moscow");
		ZonedDateTime moscowDateTime = ZonedDateTime.ofInstant(now, moscowZone);

		// узнаём время в Нью-Йорке:
		ZoneId newYorkZone = ZoneId.of("America/New_York");
		ZonedDateTime newYorkDateTime = moscowDateTime.withZoneSameInstant(newYorkZone);

		System.out.println(moscowDateTime);
		System.out.println(newYorkDateTime);
	}
}
