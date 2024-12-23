package main;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.User;
import util.Graph;

public class TestJacsonApi {

	private static final String PATH_USER = "/home/kerrigan_kein/eclipse-workspace/Jackson-Api-Training/resources/user.json";
	private static final String PATH_MAP = "/home/kerrigan_kein/eclipse-workspace/Jackson-Api-Training/resources/map.json";
	private static final String PATH_GRAPH = "/home/kerrigan_kein/eclipse-workspace/Jackson-Api-Training/resources/graph.json";

	private static ObjectMapper mapper = new ObjectMapper();

	public static User loadDataUser() {
		try {
			File file = new File(PATH_USER);
			User user = mapper.readValue(file, new TypeReference<User>() {
			});
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void saveDataUser(User user) {
		try (FileWriter writer = new FileWriter(PATH_USER); BufferedWriter buffer = new BufferedWriter(writer)) {
			String json = mapper.writeValueAsString(user);
			buffer.write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Map<String, User> loadDataMap() {
		try {
			File file = new File(PATH_MAP);
			Map<String, User> users = mapper.readValue(file, new TypeReference<Map<String, User>>() {
			});
			return users;
		} catch (Exception e) {

		}
		return null;
	}

	public static void saveDataMap(Map<String, User> users) {
		try (FileWriter writer = new FileWriter(PATH_MAP); BufferedWriter buffer = new BufferedWriter(writer)) {
			String json = mapper.writeValueAsString(users);
			buffer.write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Graph<User> loadGraph() {
		try (FileReader reader = new FileReader(PATH_GRAPH); BufferedReader buffer = new BufferedReader(reader)) {
			// mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
			StringBuilder json = new StringBuilder();
			while (buffer.ready()) {
				json.append(buffer.readLine());
			}
			System.out.println(json.toString());
			Graph<User> users = new Graph<>();
			Map<User, Set<User>> swap = mapper.readValue(json.toString(), new TypeReference<>() {
			});
			Map<User, Set<User>> result = new HashMap<>();
			// Map<User, Set<User>> swap = mapper.readValue(json,
			// mapper.getTypeFactory().constructMapType(HashMap.class, User.class,
			// List.class));

			// users.setAdjacentList(swap);
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void saveGraph(Graph users) {
		try (FileWriter writer = new FileWriter(PATH_GRAPH); BufferedWriter buffer = new BufferedWriter(writer)) {
			// mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			String json = mapper.writeValueAsString(users.getAdjacentList());
			buffer.write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUser() {
		Map<String, User> users = new HashMap<>();
		for (int i = 1; i <= 10; ++i) {
			users.put(i + "", new User(i + "", "User - " + i));
		}
		User expected = users.get("1");
		saveDataUser(expected);
		User actual = loadDataUser();

		assertEquals(expected, actual);
	}

	@Test
	public void testMap() {
		Map<String, User> expected = new HashMap<>();
		for (int i = 1; i <= 10; ++i) {
			expected.put(i + "", new User(i + "", "User - " + i));
		}

		saveDataMap(expected);
		Map<String, User> actual = loadDataMap();

		expected.forEach((k, v) -> assertTrue(actual.containsKey(k)));
	}

	@Test
	public void testGraph() {
		Graph<User> graph = new Graph<>();
		graph.addEdge(new User("0", "root"), new User("1", "Parent1"));
		graph.addEdge(new User("0", "root"), new User("2", "Parent2"));
		graph.addEdge(new User("1", "Parent1"), new User("3", "Children1"));
		graph.addEdge(new User("1", "Parent1"), new User("4", "Children2"));
		graph.addEdge(new User("1", "Parent1"), new User("5", "Children3"));
		graph.addEdge(new User("2", "Parent2"), new User("6", "Children=4"));
		graph.addEdge(new User("2", "Parent2"), new User("7", "Children=5"));

		saveGraph(graph);

		Graph<User> expected = graph;

		Graph<User> actual = loadGraph();
	}

}
