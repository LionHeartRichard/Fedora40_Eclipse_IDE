package clientrequests.code;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CodeException {
	public static void main(String[] args) {
		/*
		 * Попробуйте заменить код статуса на какой-либо другой и посмотреть на реакцию
		 * вашего HTTP-клиента.
		 */
		int requestedStatus = 201;
		// указываем код состояния как часть URL-адреса
		URI uri = URI.create("http://httpbin.org/status/" + requestedStatus);
		HttpRequest request = HttpRequest.newBuilder().GET().uri(uri).build();

		HttpClient client = HttpClient.newHttpClient();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			int status = response.statusCode();
			// обрабатываем коды успешного состояния
			if (status >= 200 && status <= 299) {
				System.out.println("Сервер успешно обработал запрос. Код состояния: " + status);
				return;
			}
			// обрабатываем коды состояния, сообщающие об ошибке на стороне клиента
			if (status >= 400 && status <= 499) {
				System.out.println("Сервер сообщил о проблеме с запросом. Код состояния: " + status);
				return;
			}
			// обрабатываем коды состояния, сообщающие об ошибке на стороне сервера
			if (status >= 500 && status <= 599) {
				System.out.println("Сервер сообщил о внутренней проблеме и невозможности обработать запрос."
						+ " Код состояния: " + status);
			} else { // обрабатываем остальные коды состояния
				System.out.println("Что-то пошло не так. Сервер вернул код состояния: " + status);
			}
		} catch (IOException | InterruptedException e) { // обрабатываем ошибки отправки запроса
			System.out.println("Во время выполнения запроса ресурса по url-адресу: '" + uri + "' возникла ошибка.\n"
					+ "Проверьте, пожалуйста, адрес и повторите попытку.");
		}
	}
}