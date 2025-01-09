package main;

import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ClassWithAMap {
	@JsonProperty("map")
	@JsonDeserialize(keyUsing = CustomJsonUserDeserializer.class)
	private Map<User, Set<User>> map;

	@JsonCreator
	public ClassWithAMap(Map<User, Set<User>> map) {
		this.map = map;
	}

	public Map<User, Set<User>> getMap() {
		return map;
	}

	public void setMap(Map<User, Set<User>> map) {
		this.map = map;
	}

}
