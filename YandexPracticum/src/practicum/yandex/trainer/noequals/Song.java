package practicum.yandex.trainer.noequals;

import java.util.Objects;

class Song {
	public final String title;
	public final String artist;
	public final String songwriter;

	public Song(String title, String artist, String songwriter) {
		this.title = title;
		this.artist = artist;
		this.songwriter = songwriter;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		return Objects.equals(title, other.title) && Objects.equals(artist, other.artist)
				&& Objects.equals(songwriter, other.songwriter);
	}

}
