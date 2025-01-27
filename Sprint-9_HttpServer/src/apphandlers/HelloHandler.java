package apphandlers;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HelloHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange httpExchange) throws IOException {

		System.out.println("Началась обработка /hello запроса от клиента.");

		// формируем ответ клиенту в виде простой строки и кода ответа 200
		// устанавливаем код ответа и отправляем его вместе с заголовками по умолчанию
		httpExchange.sendResponseHeaders(200, 0);

		// отправляем тело ответа, записывая строку в выходящий поток
		String response = "Hey! Glad to see you on our server.";
		try (OutputStream os = httpExchange.getResponseBody()) {
			os.write(response.getBytes());
		}

	}

}
