package clientrequests;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class Practicum {

	public static void main(String[] args) throws IOException, InterruptedException {
		// создаём экземпляр URI, содержащий адрес нужного ресурса
		URI uri = URI.create("https://ru.wikipedia.org/wiki/Список_кодов_состояния_HTTP");
		// создаём объект, описывающий HTTP-запрос
		HttpRequest request = HttpRequest.newBuilder() // получаем экземпляр билдера
				.GET() // указываем HTTP-метод запроса
				.uri(uri) // указываем адрес ресурса
				.version(HttpClient.Version.HTTP_1_1) // указываем версию протокола
				.header("Accept", "text/html") // указываем заголовок Accept
				.build(); // заканчиваем настройку и создаём ("строим") http-запрос

		// HTTP-клиент с настройками по умолчанию
		HttpClient client = HttpClient.newHttpClient();

		// получаем стандартный обработчик тела запроса с конвертацией содержимого в
		// строку
		HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();

		// отправляем запрос и получаем ответ от сервера
		HttpResponse<String> response = client.send(request, handler);

		// выводим код состояния и тело ответа
		System.out.println("Код ответа: " + response.statusCode());
		System.out.println("Тело ответа: " + response.body());
	}
}
