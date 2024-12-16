package unicode.bytesarray;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.io.Writer;
import java.util.Arrays;

class Practicum {
	public static void main(String[] args) {
		String s = "Обычная строка.";
		byte[] buffer = s.getBytes(StandardCharsets.UTF_8);
		System.out.println(Arrays.toString(buffer));

		// преобразование из массива байтов в строку
		s = new String(buffer, StandardCharsets.UTF_8);
		System.out.println(s);

		try (Writer out = new OutputStreamWriter(System.out, StandardCharsets.UTF_8)) {
			out.write(decodeText("Съешь ещё этих мягких французских булок да выпей же чаю"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static String decodeText(String input) throws IOException {
		return new BufferedReader(new InputStreamReader(
				new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8)).readLine();
	}
}
