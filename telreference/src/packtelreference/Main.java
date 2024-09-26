package packtelreference;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ContactLsit contacts = new ContactLsit(10);
		System.out.println("Вас приветствует телефонный справочник");

		while (true) {
			printMenu();
			if (scanner.hasNextInt()) {
				int cmd = scanner.nextInt();
				if (cmd == 1) {
					System.out.print("Введите имя: ");
					String name = scanner.next();
					System.out.print("Введите номер телефона: ");
					String phone = scanner.next();
					contacts.addContact(name, phone);
				} else if (cmd == 2) {
					System.out.print("Введите имя, для поиска: ");
					String name = scanner.next();
					Contact contact = contacts.findContactByName(name);
					if (contact != null) {
						System.out.print("Номер телефона искомого контакта: ");
						System.out.print(contact.getPhone());
						System.out.println();
					} else {
						System.out.println("Контакт не найден");
					}
				} else if (cmd == 3) {
					contacts.printAllContacts();
				} else if (cmd == 4) {
					System.out.println("Вы уверенны, что хотите очистить список контактов? (да/нет)");
					String isDelete = scanner.next();
					if (isDelete.equals("да") || isDelete.equals("y")) {
						contacts.clearContactList();
					}
				} else if (cmd == 0) {
					break;
				} else {
					System.out.println("Введена неизвестная комманда!!!");
				}
			} else {
				scanner.next();
				System.out.println("Введены не валидные данные!!!");
				continue;
			}
			System.out.println();
			System.out.println("-".repeat(20));
		}
		System.out.println("Работа программы завершена!!! Отличного настроения!!!");
		scanner.close();
	}

	private static void printMenu() {
		System.out.println("Для добавления контакта введите - 1");
		System.out.println("Поиск контакта по имени         - 2");
		System.out.println("Отобразить контакты             - 3");
		System.out.println("Очистить список контактов       - 4");
		System.out.println("Завершение работы программы     - 0");
	}

}
