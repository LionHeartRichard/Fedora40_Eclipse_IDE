package com.yandexpracticum.trainer;

import org.junit.jupiter.api.Test;

public class Grades {

	private String capitalize(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	private String gradeToString(String grade) {
		switch (grade) {
		case "5": {
			return "Безупречно";
		}
		case "4": {
			return "Потрясающе";
		}
		case "3": {
			return "Восхитительно";
		}
		case "2": {
			return "Прекрасно";
		}
		default:
			return "Очаровательно";
		}
	}

	// grades - строка вида "имя,фамилия,предмет,оценка;имя,фамилия,предмет,оценка;"
	public void gradeBeautifier(String grades) {
		String[] students = grades.split(";");
		for (String student : students) {
			String[] tmp = student.split(",");
			tmp[0] = capitalize(tmp[0]);
			tmp[1] = capitalize(tmp[1]);
			tmp[2] = tmp[2].toLowerCase();
			tmp[3] = "- " + gradeToString(tmp[3]);
			String result = String.join(" ", tmp);
			System.out.println(result);
		}
	}

	@Test
	public void testGradeBeautifier() {
		String grades = "вероника,чехова,ФИЗИКА,5;анна,строкова,МАТЕМАТИКА,4;иван,петров,ГЕОМЕТРИЯ,5";
		gradeBeautifier(grades);
	}
}