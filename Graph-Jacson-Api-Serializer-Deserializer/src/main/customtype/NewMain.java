package main.customtype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class NewMain {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {

		String json = "{\"id\":1,\"itemName\":\"theItem\",\"owner\":{\"id\":2,\"name\":\"theUser\"}}";
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();
		module.addDeserializer(Wrapper.class, new WrapperDeserializer());
		mapper.registerModule(module);

		Item readValue = mapper.readValue(json, Item.class);
		System.out.println("idx = " + readValue.getId());
		System.out.println("itemName = " + readValue.getItemName());
		System.out.println("owner = " + readValue.getOwner().getValue().toString());
	}
}
