package com.yandex.filesmanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Practicum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			while (true) {
				printMenu();
				String command = scanner.nextLine();
				System.out.println("Введите путь к файлу/директории: ");

				String enteredPath = scanner.nextLine();
				Path path = Paths.get(enteredPath);
				if (!Files.exists(path)) {
					System.out.println("Введённый путь не существует.");
					break;
				}
				switch (command) {
				case "exit":
					System.out.println("Выход.");
					System.exit(0); // пользователь хочет найти выход, выход есть всегда
					break;
				case "ls":
					try {
						for (String element : path.toFile().list()) {
							System.out.println(element);
						}
					} catch (Exception e) {
						System.out.println("Произошла ошибка при запросе содержимого директории.");
						e.printStackTrace();
					}
					break;
				case "mkdir":
					try {
						Files.createDirectory(path);
					} catch (IOException e) {
						System.out.println("Произошла ошибка при создании директории.");
						e.printStackTrace();
					}
					break;
				case "touch":
					try {
						Files.createFile(path);
					} catch (IOException e) {
						System.out.println("Произошла ошибка при создании файла.");
						e.printStackTrace();
					}
					break;
				case "rename":
					System.out.println("Введите новое имя файла/директории: ");
					String newName = scanner.nextLine();
					Path newPath = Paths.get(newName);
					try {
						Files.move(path, newPath, StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						System.out.println("Произошла ошибка при переименовании файла/директории.");
						e.printStackTrace();
					}
					break;
				case "rm_file":
					try {
						if (path.getFileName() != null) {
							Files.deleteIfExists(path);
						} else {
							System.out.println("С помощью этой команды можно удалить только файл!");
						}
					} catch (IOException e) {
						System.out.println("Произошла ошибка при удалении файла.");
						e.printStackTrace();
					}
					break;
				default:
					System.out.println("Извините, такой команды пока нет.");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	public static void printMenu() {
		System.out.println("Что вы хотите сделать? ");
		System.out.println("ls - посмотреть содержимое директории.");
		System.out.println("mkdir - создать директорию.");
		System.out.println("touch - создать файл.");
		System.out.println("rename - переименовать директорию/файл.");
		System.out.println("rm_file - удалить файл.");
		System.out.println("exit - выход.");
	}
}
