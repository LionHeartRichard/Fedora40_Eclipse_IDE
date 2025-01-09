package main;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class User implements Human {
	private String id;
	private String name;

//	@JsonProperty("type")
//	private String type;

	public User() {
//		this.type = "USER";
	}

	@JsonCreator
	public User(String user) {
		String[] filds = user.split(",");
//		this.type = filds[0];
		this.id = filds[0];
		this.name = filds[1];
	}

	@JsonCreator
	public User(@JsonProperty("id") String id, @JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
//		this.type = "USER";
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
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
		return id + "," + name;
	}

//	@Override
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	@Override
//	public String getType() {
//		return this.type;
//	}
}
