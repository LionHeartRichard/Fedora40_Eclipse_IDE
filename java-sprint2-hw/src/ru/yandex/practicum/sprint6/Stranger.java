package ru.yandex.practicum.sprint6;

class Stranger {
	public final String name;
	public final int age;

	public Stranger(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Participant{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}