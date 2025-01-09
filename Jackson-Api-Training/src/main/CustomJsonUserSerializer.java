package main;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomJsonUserSerializer extends JsonSerializer<User> {

	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public void serialize(User user, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

//		StringWriter writer = new StringWriter();
//		mapper.writeValue(writer, user);
//		generator.writeFieldName(writer.toString());

		generator.writeStartObject();
		generator.writeStringField("type", user.getClass().getName()); // добавляем поле type
		generator.writeStringField("id", user.getId());
		generator.writeStringField("name", user.getName());
		generator.writeEndObject();

	}

}
