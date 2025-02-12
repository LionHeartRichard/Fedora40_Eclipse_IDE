package ru.yandex.practicum.sprint10.introdactionannotation;

@ObjectInfo(type = MyClass.class)
public class MyClass {

	@ObjectInfo(type = String.class)
	private String myField;

	@ObjectInfo(type = MyClass.class, args = { int.class }, required = true)
	public MyClass(int initialValue) {
	}

	@ObjectInfo(type = void.class, args = { int.class, String.class }, required = true)
	public void myMethod(int number, String text) {
	}
}
