package com.yandexpracticum.trainer;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class GradesReversed {

	private String gradeStringToInt(String grade) {
		switch (grade) {
		case "Безупречно": {
			return "5";
		}
		case "Потрясающе": {
			return "4";
		}
		case "Восхитительно": {
			return "3";
		}
		case "Прекрасно": {
			return "2";
		}
		default:
			return "1";
		}
	}

	public String serializeGrades(String[] grades) {
		StringBuilder builder = new StringBuilder();
		for (String student : grades) {
			String[] swap = student.split(" ");
			swap[0] = swap[0].toLowerCase();
			swap[1] = swap[1].toLowerCase();
			swap[4] = gradeStringToInt(swap[4]) + ";";
			String tmp = String.join(",", swap[0], swap[1], swap[2], swap[4]);
			builder.append(tmp);
		}
		return builder.toString();
	}

	@Test
	public void testSerializeGrades() {
		String[] grades = { "Вероника Чехова физика — Безупречно", "Анна Строкова математика — Потрясающе",
				"Иван Петров геометрия — Безупречно" };

		String actual = serializeGrades(grades);
		String expected = "вероника,чехова,физика,5;анна,строкова,математика,4;иван,петров,геометрия,5;";

		assertEquals(expected, actual);
	}
}
