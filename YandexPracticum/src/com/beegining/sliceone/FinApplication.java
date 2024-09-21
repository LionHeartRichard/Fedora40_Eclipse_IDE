package com.beegining.sliceone;

import java.util.Scanner;

/*
 * Посчитайте начальную сумму в выбранной валюте с помощью NumberReader.getDouble(). 
 * Сохраните результат в переменную amount типа double.
 * Посчитайте количество лет для расчёта с помощью NumberReader.getInteger(). 
 * Сохраните результат в переменную years типа int.
 * Используя цикл for, выполните расчёт итоговой суммы на основе процентной ставки 
 * и количества лет. 
 * Обновляйте значение amount на каждой итерации.
 * Условие цикла: начинается с единицы, меньше или равно years, 
 * увеличивается на единицу.
 * Формула для расчёта процентной ставки: amount = amount + amount * (interestRate / 100);.
 * Выведите на экран итоговую сумму по окончании указанного периода 
 * с помощью System.out.println. 
 * Выражение для вывода: "К окончанию срока сумма составит: " + amount + " " + "RUB".
 */

public class FinApplication {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		double exchangeRateUSD = 94.8;
		double exchangeRateEUR = 103.8;
		double exchangeRateCNY = 13.1;

		double interestRateRUB = 7;
		double interestRateUSD = 1;
		double interestRateEUR = 0.8;
		double interestRateCNY = 1.5;

		System.out.println("Введите номер валюты:");
		System.out.println("1 – рубли;");
		System.out.println("2 – доллары;");
		System.out.println("3 – евро;");
		System.out.println("4 – юани.");

		// посчитайте номер валюты и сохраните в переменную currency
		int currency = scanner.nextInt();
		// NumberReader.getInteger();

		// объявите переменную exchangeRate для курса и проинициализируйте единицей
		double exchangeRate = 1.0;

		// объявите переменную interestRate для процентной ставки
		double interestRate = 1.0;
		// объявите переменную currencySymbol для обозначения аббревиатуры валюты
		String currencySymbol = "";

		if (currency == 1) {
			interestRate = interestRateRUB; // устанавливаем соответствующую ставку,
			currencySymbol = "RUB"; // устанавливаем код валюты
		} else if (currency == 2) {
			interestRate = interestRateUSD; // устанавливаем соответствующую ставку,
			currencySymbol = "USD"; // устанавливаем код валюты
			exchangeRate = exchangeRateUSD;
		} else if (currency == 3) {
			interestRate = interestRateEUR; // устанавливаем соответствующую ставку,
			currencySymbol = "EUR"; // устанавливаем код валюты
			exchangeRate = exchangeRateEUR;
		} else if (currency == 4) {
			interestRate = interestRateCNY; // устанавливаем соответствующую ставку,
			currencySymbol = "CNY"; // устанавливаем код валюты
			exchangeRate = exchangeRateCNY;
		} else {
			System.out.println("Ошибка: выбрана некорректная валюта. Валюта по умолчанию — рубли.");
			interestRate = interestRateRUB; // устанавливаем соответствующую ставку,
			currencySymbol = "RUB"; // устанавливаем код валюты
		}

		System.out.println("Введите начальную сумму в выбранной валюте:");

		double amount = scanner.nextDouble();
		// NumberReader.getDouble();

		System.out.println("Введите количество лет для расчёта:");
		int years = scanner.nextInt();
		// NumberReader.getInteger();

		for (int i = 1; i <= years; ++i) {
			amount += amount * (interestRate / 100);
			if (i % 3 == 0)
				amount *= 1.01;
		}

		System.out.println("К окончанию срока сумма составит: " + amount + " " + currencySymbol);

		if (!currencySymbol.equals("RUB")) {
			double roubles = amount * exchangeRate;
			System.out.println("В рублях это будет: " + roubles + " руб.");
		}

		System.out.println("Работа с программой завершена");
		
		scanner.close();
	}
}
