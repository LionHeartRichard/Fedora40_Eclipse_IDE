package practicum.yandex.trainer.mytostring;

import java.util.ArrayList;
import java.util.Arrays;

class Post {
	private String title; // заголовок
	private String content; // содержание
	private String[] tags; // теги
	private ArrayList<PostComment> comments; // комментарии

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public ArrayList<PostComment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<PostComment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		String tmp;
		if (content == null) {
			tmp = ", content=" + content;
		} else {
			tmp = "content.length='" + content.length();
		}
		String result = "Post{title='" + title + "', " + tmp + "', tags=" + Arrays.toString(tags) + ", comments="
				+ comments + "}";
		return result;
	}

	/*
	 * Вывод должен получиться таким: Post{title='xxx', content.length='x',
	 * tags=[x,x], comments=[PostComment{text='x!', whoLiked=[x, x]},
	 * PostComment{text='x', whoLiked=[x,x]}, PostComment{text='x', whoLiked=null}]}
	 */

}
