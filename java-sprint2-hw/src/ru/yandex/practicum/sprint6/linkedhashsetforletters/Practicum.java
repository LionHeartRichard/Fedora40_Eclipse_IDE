package ru.yandex.practicum.sprint6.linkedhashsetforletters;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class Practicum {
	private static Set<Letter> letters = new LinkedHashSet<>();

	public static void main(String[] args) {
		// информация о письмах (в порядке занесения в систему)
		letters.add(new Letter("Джон Смит", LocalDate.of(2021, 7, 7), "текст письма №1 ..."));
		letters.add(new Letter("Аманда Линс", LocalDate.of(2021, 6, 17), "текст письма №2 ..."));
		letters.add(new Letter("Джо Кью", LocalDate.of(2021, 7, 5), "текст письма №3 ..."));
		letters.add(new Letter("Мишель Фернандес", LocalDate.of(2021, 8, 23), "текст письма №4 ..."));

		printOrderedById(letters);
		printOrderedByDateReceived(letters);
	}

	private static void printOrderedById(Set<Letter> letters) {
		System.out.println("Все письма с сортировкой по ID: ");

		for (Letter letter : letters) {
			System.out.println("    * Письмо от " + letter.authorName + " поступило " + letter.dateReceived);
		}
	}

	private static void printOrderedByDateReceived(Set<Letter> letters) {
		System.out.println("Все письма с сортировкой по дате получения: ");
		Set<Letter> result = new TreeSet<>(new ComparatorByLocalDateForLetter());
		result.addAll(letters);
		for (Letter letter : result) {
			System.out.println("    * Письмо от " + letter.authorName + " поступило " + letter.dateReceived);
		}
	}

	static class Letter {
		public String authorName; // имя отправителя
		public LocalDate dateReceived; // дата получения письма
		public String text; // текст письма

		public Letter(String senderName, LocalDate dateReceived, String text) {
			this.authorName = senderName;
			this.dateReceived = dateReceived;
			this.text = text;
		}

		@Override
		public int hashCode() {
			return Objects.hash(authorName, dateReceived, text);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Letter other = (Letter) obj;
			return Objects.equals(authorName, other.authorName) && Objects.equals(dateReceived, other.dateReceived)
					&& Objects.equals(text, other.text);
		}
	}

	static class ComparatorByLocalDateForLetter implements Comparator<Letter> {

		@Override
		public int compare(Letter letterA, Letter letterB) {
			return letterA.dateReceived.compareTo(letterB.dateReceived);
		}

	}
}
