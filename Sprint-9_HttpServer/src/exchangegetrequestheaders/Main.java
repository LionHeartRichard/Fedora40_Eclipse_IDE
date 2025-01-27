package exchangegetrequestheaders;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class Main {

	private static final int PORT = 8080;

	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
		server.createContext("/hello", new HelloHandler());
		server.start();
		System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
	}

}
