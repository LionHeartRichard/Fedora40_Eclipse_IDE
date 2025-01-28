package begin.task;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;

class LastLikeInfo {
	String user;
	int hours;
	int minutes;

	public LastLikeInfo() {
		super();

	}

	public LastLikeInfo(String user, int hours, int minutes) {
		super();
		this.user = user;
		this.hours = hours;
		this.minutes = minutes;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

}

public class Practicum {

	public static void main(String[] args) throws IOException {
		String lastLikeInfoStr = "{ \"user\": \"Алексей\", \"hours\": 12, \"minutes\": 30}";

		Gson gson = new Gson();
		LastLikeInfo lastLikeInfo = gson.fromJson(lastLikeInfoStr, LastLikeInfo.class);

		LikesInfo likesInfo = new LikesInfo();
		likesInfo.setRepostsCount(10);
		likesInfo.setHasOwnerLiked(true);
		likesInfo.setLikes(new Like[] { new Like("Алексей", "http://example.com/avatars/aleksey.jpg"),
				new Like("Елена", "http://example.com/avatars/elena.jpg"),
				new Like("Света", "http://example.com/avatars/sveta.jpg"), });

		likesInfo.setLastLikeInfo(lastLikeInfo);

		String ans = gson.toJson(likesInfo);
		System.out.println(ans);
	}
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class LikesInfo {
	private boolean hasOwnerLiked;
	private Like[] likes;
	private int repostsCount;
	private LastLikeInfo lastLikeInfo;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class Like {
	private String name;
	private String avatarUrl;
}
