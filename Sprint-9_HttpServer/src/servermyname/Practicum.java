package servermyname;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

class Practicum {
	private static final int PORT = 8080;

	public static void main(String[] args) throws IOException {
		HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
		httpServer.createContext("/hello", new PostHelloHandler());
		httpServer.start();
		System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
	}
}
