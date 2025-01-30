package clientrequests.nameagify;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UsedHttpServiceAgify {
	public static void main(String[] args) {
		HttpClient client = HttpClient.newHttpClient();

		// делаем запрос с параметром name
		URI url = URI.create("https://api.agify.io/?name=Pixel");
		HttpRequest request = HttpRequest.newBuilder().uri(url).GET().build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println("Код состояния: " + response.statusCode());
			// в ответе будет содержаться предсказанный сервисом возраст
			System.out.println("Ответ: " + response.body());
		} catch (IOException | InterruptedException e) { // обрабатываем ошибки отправки запроса
			System.out.println("Во время выполнения запроса ресурса по url-адресу: '" + url + "', возникла ошибка.\n"
					+ "Проверьте, пожалуйста, адрес и повторите попытку.");
		}
	}
}
