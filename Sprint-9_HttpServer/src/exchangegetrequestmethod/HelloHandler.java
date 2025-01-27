package exchangegetrequestmethod;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

class HelloHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		String method = exchange.getRequestMethod();
		System.out.println("Началась обработка " + method + " /hello запроса от клиента.");
		String response;
		switch (method) {
		case "POST":
			response = "Вы использовали метод POST!";
			break;
		case "GET":
			response = "Вы использовали метод GET!";
			break;
		default:
			response = "Вы использовали какой-то другой метод!";
		}

		exchange.sendResponseHeaders(200, 0);

		try (OutputStream os = exchange.getResponseBody()) {
			os.write(response.getBytes());
		}
	}

}
