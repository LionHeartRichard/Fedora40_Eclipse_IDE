package practicum.yandex.trainer.generics.task2;

import java.util.Scanner;

class Practicum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Заполните данные для ипотечной заявки и узнайте статус одобрения");
		System.out.println("Введите ФИО:");
		String name = scanner.nextLine();

		System.out.println("Ваш возраст:");
		byte age = scanner.nextByte();

		System.out.println("Планируемая сумма ипотеки:");
		int mortgageAmount = scanner.nextInt();

		scanner.nextLine();
		System.out.println("Трудоустроены ли вы сейчас? (д/н)");
		String employedString = scanner.nextLine();
		boolean employed = employedString.equalsIgnoreCase("д");

		MortgageRequest mortgageRequest = new MortgageRequest(name, age, mortgageAmount, employed);
		mortgageRequest.validate();

		scanner.close();
	}

}
