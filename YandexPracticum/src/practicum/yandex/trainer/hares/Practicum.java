package practicum.yandex.trainer.hares;

import java.util.ArrayList;

class Practicum {

	public static void main(String[] args) {
		ArrayList<MountainHare> hares = new ArrayList<>();
		hares.add(new MountainHare(4, 4.4, 120));
		hares.add(new MountainHare(7, 3.6, 150));
		hares.add(new MountainHare(1, 2.3, 100));

		System.out.println("В лесу лето!");
		// создайте объект "летний лес с зайцами"
		Forest forest = new Forest(hares);

		System.out.println("Список зайцев:");
		// напечатайте список всех зайцев
		forest.printHares();

		System.out.println("В лесу зима!");
		// поменяйте время года на зиму
		forest.setSeason("winter");

		System.out.println("Список зайцев:");
		// напечатайте список всех зайцев
		forest.printHares();
	}

}
