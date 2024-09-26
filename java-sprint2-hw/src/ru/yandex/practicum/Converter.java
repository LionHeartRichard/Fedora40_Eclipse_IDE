package ru.yandex.practicum;

public class Converter {

	private static int STEPS_IN_CENTIMETER = 75;
	private static int STEPS_IN_CALORIES = 50;

	int convertToKm(int steps) {
		return steps * STEPS_IN_CENTIMETER / 1000;
	}

	int convertStepsToKilocalories(int steps) {
		return steps * STEPS_IN_CALORIES / 1000;
	}
}
