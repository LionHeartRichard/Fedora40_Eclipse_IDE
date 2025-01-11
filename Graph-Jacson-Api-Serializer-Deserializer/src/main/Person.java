package main;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.Setter;

public class Person extends User implements Human {

	public Person() {
	}

	@JsonCreator
	public Person(String person) {
		String[] filds = person.split(",");
		this.type = filds[0];
		this.id = filds[1];
		this.name = filds[2];
	}

	@JsonCreator
	public Person(@JsonProperty("id") String id, @JsonProperty("name") String name) {
		this.type = "PERSON";
		this.id = id;
		this.name = name;
	}

	@Override
	@JsonValue
	public String toString() {
		return type + "," + id + "," + name;
	}

	public void printPerson() {
		System.out.println(this);
	}
}
