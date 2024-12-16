package alias;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Practicum {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Введите количество участников: ");
			int playersNumber = scanner.nextInt();

			List<String> words = readWordsFromFile("words.txt");

			if (words.size() < playersNumber) {
				System.out.println("Недостаточно слов в файле. Добавьте слова и обновите файл.");
				System.exit(0);
			}
			// если слов меньше, чем участников, то выведите сообщение:
			//
			// и завершите выполнение программы

			// воспользуйтесь статическим методом Collections.shuffle(List<?> list),
			// чтобы поменять порядок слов случайным образом

			Collections.shuffle(words);

			int wordsNumber = words.size() / playersNumber;

			for (int i = 0; i < playersNumber; i++) {
				String filename = String.format("player%s.txt", i + 1);
				List<String> subList = words.subList(i * wordsNumber, (i + 1) * wordsNumber);

				writeListToFile(subList, filename);
			}
			System.out.println("Карточки готовы!");
		} catch (Exception e) {
//			System.err.println("Что-то пошло не так!");
//			e.printStackTrace();
		}
	}

	private static List<String> readWordsFromFile(String fileName) {
		try (FileReader reader = new FileReader(fileName); BufferedReader buffered = new BufferedReader(reader)) {
			List<String> words = new ArrayList<>();
			while (buffered.ready()) {
				words.add(buffered.readLine());
			}
			return words;
		} catch (IOException e) {
			System.err.println("Произошла ошибка во время чтения файла.");
		}
		return null;
	}

	private static void writeListToFile(List<String> words, String fileName) {
		try (FileWriter writer = new FileWriter(fileName)) {
			for (String word : words) {
				writer.write(word);
			}
		} catch (IOException e) {
			System.err.println("Произошла ошибка во время записи файла.");
		}
	}
}
