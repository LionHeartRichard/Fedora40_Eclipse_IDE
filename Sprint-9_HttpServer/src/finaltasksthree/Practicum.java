package finaltasksthree;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class PostsHandler implements HttpHandler {
	private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	private final List<Post> posts;

	public PostsHandler(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		Endpoint endpoint = getEndpoint(exchange.getRequestURI().getPath(), exchange.getRequestMethod());

		switch (endpoint) {
		case GET_POSTS: {
			handleGetPosts(exchange);
			break;
		}
		case GET_COMMENTS: {
			handleGetComments(exchange);
			break;
		}
		case POST_COMMENT: {
			handlePostComments(exchange);
			break;
		}
		default:
			writeResponse(exchange, "Такого эндпоинта не существует", 404);
		}
	}

	private void handlePostComments(HttpExchange exchange) throws IOException {
		Optional<Integer> postIdOpt = getPostId(exchange);
		if (postIdOpt.isEmpty()) {
			writeResponse(exchange, "Некорректный идентификатор поста", 400);
			return;
		}
		int postId = postIdOpt.get();
		Optional<Comment> optComment = parseComment(exchange.getRequestBody());
		if (optComment.isEmpty()) {
			writeResponse(exchange, "Поля комментария не могут быть пустыми", 400);
			return;
		}
		for (int idx = 0; idx < posts.size(); ++idx) {
			Post post = posts.get(idx);
			if (post.getId() == postId) {
				Comment comment = optComment.get();
				posts.get(idx).addComment(comment);
				writeResponse(exchange, "Комментарий добавлен", 201);
				return;
			}
		}
		writeResponse(exchange, "Пост с идентификатором " + postId + " не найден", 404);
	}

	private Optional<Comment> parseComment(InputStream bodyInputStream) throws IOException {
		if (bodyInputStream == null)
			return Optional.empty();
		String body = new String(bodyInputStream.readAllBytes(), DEFAULT_CHARSET);
		String[] fields = body.split("\n");
		if (fields.length == 1 || fields[0].isEmpty() || fields[1].isEmpty())
			return Optional.empty();
		String name = fields[0];
		int beginIdx = body.indexOf(fields[1]);
		String text = body.substring(beginIdx);
		return Optional.of(new Comment(name, text));
	}

	private void handleGetPosts(HttpExchange exchange) throws IOException {
		String response = posts.stream().map(Post::toString).collect(Collectors.joining("\n"));
		writeResponse(exchange, response, 200);
	}

	private void handleGetComments(HttpExchange exchange) throws IOException {
		Optional<Integer> postIdOpt = getPostId(exchange);
		if (postIdOpt.isEmpty()) {
			writeResponse(exchange, "Некорректный идентификатор поста", 400);
			return;
		}
		int postId = postIdOpt.get();

		for (Post post : posts) {
			if (post.getId() == postId) {
				String response = post.getComments().stream().map(Comment::toString).collect(Collectors.joining("\n"));
				writeResponse(exchange, response, 200);
				return;
			}
		}

		writeResponse(exchange, "Пост с идентификатором " + postId + " не найден", 404);
	}

	private Optional<Integer> getPostId(HttpExchange exchange) {
		String[] pathParts = exchange.getRequestURI().getPath().split("/");
		try {
			return Optional.of(Integer.parseInt(pathParts[2]));
		} catch (NumberFormatException exception) {
			return Optional.empty();
		}
	}

	private Endpoint getEndpoint(String requestPath, String requestMethod) {
		String[] pathParts = requestPath.split("/");

		if (pathParts.length == 2 && pathParts[1].equals("posts")) {
			return Endpoint.GET_POSTS;
		}
		if (pathParts.length == 4 && pathParts[1].equals("posts") && pathParts[3].equals("comments")) {
			if (requestMethod.equals("GET")) {
				return Endpoint.GET_COMMENTS;
			}
			if (requestMethod.equals("POST")) {
				return Endpoint.POST_COMMENT;
			}
		}
		return Endpoint.UNKNOWN;
	}

	private void writeResponse(HttpExchange exchange, String responseString, int responseCode) throws IOException {
		try (OutputStream os = exchange.getResponseBody()) {
			exchange.sendResponseHeaders(responseCode, 0);
			os.write(responseString.getBytes(DEFAULT_CHARSET));
		}
		exchange.close();
	}

	enum Endpoint {
		GET_POSTS, GET_COMMENTS, POST_COMMENT, UNKNOWN
	}
}

public class Practicum {
	private static final int PORT = 8080;

	public static void main(String[] args) throws IOException {
		// инициализация начальных данных
		List<Post> posts = new ArrayList<>();
		Post post1 = new Post(1, "Это первый пост, который я здесь написал.");
		post1.addComment(new Comment("Пётр Первый", "Я успел откомментировать первым!"));
		posts.add(post1);

		Post post2 = new Post(22, "Это будет второй пост. Тоже короткий.");
		posts.add(post2);

		Post post3 = new Post(333, "Это пока последний пост.");
		posts.add(post3);

		// настройка и запуск HTTP-сервера
		HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
		httpServer.createContext("/posts", new PostsHandler(posts));
		httpServer.start(); // запускаем сервер

		System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
		// завершаем работу сервера для корректной работы тренажёра
		// httpServer.stop(1);
	}
}

class Post {
	private int id;
	private String text;
	private List<Comment> comments = new ArrayList<>();

	public Post(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public List<Comment> getComments() {
		return comments;
	}

	@Override
	public String toString() {
		return "Post{" + "id=" + id + ", text='" + text + '\'' + ", comments=" + comments + '}';
	}
}

class Comment {
	private String user;
	private String text;

	public Comment(String user, String text) {
		this.user = user;
		this.text = text;
	}

	@Override
	public String toString() {
		return "Comment{" + "user='" + user + '\'' + ", text='" + text + '\'' + '}';
	}
}
