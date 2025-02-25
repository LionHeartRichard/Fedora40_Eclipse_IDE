package main.customtype;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class WrapperDeserializer extends JsonDeserializer<Wrapper<?>> implements ContextualDeserializer {

	private JavaType type;

	@Override
	public Wrapper<?> deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		Wrapper<?> wrapper = new Wrapper<>();
		wrapper.setValue(context.readValue(parser, type));
		return wrapper;
	}

	@Override
	public JsonDeserializer<?> createContextual(DeserializationContext context, BeanProperty property) {
		JavaType wrapperType = property.getType().containedType(0);
		return new WrapperDeserializer(wrapperType);
	}

}
