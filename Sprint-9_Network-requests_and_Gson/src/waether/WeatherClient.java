package waether;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherClient {

	private final HttpClient client;

	public WeatherClient(HttpClient client) {
		super();
		this.client = client;
	}

	public String getWeatherData(String codeCity) {
		URI uri = URI.create("https://functions.yandexcloud.net/d4eo3a1nvqedpic89160?scale=C&city="+codeCity);
		HttpRequest request = HttpRequest
				.newBuilder()
				.uri(uri)
				.header("Accept", "application/json")
				.GET().build();
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			int status = response.statusCode();
			if (status != 200) {
				return "Что-то пошло не так. Сервер вернул код состояния: " + status;
			}
			JsonElement jsonElement = JsonParser.parseString(response.body());
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			JsonObject jsonCities = jsonObject.get("cities").getAsJsonObject();
			JsonObject jsonCodeCity = jsonCities.get(codeCity).getAsJsonObject();
			String city = jsonCodeCity.get("city").getAsString();
			String conditions = jsonCodeCity.get("conditions").getAsString();
			String temperature = jsonCodeCity.get("temperature").getAsString();
			return "Город: " + city + "." + conditions + "," + temperature;
		} catch (IOException | InterruptedException e) {
			return "Во время выполнения запроса возникла ошибка.\n"
					+ "Проверьте, пожалуйста, адрес и повторите попытку.";
		}

	}

}
