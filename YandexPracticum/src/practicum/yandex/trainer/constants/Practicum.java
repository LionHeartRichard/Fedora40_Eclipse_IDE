package practicum.yandex.trainer.constants;

import java.util.Scanner;

class Practicum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Пожалуйста, введите сумму перевода в рублях.");
		double amount = 0;
		if (scanner.hasNextDouble()) {
			amount = scanner.nextDouble();
		} else {
			scanner.close();
			System.out.println("Invalide data!!!");
			return;
		}
		scanner.close();

		boolean isValid = TransactionValidator.isValidAmount(amount);
		if (isValid)
			System.out.println("Спасибо! Ваш перевод на сумму " + amount + " р. успешно выполнен.");
	}
}
