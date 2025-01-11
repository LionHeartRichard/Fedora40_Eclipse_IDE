package main;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeName("USER")
public class User implements Human {

	private String id;
	private String name;

	public User() {
	}

	@JsonCreator
	public User(String user) {
		String[] filds = user.split(",");
		this.id = filds[0];
		this.name = filds[1];
	}

	@JsonCreator
	public User(@JsonProperty("id") String id, @JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		User user = (User) obj;
		return id.equals(user.id) && name.equals(user.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

//	@Override 
//	@JsonValue // Предоставляет строковое представление объекта при сериализации.
//	public String toString() { return "ID: " + id + ", Name: " + name; }

//	@Override
//	@JsonValue
//	public String toString() {
//		return "{\"id\":\"" + id + "\"name\":\"" + name + "\", \"type\":\"USER\"}";
//	}

	@Override
	@JsonValue
	public String toString() {
		return id + "," + name;
	}
}
