package projectlombok;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

public class Practicum {

	@Data
	@Builder
	public static class House {
		@NonNull
		private int wallWidth;
		@NonNull
		private int wallLength;
		@NonNull
		private String wallsColor;

		@Builder.Default
		private int wallHeight = 2500;
		@Builder.Default
		private int numberOfWindows = 6;
		@Builder.Default
		private int numberOfFloors = 1;

		public int calculateTotalArea() {
			return wallWidth * wallLength * numberOfFloors;
		}
	}

	public static void main(String[] args) {
		final House house = House
				.builder()
				.wallWidth(15)
				.wallLength(12)
				.wallsColor("red")
				.numberOfFloors(2)
				.build();

		System.out.println(house);	
		System.out.println("Общая площадь = " + house.calculateTotalArea());
	}
}