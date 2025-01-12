package main;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HumanDeserializer extends JsonDeserializer<Human> {
	@Override
	public Human deserialize(JsonParser jsonParser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(jsonParser);

		String value = node.textValue();
		String[] filds = value.split(",");
		if (filds.length != 3)
			throw new IOException("Invalid key format: " + value);

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
