package tranerrquests;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

class HelloHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		String response;

		String method = httpExchange.getRequestMethod();

		switch (method) {
		case "POST":
			response = handlePostRequest(httpExchange);
			break;
		case "GET":
			response = handleGetRequest(httpExchange);
			break;
		default:
			response = "Некорректный метод!";
			httpExchange.sendResponseHeaders(400, 0);
			return;
		}

		httpExchange.sendResponseHeaders(200, 0);
		try (OutputStream os = httpExchange.getResponseBody()) {
			os.write(response.getBytes());
		}
	}

	private static String handleGetRequest(HttpExchange httpExchange) {
		return "Здравствуйте!";
	}

	private static String handlePostRequest(HttpExchange httpExchange) throws IOException {
		String path = httpExchange.getRequestURI().getPath();
		String[] uri = path.split("/");
		String profession = "";
		String name = "";
		if (uri.length == 4) {
			profession = uri[2];
			name = uri[3];
		}

		InputStream inputStream = httpExchange.getRequestBody();
		String body = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

		String response = body + ", " + profession + " " + name + "!";

		Headers requestHeaders = httpExchange.getRequestHeaders();
		List<String> wishGoodDay = requestHeaders.getOrDefault("X-Wish-Good-Day", null);

		if (body.equals("Доброе утро") && wishGoodDay != null && wishGoodDay.get(0).equals("true")) {
			return response + " Хорошего дня!";
		}
		return response;
	}
}
