package exchangegetrequestheaders;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HelloHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		/*
		 * Получаем заголовки запроса, выводим их в консоль и возвращаем в качестве тела
		 * ответа.
		 */

		Headers requestHeaders = exchange.getRequestHeaders();
		String response = "Request headers: \n" + requestHeaders.entrySet();
		System.out.println("Обработка запроса");

		exchange.sendResponseHeaders(200, 0);

		try (OutputStream os = exchange.getResponseBody()) {
			os.write(response.getBytes());
		}
	}

}
