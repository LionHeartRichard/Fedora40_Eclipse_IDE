package main;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

public class HumanKeyDeserializer extends KeyDeserializer {

	@Override
	public Object deserializeKey(String key, DeserializationContext context) throws IOException {

		String[] filds = key.split(",");
		if (filds.length != 3)
			throw new IOException("Invalid key format: " + key);

		String type = filds[0];
		String id = filds[1];
		String name = filds[2];

		if ("USER".equals(type)) {
			return new User(id, name);
		} else if ("PERSON".equals(type)) {
			return new Person(id, name);
		} else {
			throw new IOException("Unknown type: " + type);
		}
	}
}
