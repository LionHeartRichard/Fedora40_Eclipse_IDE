package practicum.yandex.trainer.mytostring;

import java.util.Arrays;

class PostComment {
	private String text; // содержание комментария
	private String[] whoLiked; // кто поддержал

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String[] getWhoLiked() {
		return whoLiked;
	}

	public void setWhoLiked(String[] whoLiked) {
		this.whoLiked = whoLiked;
	}

	@Override
	public String toString() {
		return "PostComment{text='" + text + "', whoLiked=" + Arrays.toString(whoLiked) + "}";
	}

}
