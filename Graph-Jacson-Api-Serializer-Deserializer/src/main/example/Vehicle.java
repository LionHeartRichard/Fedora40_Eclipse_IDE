package main.example;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = Vehicle.ElectricVehicle.class, name = "ELECTRIC_VEHICLE"),
		@JsonSubTypes.Type(value = Vehicle.FuelVehicle.class, name = "FUEL_VEHICLE") })
public class Vehicle {

	public String type;

	@Getter
	@Setter
	public static class ElectricVehicle extends Vehicle {
		String autonomy;
		String chargingTime;
	}

	@Getter
	@Setter
	public static class FuelVehicle extends Vehicle {
		String fuelType;
		String transmissionType;
	}

	@Test
	public void whenDeserializingPolymorphic_thenCorrect() throws JsonProcessingException {
		String json = "{\"type\":\"ELECTRIC_VEHICLE\",\"autonomy\":\"500\",\"chargingTime\":\"200\"}";

		Vehicle vehicle = new ObjectMapper().readerFor(Vehicle.class).readValue(json);

		assertEquals(Vehicle.ElectricVehicle.class, vehicle.getClass());
	}
}