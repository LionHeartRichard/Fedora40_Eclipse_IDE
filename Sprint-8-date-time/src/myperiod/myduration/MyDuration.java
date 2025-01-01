package myperiod.myduration;

import java.time.Duration;
import java.time.LocalTime;

public class MyDuration {
	public static void main(String[] args) {
		LocalTime start = LocalTime.of(0, 0);
		LocalTime finish = LocalTime.of(1, 30);

		// находим продолжительность между двумя единицами времени
		Duration ninetyMinutes = Duration.between(start, finish);

		LocalTime noon = LocalTime.of(12, 0);
		System.out.println("Старый момент времени: " + noon);
		// прибавляем к созданному моменту вычисленную продолжительность
		LocalTime newTime = noon.plus(ninetyMinutes);

		System.out.println("Новый момент времени: " + newTime);
	}
}
