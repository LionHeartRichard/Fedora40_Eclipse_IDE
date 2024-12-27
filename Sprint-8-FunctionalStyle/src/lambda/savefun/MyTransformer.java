package lambda.savefun;

import java.nio.file.Paths;

public class MyTransformer {
	public static void main(String[] args) {
		// создаём реализацию FileNameTransformer с помощью лямбда-функции
		FileNameTransformer transformer = filePath -> Paths.get(filePath).getFileName().toString();
		// вызываем сохранённый экземпляр лямбда-функции
		System.out.println(transformer.getFileName("/home/bigbrother/downloads/movie.mp4"));
	}
}
