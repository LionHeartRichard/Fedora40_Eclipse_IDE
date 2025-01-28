package begin.gsondesirializer;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

class Practicum {
	public static void main(String[] args) {
		UserPost post = new UserPost();
		post.setPhotoUrl("https://new-social-network.site/images/928476864.jpg");
		post.setUserId(97_748);
		post.setDescription("Классное фото!");
		post.setLikesQuantity(753);

		Gson gson = new Gson();

		String postSerialized = gson.toJson(post);
		System.out.println("Serialized post: " + postSerialized);

		// десериализуйте объект
		UserPost postDeserialized = gson.fromJson(postSerialized, UserPost.class);
		System.out.println("Deserialized post: " + postDeserialized);
	}
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class UserPost {
	private String photoUrl;
	private int userId;
	private String description;
	private int likesQuantity;

	@Override
	public String toString() {
		return "UserPost{" + "photoUrl='" + photoUrl + '\'' + ", userId=" + userId + ", description='" + description
				+ '\'' + ", likesQuantity=" + likesQuantity + '}';
	}
}
