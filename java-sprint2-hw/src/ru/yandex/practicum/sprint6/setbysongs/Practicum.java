package ru.yandex.practicum.sprint6.setbysongs;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class Practicum {
	public static void main(String[] args) {
		List<String> songs = new ArrayList<>();
		fillSongs(songs);

		Set<String> setSongs = new LinkedHashSet<>(songs);

		System.out.println("Количество песен: " + setSongs.size());

		System.out.println("Песни:");
		for (String song : setSongs) {
			System.out.println("  * " + song);
		}

	}

	private static void fillSongs(List<String> songs) {
		songs.add("Sting – Shape Of My Heart");
		songs.add("Gorillaz – Clint Eastwood");
		songs.add("Lady Gaga – Bad Romance");
		songs.add("Taylor Swift – Wildest Dreams");
		songs.add("Ariana Grande – 7 rings");
		songs.add("Depeche Mode – Personal Jesus");
		songs.add("Gorillaz – Clint Eastwood");
		songs.add("Lady Gaga – Bad Romance");
		songs.add("Bruno Mars – Talking To The Moon");
		songs.add("Taylor Swift – Wildest Dreams");
	}
}
