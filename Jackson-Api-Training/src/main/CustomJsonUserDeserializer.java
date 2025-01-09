package main;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

public class CustomJsonUserDeserializer extends KeyDeserializer {

	@Override
	public User deserializeKey(String user, DeserializationContext context) throws IOException {
		return new User(user);
	}

}
