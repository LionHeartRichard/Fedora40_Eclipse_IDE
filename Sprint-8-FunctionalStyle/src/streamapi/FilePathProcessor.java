package streamapi;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilePathProcessor {
	public List<String> processFilePaths(List<String> paths) {
		List<String> result = paths
				// создаём стрим на основе списка
				.stream()
				// отфильтровываем из стрима файлы с расширением tmp
				.filter(filePath -> !filePath.endsWith(".tmp"))
				// заменяем в стриме каждый путь на имя файла
				.map(filePath -> Paths.get(filePath).getFileName().toString())
				// если файл является секретным, заменяем его название в стриме на
				// very_secret_file
				.map(fileName -> {
					if (fileName.startsWith("hide")) {
						return fileName.replace("hide", "very_secret_file");
					} else {
						return fileName;
					}
				})
				// преобразуем стрим обратно в список
				.collect(Collectors.toList());

		return result;
	}

	public static void main(String[] args) {
		List<String> paths = new ArrayList<>();
		paths.add("/home/bigbrother/docs/hide.txt");
		paths.add("hide.txt");
		paths.add("file3.tmp");
		paths.add("/home/bigbrother/downloads/movie.mp4");
		paths.add("/home/bigbrother/downloads/java_book.pdf");

		FilePathProcessor processor = new FilePathProcessor();
		List<String> processedPaths = processor.processFilePaths(paths);

		processedPaths.forEach(v -> System.out.println(v));
	}
}
