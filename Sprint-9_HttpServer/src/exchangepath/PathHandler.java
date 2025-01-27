package exchangepath;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

class PathHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		// получаем путь, на который пришел запрос
		String pathURI = exchange.getRequestURI().getPath();

		// разбиваем путь на компоненты и берём последний
		String[] uri = pathURI.split("/");
		String name = uri[uri.length - 1];
		System.out.println("Имя: " + name);

		exchange.sendResponseHeaders(200, 0);

		try (OutputStream os = exchange.getResponseBody()) {
			String response = "Привет, " + name + "!";
			os.write(response.getBytes());
		}
	}

}
