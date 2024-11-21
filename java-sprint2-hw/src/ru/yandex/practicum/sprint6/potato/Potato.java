package ru.yandex.practicum.sprint6.potato;

import java.util.Objects;

public class Potato implements Comparable<Potato> {

	public final int id;

	// Масса
	public final int weight;

	// Длина
	public final int length;

	// Ширина
	public final int girth;

	public Potato(int id, int weight, int length, int girth) {
		this.id = id;
		this.weight = weight;
		this.length = length;
		this.girth = girth;
	}

	@Override
	public int compareTo(Potato other) {
		final int compareAlphaThis = (int) (this.weight * 0.5 + this.length * 0.65 + this.girth * 0.8);
		final int compareAlphaOther = (int) (other.weight * 0.5 + other.length * 0.65 + other.girth * 0.8);

		if (compareAlphaOther != compareAlphaThis) {
			return Integer.compare(compareAlphaThis, compareAlphaOther);
		}
		return Integer.compare(this.id, other.id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Potato potato = (Potato) o;
		return id == potato.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Potato{" + "id=" + id + ", weight=" + weight + ", length=" + length + ", girth=" + girth + '}';
	}
}
