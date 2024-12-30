package instantwork;

import java.time.Instant;
import java.util.Random;

class Practicum {
	public static void main(String[] args) {
		// показывает текущее время в милесекундах
		// Unix-эпохи ещё называют timestamp (англ. «метка времени»)
		// В Java время хранится в виде целого числа — количества миллисекунд, прошедших
		// с 1 января 1970 года
		Instant currentTimestamp = Instant.now();
		System.out.println(currentTimestamp);

		// Посчитать количество миллисекунд с Unix-эпохи до конкретной метки времени
		// можно с помощью метода toEpochMilli():
		long milliseconds = currentTimestamp.toEpochMilli();
		System.out.println(milliseconds);

		// передаём количество секунд с запуска спутника до Unix-эпохи
		Instant satelliteLaunchFromSec = Instant.ofEpochSecond(-386310686L);
		// или делаем то же самое в миллисекундах
		Instant satelliteLaunchFromMillis = Instant.ofEpochMilli(-386310686000L);

		System.out.println(satelliteLaunchFromSec + " — время запуска, заданное через секунды.");
		System.out.println(satelliteLaunchFromMillis + " — время запуска, заданное через миллисекунды.");

		System.out.println(Instant.ofEpochSecond(-3_155_701_416_721_920L));
		System.out.println(Instant.ofEpochSecond(31_556_889_864_403_199L, 999_999_999));

		long millis = 9_000_000_000L; // количество миллисекунд

		System.out.println(Instant.ofEpochMilli(millis));
		System.out.println(Instant.ofEpochMilli(0 - millis));

		// Пицца разогревается 180 секунд - это 3 минуты
		long seconds = 180;

		Instant currentMoment = Instant.now();
		System.out.println("Сейчас " + currentMoment);
		Instant futureMoment = currentMoment.plusSeconds(seconds);
		System.out.println("А через " + seconds + " секунд будет " + futureMoment + " и пицца будет готова!");

		int chickenUnixSecond = new Random().nextInt(1000000000);
		Instant chickenMoment = Instant.ofEpochSecond(chickenUnixSecond);

		int eggUnixSecond = new Random().nextInt(1000000000);
		Instant eggMoment = Instant.ofEpochSecond(eggUnixSecond);

		System.out.println("Курица появилась в " + chickenMoment);
		System.out.println("Яйцо появилось в " + eggMoment);

		if (chickenMoment.isBefore(eggMoment)) {
			System.out.println("Первой была курица!");
		}
		if (chickenMoment.isAfter(eggMoment)) {
			System.out.println("Первым было яйцо!");
		}
		if (chickenMoment.equals(eggMoment)) {
			System.out.println("Яйцо было одновременно с курицей ¯\\_(ツ)_/¯)!");
		}
	}
}
