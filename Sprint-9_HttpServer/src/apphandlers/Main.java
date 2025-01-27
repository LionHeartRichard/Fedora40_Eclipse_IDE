package apphandlers;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class Main {

	private static final int PORT = 8080;

	public static void main(String[] args) throws IOException {
		// 1-й параметр порт, 2й backlog - количество возможных запросов в очереди на
		// обработку
		HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
		// связываем конкретный путь и его обработчик
		httpServer.createContext("/hello", new HelloHandler());
		/*
		 * Метод createContext(String path, HttpHandler handler) принимает следующие
		 * параметры: String path — это путь, запросы к которому нужно обработать. В
		 * нашем примере это строка "/hello". HttpHandler handler — экземпляр класса,
		 * реализующего интерфейс HttpHandler. В этом классе должна содержаться логика
		 * обработки запросов. В нашем примере это класс HelloHandler созданный ранее.
		 * Пользователи смогут обратиться к созданному эндпоинту по адресу
		 * http://server-address:8080/hello в браузере.
		 */

		httpServer.start();
		System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
	}
}
