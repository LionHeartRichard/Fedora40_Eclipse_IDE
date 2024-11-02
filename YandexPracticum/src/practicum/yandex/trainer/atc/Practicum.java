package practicum.yandex.trainer.atc;

import java.util.Scanner;

class Practicum {

	public static void main(String[] args) {
		System.out.println("Вас приветствует виртуальная АТС!");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите ваш номер телефона:");
		String number = scanner.next();
		System.out.println("Введите номер пользователя, которому хотите позвонить:");
		String friendNumber = scanner.next();
		System.out.println(
				"Выберите модель телефона собеседника, 1 - стационарный телефон, 2 - мобильный телефон, 3 - смартфон:");
		int type = scanner.nextInt();

		if (type < 1 || type > 3) {
			System.out.println("Введена неверная модель телефона");
			scanner.close();
			return;
		}
		scanner.close();
		getPhone(type, number).makeCall(friendNumber);
	}

	public static Phone getPhone(int type, String number) {
		if (type == 1) {
			// если выбран стационарный телефон, создайте объект класса LandlinePhone
			return new LandlinePhone(number);
		} else if (type == 2) {
			// если выбран мобильный телефон, создайте объект класса MobilePhone
			return new MobilePhone(number);
		} else {
			return new Smartphone(number);
		}
	}

}
