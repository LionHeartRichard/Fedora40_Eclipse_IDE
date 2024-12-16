package unicode;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

class Practicum {

	public static void main(String[] args) {
		// UTF-8
		System.out.println("\u041F\u0440\u0430\u043A\u0442\u0438\u043A\u0443\u043C");

		Charset charset1 = Charset.forName("UTF8");
		System.out.println(charset1.name());

		Charset charset2 = StandardCharsets.US_ASCII;
		System.out.println(charset2);

		System.out.println("кодировка по умолчанию: " + Charset.defaultCharset().displayName());

		// Запуск проги с явным указанием кодировки java -Dfile.encoding=UTF-8 Practicum
	}
}