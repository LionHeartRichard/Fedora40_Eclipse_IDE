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

		Set<User> users = new HashSet<>();
		User us1 = new User("1", "User1");
		users.add(us1);
		User us2 = new User("2", "User2");
		users.add(us2);
		User us3 = new User("3", "User3");
		users.add(us3);

		User root = new User("0", "ROOT");
		Map<User, Set<User>> adjacent = new HashMap<>();
		adjacent.put(root, users);

		/*
		 * ObjectMapper mapper = new ObjectMapper(); SimpleModule module = new
		 * SimpleModule(); module.addDeserializer(Wrapper.class, new
		 * WrapperDeserializer()); mapper.registerModule(module);
		 * 
		 * Item readValue = mapper.readValue(json, Item.class);
		 * System.out.println("idx = " + readValue.id); System.out.println("itemName = "
		 * + readValue.itemName); System.out.println("owner = " +
		 * readValue.owner.getValue().toString());
		 */

		Graph<User> graph = new Graph<>();
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
//		save(graph);
//
//		Graph<User> newGraph = load();

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
			mapper.registerModule(module);

			Element readValue = mapper.readValue(json, Element.class);
			return readValue;
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}
}
