package com.beegining.finconverter;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) { // точка входа в программу

		Scanner scanner = new Scanner(System.in); // создаем объект scanner

		boolean isTrafficLightGreen = false; // объявляем и инициализируем переменную указывающую на положение светофора
		// подобные переменные также часто именуют флагами

		boolean isVehicleApproaching = false; // еще одна логическая переменная, которая хранит значение - приближается
												// ли транспортное средство

		System.out.println("Вы находитесь около пешеходного перехода (да/нет)?");
		String onCrosswalk = scanner.nextLine(); // при помощи объекта scanner и его метода nextLine считываем из
													// консоли введеные данные
		boolean isOnCrosswalk = onCrosswalk.equals("да"); // при помощи метода equals проверяем совпадение строковой
															// переменной со значением "да"

		if (isOnCrosswalk) {// Если пешеход находится на пешеходном переходе:
			System.out.println("Горит ли зелёный сигнал светофора (да/нет)?");
			String trafficLightGreen = scanner.nextLine();
			isTrafficLightGreen = trafficLightGreen.equals("да");
			if (!isTrafficLightGreen) {// Если светофор красный:
				System.out.println("Не переходите дорогу на красный свет светофора!");
			}
		} else {// Иначе
			// Если к пешеходу приближается транспортное средство:
			System.out.println("Видите ли вы приближающиеся автомобили (да/нет)?");
			String vehicleApproaching = scanner.nextLine();
			isVehicleApproaching = vehicleApproaching.equals("да");
			if (isVehicleApproaching) {
				System.out.println("Дождитесь, пока проедет транспортное средство!");
			}
		}

		boolean isSafePlace = false; // изначально устанавливаем позицию флага - не безопасное место

		if (!isSafePlace) {
			// Проверка на перебежку дороги в небезопасном месте:
			System.out.println("Находится ли вблизи вас поворот (П), остановка (А), перекрёсток (Х) или нет?");
			String unsafePlaceType = scanner.nextLine();
			switch (unsafePlaceType) {
			case "П":
				System.out.println("Не перебегайте дорогу вблизи поворотов!");
				break; // завершаем проверку на принадлежности к какому либо совпадению из
						// представленных ответов,
			// иначе не получим нужной логики исполнения программы
			case "А":
				System.out.println("Не перебегайте дорогу вблизи перекрестков!");
				break;
			case "Х":
				System.out.println("Не перебегайте дорогу вблизи остановок общественного транспорта!");
				break;
			default:
				// данный блок кода выполнится во всех случаях за исключением указанных выше
				isSafePlace = true; // так как опасные условия указанные выше исключены, указываем что дорогу можно
									// переходить
			}
		}

		if (isSafePlace) {
			System.out.println("Вы можете перейти дорогу!");
			System.out.println("Сколько полос движения на дороге?");
			int linesCount = 0;

			if (scanner.hasNextInt()) {// производим проверку на соответствие типов
				linesCount = scanner.nextInt();// считываем кол-во полос
			} else {
				scanner.close();
				return;
			}

			if (linesCount == 0) {
				System.out.println("Посмотрите в обе стороны и переходите.");
			} else {
				int halfWay = 0;
				for (int line = 1; line <= linesCount; ++line) { // в цикле итерируемся исходя из кол-во полос на дороге
					halfWay = line % 2; // исходя из того сколько полос мы преодолели - будем выводить разный текст
					if (halfWay != 0) {
						System.out.println("Посмотрите налево и переходите.");
					} else {
						System.out.println("Посмотрите направо и переходите.");
					}
				}
			}
		} else {
			System.out.println("Вы не можете перейти дорогу в этом месте!");
		}
		scanner.close(); // явно указываем JVM и garbage collection - что мы не намерены больше работать
							// с данным объектом
	}
}
