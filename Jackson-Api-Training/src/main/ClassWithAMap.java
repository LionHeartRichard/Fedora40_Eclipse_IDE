package main;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ClassWithAMap {
	@JsonProperty("map")
	@JsonDeserialize(keyUsing = CustomJsonUserDeserializer.class)
	private Map<User, HashSet<User>> map;

	@JsonCreator
	public ClassWithAMap(Map<User, HashSet<User>> map) {
		this.map = map;
	}

	public Map<User, HashSet<User>> getMap() {
		return map;
	}

	public void setMap(Map<User, HashSet<User>> map) {
		this.map = map;
	}

}
