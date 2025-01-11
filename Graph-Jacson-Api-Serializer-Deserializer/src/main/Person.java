package main;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeName("PERSON")
public class Person extends User implements Human {

	private String id;
	private String name;

	public Person() {
	}

	@JsonCreator
	public Person(String user) {
		String[] filds = user.split(",");
		this.id = filds[0];
		this.name = filds[1];
	}

	@JsonCreator
	public Person(@JsonProperty("id") String id, @JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	@JsonValue
	public String toString() {
		return id + "," + name;
	}

	public void printPerson() {
		System.out.println(this);
	}
}
