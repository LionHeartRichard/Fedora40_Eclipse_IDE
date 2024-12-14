package pathsandfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * Files.walk(Paths.get("/path/to/folder"))
 .filter(Files::isRegularFile)
 .collect(Collectors.toList())
 
 *
 *List<Path> listFiles = Files.walk(path).filter(Files::isRegularFile).collect(Collectors.toList());
 */

public class MyFilesManager {

	private static Set<String> commands = new HashSet<>(Arrays.asList("ls", "mkdir", "rename", "rm_file", "touch"));

	private static Scanner scanner = new Scanner(System.in);

	private static interface Handler {
		boolean action(Path path);
	}

	private static class Ls implements Handler {
		@Override
		public boolean action(Path path) {
			try {
				File file = path.toFile();
				for (String element : file.list()) {
					System.out.println(element);
				}
				return true;
			} catch (Exception e) {
				System.out.println("Произошла ошибка при запросе содержимого директории.");
				e.printStackTrace();
				return false;
			}
		}
	}

	private static class Mkdir implements Handler {
		@Override
		public boolean action(Path path) {
			try {
				Files.createDirectory(path);
				return true;
			} catch (IOException e) {
				System.out.println("Произошла ошибка при создании директории.");
				e.printStackTrace();
				return false;
			}
		}
	}

	private static class Rename implements Handler {
		@Override
		public boolean action(Path path) {
			System.out.println("Введите новое имя файла/директории: ");
			String newName = scanner.nextLine();
			Path newPath = Paths.get(newName);
			try {
				Files.move(path, newPath, StandardCopyOption.REPLACE_EXISTING);
				return true;
			} catch (IOException e) {
				System.out.println("Произошла ошибка при переименовании файла/директории.");
				e.printStackTrace();
				return false;
			}
		}

	}

	private static class Touch implements Handler {
		@Override
		public boolean action(Path path) {
			try {
				Files.createFile(path);
				return true;
			} catch (IOException e) {
				System.out.println("Произошла ошибка при создании файла.");
				e.printStackTrace();
				return false;
			}
		}
	}

	private static class Rm implements Handler {
		@Override
		public boolean action(Path path) {
			try {
				if (path.getFileName() != null) {
					Files.deleteIfExists(path);
					return true;
				}
				System.out.println("С помощью этой команды можно удалить только файл!");
				return false;

			} catch (IOException e) {
				System.out.println("Произошла ошибка при удалении файла.");
				e.printStackTrace();
				return false;
			}
		}
	}

	public static void main(String[] args) {
		try {
			while (true) {
				printMenu();
				String command = scanner.nextLine();
				if (command.equals("exit")) {
					System.out.println("Выход.");
					System.exit(0);
					break;
				}
				if (!commands.contains(command)) {
					System.out.println("Извините, такой команды пока нет.");
					continue;
				}

				System.out.println("Введите путь к файлу/директории: ");
				String enteredPath = scanner.nextLine();

				Path path = getValidPath(enteredPath);

				Map<String, Handler> commandsHandler = getHandler(path);
				Handler handler = commandsHandler.get(command);
				if (!handler.action(path))
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	private static Map<String, Handler> getHandler(Path path) {
		Map<String, Handler> handler = new HashMap<>();
		handler.put("ls", new Ls());
		handler.put("rename", new Rename());
		handler.put("touch", new Touch());
		handler.put("mkdir", new Mkdir());
		handler.put("rm_file", new Rm());
		return handler;
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

	private static Path getValidPath(String path) throws IOException {
		if (path != null && !path.isEmpty()) {
			Path result = Paths.get(path);
			if (result.toFile() != null) {
				return result;
			}
		}
		System.out.println("Введённый путь не существует.");
		throw new IOException();
	}
}
