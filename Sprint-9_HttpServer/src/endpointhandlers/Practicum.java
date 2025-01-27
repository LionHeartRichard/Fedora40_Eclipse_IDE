package endpointhandlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.DayOfWeek;
import java.util.Random;

public class Practicum {
	private static final int PORT = 8080;

	// IOException могут сгенерировать методы create() и bind(...)
	public static void main(String[] args) throws IOException {
		HttpServer httpServer = HttpServer.create();

		httpServer.bind(new InetSocketAddress(PORT), 0);
		httpServer.createContext("/hello", new HelloHandler());
		// добавьте новый обработчик для /day тут
		httpServer.createContext("/day", new RandomDayOfWeekHandler());
		httpServer.start(); // запускаем сервер

		System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
		httpServer.stop(1); // завершение сервера необходимо для тренажёра
	}

	static class HelloHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange httpExchange) throws IOException {

			String response = "Hey! Glad to see you on our server.";
			httpExchange.sendResponseHeaders(200, 0);

			try (OutputStream os = httpExchange.getResponseBody()) {
				os.write(response.getBytes());
			}
		}
	}

	static class RandomDayOfWeekHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange exchange) throws IOException {

			System.out.println("Началась обработка /day запроса от клиента.");

			Random random = new Random();
			String currentDayOfWeek = DayOfWeek.of(random.nextInt(7) + 1).toString();

			exchange.sendResponseHeaders(201, 0);

			try (OutputStream os = exchange.getResponseBody()) {
				os.write(currentDayOfWeek.getBytes());
			}
		}

	}
}
