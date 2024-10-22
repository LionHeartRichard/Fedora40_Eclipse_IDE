package practicum.yandex.trainer.hares;

import java.util.ArrayList;

class Forest {

	private ArrayList<MountainHare> hares;
	private String season;

	public Forest(ArrayList<MountainHare> hares) {
		this.hares = hares;
	}

	public void setSeason(String newSeason) {
		season = newSeason;
		if (season.equals("зима") || season.equals("winter")) {
			MountainHare.color = "белый";
		} else {
			MountainHare.color = "серо-рыжий";
		}

	}

	public void printHares() {
		if (hares == null)
			return;
		hares.forEach(v -> System.out.println(v));
	}

	// объявите недостающие переменные и добавьте конструктор

	// добавьте метод setSeason(String newSeason)
	// в этом методе реализуйте логику смены цвета шубок зайцев-беляков

	// добавьте метод printHares()

}
