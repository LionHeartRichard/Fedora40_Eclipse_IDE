package exchangerespons;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

class HelloHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		// добавляем заголовки в ответ
		Headers headers = exchange.getResponseHeaders();
		headers.set("Content-Type", "text/plain; charset=utf-8");
		headers.set("X-your-own-header", "any-information-you-want");
		headers.set("X-your-own-header-2", "any-information-you-want-2");

		// отправляем стартовую строку и настроенные заголовки ответа
		exchange.sendResponseHeaders(200, 0);

		try (OutputStream os = exchange.getResponseBody()) {
			os.write("Привет! Рады видеть на нашем сервере.".getBytes());
		}
	}
}
