package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import model.User;
import model.UserSerializer;
import util.Graph;

public class Main {

	@JsonSerialize(keyUsing = UserSerializer.class)
	static Map<User, Set<User>> map;

	@JsonSerialize(keyUsing = UserSerializer.class)
	static User mapKey;

	@JsonSerialize(keyUsing = UserSerializer.class)
	static Set<User> mapValue;

	static ObjectMapper mapper = new ObjectMapper();
	private static final String PATH = "/home/kerrigan_kein/eclipse-workspace/Jackson-Api-Training/resources/jsonInput.json";

	public static void main(String[] args) {
		// Создаем сложный объект
		Map<Object, Set<Object>> complexObject = new HashMap<>();

		Set<Object> set1 = new HashSet<>();
		set1.add("Value1");
		set1.add("Value2");

		Set<Object> set2 = new HashSet<>();
		set2.add(1);
		set2.add(2);
		set2.add(null);

		Set<Object> set3 = new HashSet<>();

		complexObject.put("Key1", set1);
		complexObject.put("Key2", set2);
		complexObject.put("Key3", set3);

		// Сериализуем
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String jsonString = objectMapper.writeValueAsString(complexObject);
			System.out.println(jsonString);

			complexObject = objectMapper.readValue(jsonString, new TypeReference<Map<Object, Set<Object>>>() {
			});

			map = new HashMap<>();
			Graph<User> graph = new Graph<User>();
			graph.addEdge(new User("0", "root"), new User("1", "Parent1"));
			graph.addEdge(new User("0", "root"), new User("2", "Parent2"));
			graph.addEdge(new User("1", "Parent1"), new User("3", "Children1"));
			graph.addEdge(new User("1", "Parent1"), new User("4", "Children2"));
			graph.addEdge(new User("1", "Parent1"), new User("5", "Children3"));
			graph.addEdge(new User("2", "Parent2"), new User("6", "Children=4"));
			graph.addEdge(new User("2", "Parent2"), new User("7", "Children=5"));
			map.putAll(graph.getAdjacentList());
			saveGraph();
			File jsonInput = new File(PATH);

			TypeReference<HashMap<User, HashSet<User>>> typeRef = new TypeReference<HashMap<User, HashSet<User>>>() {
			};
			Map<User, HashSet<User>> userMap = mapper.readValue(jsonInput, typeRef);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveGraph() {
		try (FileWriter writer = new FileWriter(PATH); BufferedWriter buffer = new BufferedWriter(writer)) {
			String json = mapper.writeValueAsString(map);
			buffer.write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Интересный метод, обрати внимание не только на каст-Типов, но и на обработку
	// Ошибок
	public static <T> T deserialize() {
		try (final FileInputStream FileOutputStream = new FileInputStream(PATH);
				final ObjectInputStream ObjectInputStream = new ObjectInputStream(FileOutputStream)) {
			final Object object = ObjectInputStream.readObject();
			final Class<?> Class = object.getClass();
			return (T) Class.cast(object);
		} catch (final IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static <T> T deserialize(final Object object) {
		try {
			final Class<?> Class = object.getClass();
			return (T) Class.cast(object);
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
