package begin.builder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainNull {
	public static void main(String[] args) {
		UserPost post = new UserPost();
		post.setUserId(97_748);
		post.setLikesQuantity(753);

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();

		String postSerialized = gson.toJson(post);
		System.out.println(postSerialized);
	}
}
