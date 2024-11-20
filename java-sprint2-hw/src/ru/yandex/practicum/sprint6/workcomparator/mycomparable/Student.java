package ru.yandex.practicum.sprint6.workcomparator.mycomparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// класс может наследовать Comparable<T> только один раз
class Student implements Comparable<Student> {
	private final String name;
	private final int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// переопределяем compareTo - студенты будут сравниваться по имени и по возрасту
	@Override
	public int compareTo(Student o) {
		final int nameComparison = String.CASE_INSENSITIVE_ORDER.compare(this.name, o.name);
		if (nameComparison != 0) {
			return nameComparison;
		} else {
			return Integer.compare(this.age, o.age);
		}
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
	}

	public static void main(String[] args) {
		final var a = new Student("aaa", 30);
		final var b = new Student("aaa", 27);
		final var c = new Student("ccc", 33);

		final var d = new Student("ddd", 21);

		// создаём изменяемый список из неизменяемого List.of(..)
		final var list = new ArrayList<>(List.of(a, b, c, d));
		Collections.sort(list);
		System.out.println(list);

		// выводим минимальный элемент в соответствии с правилами сортировки
		// Comparable<Student>
		// так как список предварительно отсортирован, минимальным будет первый элемент
		System.out.println(Collections.min(list));

		// теперь напечатаем максимальный элемент
		System.out.println(Collections.max(list));
	}
}
