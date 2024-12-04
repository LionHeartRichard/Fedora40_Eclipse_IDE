package com.yandex.filesmanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

class Practicum {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            String command = scanner.nextLine();

            System.out.println("Введите путь к файлу/директории: ");
            String enteredPath = scanner.nextLine();
            Path path = ??? // создайте переменную пути
            if (!???) { // проверьте, не ошибся ли пользователь
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
                        for (String element : ? список элементов в path?) {
                            System.out.println(???);
                        }
                    } catch (Exception e) {
                        System.out.println("Произошла ошибка при запросе содержимого директории.");
                        e.printStackTrace();
                    }
                    break;

                case "mkdir":
                    try {
                        ???
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при создании директории.");
                        e.printStackTrace();
                    }
                    break;
                case "touch":
                    try {
                        ???
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при создании файла.");
                        e.printStackTrace();
                    }
                    break;
                case "rename":
                    System.out.println("Введите новое имя файла/директории: ");
                    String newName = scanner.nextLine();

                    try {
                        ??? // с помощью опции StandardCopyOption.REPLACE_EXISTING
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при переименовании файла/директории.");
                        e.printStackTrace();
                    }
                    break;
                case "rm_file":
                    try {
                        if (!???) {
                            ???
                        } else {
                            System.out.println("С помощью этой команды можно удалить только файл!");
                        }
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при удалении файла.");
                        e.printStackTrace();
                    }
                default:
                    System.out.println("Извините, такой команды пока нет.");
            }

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
