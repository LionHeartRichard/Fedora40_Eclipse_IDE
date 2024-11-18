package ru.yandex.practicum.sprint6;

public class HandMadeArrayList<T> {
	private int size = 0;
	private Object[] elements;

	public HandMadeArrayList() {
		this.elements = new Object[10];
	}

	public void add(T newElement) {
		++size;
		if (this.elements.length == size) {
			grow();
		}
		elements[size] = newElement;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
		}
		return (T) this.elements[index];
	}

	private void grow() {
		Object[] newArray = new Object[elements.length + elements.length / 2];

		for (int idx = 0; idx < elements.length; ++idx) {
			newArray[idx] = elements[idx];
		}

		this.elements = newArray;
	}

	public static void main(String[] args) {
		final var ar = new HandMadeArrayList<Integer>();
		for (int i = 0; i < 2000; i++) {
			ar.add(i);
		}
		System.out.println(ar.size);
	}
}