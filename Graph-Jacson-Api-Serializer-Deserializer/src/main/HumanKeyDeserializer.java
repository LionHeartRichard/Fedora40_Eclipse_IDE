package main;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

public class HumanKeyDeserializer extends KeyDeserializer {

	@Override
	public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException {
		// Важно: предполагается формат "type,id,name"
		String[] parts = key.split(",");
		if (parts.length != 3)
			throw new IOException("Invalid key format: " + key);

		String type = parts[0];
		String id = parts[1];
		String name = parts[2];

		if ("USER".equals(type)) {
			return new User(id, name);
		} else if ("PERSON".equals(type)) {
			return new Person(id, name);
		} else {
			throw new IOException("Unknown type: " + type);
		}
	}
}
