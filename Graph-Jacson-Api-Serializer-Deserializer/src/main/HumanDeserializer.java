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

		if (node.get("type").asText().equals("USER")) {
			return mapper.treeToValue(node, User.class);
		} else if (node.get("type").asText().equals("PERSON")) {
			return mapper.treeToValue(node, Person.class);
		}

		throw new IOException("Unknown type: " + node.get("type"));
	}
}
