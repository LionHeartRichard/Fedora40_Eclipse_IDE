package waether;

import java.net.http.HttpClient;
import java.util.HashMap;

public class WeatherApplication {
	private HashMap<String, String> weatherData;

	private WeatherClient client;

	public WeatherApplication() {
		initializedData();
		client = new WeatherClient(HttpClient.newHttpClient());
	}

	// инициализация статических данных о погоде
	private void initializedData() {
		weatherData = new HashMap<>();
		weatherData.put("MOW", "Город: Москва. Облачно, +5°C");
		weatherData.put("LED", "Санкт-Петербург. Дождливо, +3°C");
		weatherData.put("KZN", "Город: Казань. Солнечно, +12°C");
	}

	// метод для отображения погоды
	public void displayWeather(String city) {
		System.out.println(client.getWeatherData(city));
	}
}
