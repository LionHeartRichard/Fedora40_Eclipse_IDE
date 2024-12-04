package com.yandex.basic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/*
 * REPLACE_EXISTING — указывает, что если в директории назначения уже есть такой файл, то нужно его заменить;
 * COPY_ATTRIBUTES — указывает, что нужно скопировать атрибуты оригинального файла в его копию;
 * ATOMIC_MOVE — указывает, что необходимо переместить файл атомарно. Это значит, что перемещение или выполнится целиком, или не выполнится вообще.
 */

class Practicum {

	private static final String HOME = "/home/kerrigan_kein/tests_dir/";
	private static final String NAME_FILE = "test.txt";

	public static void main(String[] args) throws IOException {

		// создаём объект Path с помощью статического метода get() класса Paths
		Path testFilePath = Paths.get(HOME, NAME_FILE);

		// выводим информацию о файле
		System.out.println("Информация о файле: ");
		System.out.println(" - имя: " + testFilePath.getFileName());
		System.out.println(" - корневая директория: " + testFilePath.getRoot());
		System.out.println(" - родительская директория: " + testFilePath.getParent());

		// выводим элементы пути
		System.out.println("Элементы пути: ");
		for (Path element : testFilePath) {
			System.out.println(" - элемент пути: " + element);
		}

		// -----------------__Files___--------------------------
		System.out.println("_".repeat(50) + "FILES" + "_".repeat(50));

		// создаём файл testFile
		Path testFile = Files.createFile(Paths.get(HOME, "testFile.txt"));

		if (Files.exists(Paths.get(HOME, "testFile.txt"))) {
			System.out.println("Файл успешно создан.");
		}

		// создаём директорию testDirectory
		Path testDirectory = Files.createDirectory(Paths.get(HOME, "New_test_Directory"));
		if (Files.exists(Paths.get(HOME, "New_test_Directory"))) {
			System.out.println("Директория успешно создана.");
		}

		// перемещаем файл testFile в директорию testDirectory
		testFile = Files.move(testFile, Paths.get(HOME, "New_test_Directory", "testFile.txt"), REPLACE_EXISTING);

		if (Files.exists(Paths.get(HOME, "New_test_Directory", "testFile.txt"))) {
			System.out.println("Файл перемещён в testDirectory.");
		}
		// удаляем файл
		Files.delete(testFile);
		if (!Files.exists(Paths.get(HOME, "testDirectory", "testFile.txt"))) {

			System.out.println("Тестовый файл удалён.");
		}

		// удаляем пустую директорию
		Files.delete(testDirectory);
		if (!Files.exists(Paths.get(HOME, "testDirectory"))) {
			System.out.println("Директория удалена.");
		}
	}
}
