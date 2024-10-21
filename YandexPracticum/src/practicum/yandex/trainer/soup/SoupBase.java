package practicum.yandex.trainer.soup;

class SoupBase {
	double water;
	double salt;

	// реализуйте конструктор

	public SoupBase(double water, double salt) {
		this.water = water;
		this.salt = salt;
	}

	public void printIngredients() {
		System.out.println("Ингредиенты суповой основы:");
		System.out.println("Вода: " + water + " л.");
		System.out.println("Соль: " + salt + " г.");
	}
}
