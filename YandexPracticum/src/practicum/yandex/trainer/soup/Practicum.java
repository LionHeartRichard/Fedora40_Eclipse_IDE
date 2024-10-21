package practicum.yandex.trainer.soup;

class Practicum {
	public static void main(String[] args) {
		System.out.println("Готовим основу:");
		SoupBase soupBase = new SoupBase(2, 5);
		soupBase.printIngredients();

		System.out.println("\nИз основы приготовим вегетарианский суп и бульон:");
		Bouillon bouillon = new Bouillon(soupBase, 300);
		bouillon.printIngredients();
		VegetarianSoup vegetarianSoup = new VegetarianSoup(soupBase, 200);
		vegetarianSoup.printIngredients();

		System.out.println("\nПриготовим вегетарианский суп с нуля");
		VegetarianSoup vegetarianSoupWithoutBase = new VegetarianSoup(1.5, 5, 200);
		vegetarianSoupWithoutBase.printIngredients();

		System.out.println("\nПриготовим другой бульон для картофельного супа:");
		Bouillon anotherBouillon = new Bouillon(5, 10, 800);
		anotherBouillon.printIngredients();

		System.out.println("\nИз этого бульона приготовим суп с картошкой:");
		PotatoSoup potatoSoup = new PotatoSoup(anotherBouillon, 4, 1);
		potatoSoup.printIngredients();

		System.out.println("\nСуп с картошкой можно приготовить и из суповой основы:");
		PotatoSoup potatoSoupFromBase = new PotatoSoup(soupBase, 200, 3, 0);
		potatoSoupFromBase.printIngredients();

		System.out.println("\nА можно и совсем с нуля:");
		PotatoSoup totallyNewPotatoSoup = new PotatoSoup(5, 10, 400, 5, 1);
		totallyNewPotatoSoup.printIngredients();
	}
}
