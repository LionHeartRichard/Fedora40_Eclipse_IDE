package begin.builder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Main {

	public static void main(String[] args) {
		UserPost post = new UserPost();
		post.setPhotoUrl("https://new-social-network.site/images/928476864.jpg");
		post.setUserId(97_748);
		post.setDescription("Классное фото!");
		post.setLikesQuantity(753);

		GsonBuilder gsonBuilder = new GsonBuilder();
		
		gsonBuilder.setPrettyPrinting();
//		включает читабельность JSON в ущерб скорости
//		{
//			  "photoUrl": "https://new-social-network.site/images/928476864.jpg",
//			  "userId": 97748,
//			  "description": "Классное фото!",
//			  "likesQuantity": 753
//			}
		
		Gson gson = gsonBuilder.create();

		String postSerialized = gson.toJson(post);
		System.out.println(postSerialized);
	}

}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class UserPost {
// URL-адрес, по которому можно скачать фото
	private String photoUrl;
// уникальный идентификатор автора поста
	private int userId;
// текстовой комментарий к фото
	private String description;
// сколько пользователей поставило лайк этому посту
	private int likesQuantity;
}
