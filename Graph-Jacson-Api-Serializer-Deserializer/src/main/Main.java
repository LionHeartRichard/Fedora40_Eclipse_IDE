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

		Human root = new Person("0", "ROOT");
		Map<Human, Set<Human>> adjacent = new HashMap<>();
		adjacent.put(root, users);

		Graph<Human> graph = new Graph<>();
		graph.setAdjacencyList(adjacent);
		Element element = new Element();
		element.setIdElemnt(12);
		element.setNameElemnt("Name-Elemnts");
		element.setGraphElement(graph);
		saveElement(element);
		Element elementLoad = loadElement();

		System.out.println(elementLoad.getIdElemnt());
		System.out.println(elementLoad.getNameElemnt());
		elementLoad.getGraphElement().getAdjacencyList().forEach((k, v) -> System.out.println(k + " " + v));

	}

	private static void saveElement(Element element) {
		try (FileWriter writer = new FileWriter(PATH_MAP); BufferedWriter buffer = new BufferedWriter(writer)) {

			String json = mapper.writeValueAsString(element);

			buffer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Element loadElement() throws IOException {
		try (FileReader reader = new FileReader(PATH_MAP); BufferedReader buffer = new BufferedReader(reader)) {
			StringBuilder source = new StringBuilder();
			String line;
			while ((line = buffer.readLine()) != null) {
				source.append(line);
			}
			String json = source.toString();

			SimpleModule module = new SimpleModule();
			module.addDeserializer(Graph.class, new GraphDeserializer());

			module.addKeyDeserializer(Human.class, new HumanKeyDeserializer());

			module.addDeserializer(Human.class, new HumanDeserializer());

			mapper.registerModule(module);

			Element readValue = mapper.readValue(json, Element.class);
			return readValue;
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}
}
