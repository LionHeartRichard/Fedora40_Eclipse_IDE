package finaltasks;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

class PostsHandler implements HttpHandler {

	private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		String requestPath = exchange.getRequestURI().toString();
		String requestMethod = exchange.getRequestMethod();

		Endpoint endpoint = getEndpoint(requestPath, requestMethod);

		switch (endpoint) {
		case GET_POSTS: {
			writeResponse(exchange, "Получен запрос на получение постов", 200);
			break;
		}
		case GET_COMMENTS: {
			writeResponse(exchange, "Получен запрос на получение комментариев", 200);
			break;
		}
		case POST_COMMENT: {
			writeResponse(exchange, "Получен запрос на добавление комментария", 200);
			break;
		}
		default:
			writeResponse(exchange, "Такого эндпоинта не существует", 404);
		}
	}

	private Endpoint getEndpoint(String requestPath, String requestMethod) {
		String[] uri = requestPath.split("/");
		if (requestMethod.equals("GET")) {
			if (uri.length == 4) {
				return Endpoint.GET_COMMENTS;
			}
			return Endpoint.GET_POSTS;
		}
		if (requestMethod.equals("POST")) {
			return Endpoint.POST_COMMENT;
		}
		return Endpoint.UNKNOWN;
	}

	private void writeResponse(HttpExchange exchange, String responseString, int responseCode) throws IOException {
		if (responseString == null || responseString.isEmpty()) {
			exchange.sendResponseHeaders(responseCode, 0);
		} else {
			exchange.sendResponseHeaders(responseCode, 0);
			try (OutputStream os = exchange.getResponseBody()) {
				os.write(responseString.getBytes());
			}
		}
	}

	enum Endpoint {
		GET_POSTS, GET_COMMENTS, POST_COMMENT, UNKNOWN
	}
}

public class Practicum {
	private static final int PORT = 8080;

	public static void main(String[] args) throws IOException {
		HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
		httpServer.createContext("/posts", new PostsHandler());
		httpServer.start();
		System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
		// завершаем работу сервера для корректной работы тренажёра
		httpServer.stop(1);
	}
}
