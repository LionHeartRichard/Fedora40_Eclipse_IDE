package begin.builder.adapter;

import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainDatePost {
	public static void main(String[] args) {
		UserDatePost post = new UserDatePost();
		post.setPhotoUrl("https://new-social-network.site/images/928476864.jpg");
		post.setUserId(97_748);
		post.setDescription("Классное фото!");
		post.setLikesQuantity(753);
		LocalDate publicationDate = LocalDate.of(2020, 12, 25);
		post.setPublishDate(publicationDate);

		Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
				.create();

		// сериализуем объект в JSON
		String postSerialized = gson.toJson(post);
		// Дата теперь отображается как 25--12--2020
		System.out.println("Serialized post:\n" + postSerialized);

		// заменим дату в JSON на другой формат
		String jsonWithAnotherDateFormat = postSerialized.replace("25--12--2020", "25.12.2020");

		System.out.println("New json:\n" + jsonWithAnotherDateFormat);

		// сконвертируем дату в формате 25.12.2020 в объект LocalDate
		UserDatePost postDeserialized = gson.fromJson(jsonWithAnotherDateFormat, UserDatePost.class);
		System.out.println("Deserialized post:\n" + postDeserialized);

	}

}
