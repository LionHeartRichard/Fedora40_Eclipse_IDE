package main.myinterface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class MainInterfaceDeserializer {

	private static final String PATH_MAP = "/home/kerrigan_kein/eclipse-workspace/Jackson-Api-Training/resources/myInterface.json";
	private static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws IOException {
		MyInterface itemA = new ImplementationA();
		save(itemA);
		MyInterface item = load();

		System.out.println(item.getType());
	}

	private static void save(MyInterface itemA) {
		try (FileWriter writer = new FileWriter(PATH_MAP); BufferedWriter buffer = new BufferedWriter(writer)) {

			String json = mapper.writeValueAsString(itemA);

			buffer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static MyInterface load() throws IOException {
		try (FileReader reader = new FileReader(PATH_MAP); BufferedReader buffer = new BufferedReader(reader)) {
			StringBuilder source = new StringBuilder();
			String line;
			while ((line = buffer.readLine()) != null) {
				source.append(line);
			}
			String json = source.toString();

			SimpleModule module = new SimpleModule();
			module.addDeserializer(MyInterface.class, new MyDeserializer());
			mapper.registerModule(module);

			MyInterface readValue = mapper.readValue(json, MyInterface.class);
			return readValue;
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}

}
