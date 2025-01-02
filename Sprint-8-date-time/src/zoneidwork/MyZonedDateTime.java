package zoneidwork;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class MyZonedDateTime {
	public static void main(String[] args) {
		Instant now = Instant.now();

		// сохраняем московское время:
		ZoneId moscowZone = ZoneId.of("Europe/Moscow");
		ZonedDateTime moscowDateTime = ZonedDateTime.ofInstant(now, moscowZone);

		// меняем регион на Нью-Йорк
		ZoneId newYorkZone = ZoneId.of("America/New_York");
		ZonedDateTime newYorkDateTime = moscowDateTime.withZoneSameLocal(newYorkZone);

		System.out.println(moscowDateTime);
		System.out.println(newYorkDateTime);
	}
}
