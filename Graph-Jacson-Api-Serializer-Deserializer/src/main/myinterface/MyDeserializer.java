package main.myinterface;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyDeserializer extends JsonDeserializer<MyInterface> {

	@Override
	public MyInterface deserialize(JsonParser jsonParser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		// Читаем JSON как объект
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(jsonParser);

		if (node.get("type").asText().equals("A")) {
			return mapper.treeToValue(node, ImplementationA.class);
		} else if (node.get("type").asText().equals("B")) {
			return mapper.treeToValue(node, ImplementationB.class);
		}

		throw new IOException("Unknown type: " + node.get("type"));
	}
}
