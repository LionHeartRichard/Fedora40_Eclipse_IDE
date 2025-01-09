package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class Main {
	private static final String PATH_MAP = "/home/kerrigan_kein/eclipse-workspace/Jackson-Api-Training/resources/graph.json";

	private static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws IOException {

		Set<Human> users = new HashSet<>();
		User us1 = new User("1", "User1");
		users.add(us1);
		User us2 = new User("2", "User2");
		users.add(us2);
		User us3 = new User("3", "User3");
		users.add(us3);

		User root = new User("0", "ROOT");

		Map<Human, Set<Human>> adjacent = new HashMap<>();
		adjacent.put(root, users);

		save(adjacent);

		Map<Human, HashSet<Human>> loadAdjacent = load();
		loadAdjacent.forEach((k, v) -> System.out.println(k + ": " + v));
	}

	private static Map<Human, HashSet<Human>> load() throws IOException {
		try (FileReader reader = new FileReader(PATH_MAP); BufferedReader buffer = new BufferedReader(reader)) {
			StringBuilder source = new StringBuilder();
			String line;
			while ((line = buffer.readLine()) != null) {
				source.append(line);
			}
			String users = source.toString();

			TypeReference<HashMap<Human, HashSet<Human>>> typeRef = new TypeReference<>() {
			};

			Map<Human, HashSet<Human>> adjacent = mapper.readValue(users, typeRef);
			return adjacent;
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}

	private static void save(Map<Human, Set<Human>> adjacent) {
		try (FileWriter writer = new FileWriter(PATH_MAP); BufferedWriter buffer = new BufferedWriter(writer)) {

			String json = mapper.writeValueAsString(adjacent);

			buffer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
