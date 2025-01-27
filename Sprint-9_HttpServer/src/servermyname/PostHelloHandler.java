package servermyname;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

class PostHelloHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		// считываем тело запроса и преобразуем в строку
		InputStream inputStream = exchange.getRequestBody();
		String name = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
		System.out.println("Тело запроса:\n" + name);

		exchange.sendResponseHeaders(200, 0);

		try (OutputStream os = exchange.getResponseBody()) {
			String response = "Привет " + name + "! Рады видеть на нашем сервере.";
			os.write(response.getBytes());
		}
	}

}
