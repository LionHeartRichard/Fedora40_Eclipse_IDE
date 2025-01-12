package main;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Human {

	protected String type;
	protected String id;
	protected String name;

	public User() {
	}

	@JsonCreator
	public User(@JsonProperty("id") String id, @JsonProperty("name") String name) {
		this.type = "USER";
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

	@Override
	@JsonValue
	public String toString() {
		return type + "," + id + "," + name;
	}
}
