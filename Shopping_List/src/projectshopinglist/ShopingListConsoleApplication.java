package projectshopinglist;

import java.util.Scanner;

public class ShopingListConsoleApplication {

	private static String[] shopingList;
	private static int idxProduct = 0;
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("Вас приветствует список покупок!");

		scanner = new Scanner(System.in);
		shopingList = new String[12];
		int actionNumber = 4;

		while (true) {
			System.out.println("Выберите одну из команд:");
			System.out.println("1. Добавить товар/товары в список");
			System.out.println("2. Показать список");
			System.out.println("3. Очистить список");
			System.out.println("4. Завершить работу");

			if (scanner.hasNextInt()) {
				actionNumber = scanner.nextInt();
			} else {
				scanner.next();
				System.out.println("Не корректный ввод!");
				continue;
			}

			if (actionNumber == 1) {
				addProductByShopingList();
			} else if (actionNumber == 2) {
				printShopingList();
			} else if (actionNumber == 3) {
				clearShopingList();
			} else if (actionNumber == 4) {
				scanner.close();
				break;
			} else {
				System.out.println("Неизвестная команда!");
			}
		}
		System.out.println("Работа программы завершена!!!");
	}

	private static void clearShopingList() {
		for (int i = 0; i < shopingList.length; ++i)
			shopingList[i] = "";
		idxProduct = 0;
		System.out.println("Список покупок очищен!!!");
		System.out.println();
	}

	private static void printShopingList() {
		System.out.println();
		System.out.println("Текущий список покупок:");
		for (int i = 0; i < shopingList.length; ++i) {
			if (shopingList[i] == null || shopingList[i].isEmpty()) {
				System.out.println();
				return;
			}
			System.out.println((i + 1) + ") " + shopingList[i]);
			if ((i + 1) % 5 == 0)
				System.out.println();
		}
		System.out.println();
	}

	private static void addProductByShopingList() {
		System.out.println("Введите товары в список, для завершения ввода, введите отдельно от покупок точку");
		while (scanner.hasNext()) {
			String currentProduct = scanner.next();
			if (currentProduct == null || currentProduct.equals("."))
				return;

			if (checkRepetition(currentProduct)) {
				continue;
			}

			if (idxProduct >= shopingList.length) {
				String swapArray[] = getSwapArray();
				shopingList = new String[idxProduct * 2];
				addSwapArrayInShopingList(swapArray);
			}
			shopingList[idxProduct++] = currentProduct;
		}
	}

	private static void addSwapArrayInShopingList(String[] swapArray) {
		for (idxProduct = 0; idxProduct < swapArray.length; ++idxProduct) {
			shopingList[idxProduct] = swapArray[idxProduct];
		}
	}

	private static String[] getSwapArray() {
		String[] swapArray = new String[shopingList.length];
		for (int i = 0; i < swapArray.length; ++i) {
			swapArray[i] = shopingList[i];
		}
		return swapArray;
	}

	private static boolean checkRepetition(String currentProduct) {
		int i = 0;
		while (i < shopingList.length && shopingList[i] != null) {
			if (shopingList[i++].equals(currentProduct))
				return true;
		}
		return false;
	}

}
