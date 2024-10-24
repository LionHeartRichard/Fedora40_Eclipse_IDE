package practicum.yandex.trainer.workbyenum;

enum Continent {
	ASIA, AFRICA, NORTH_AMERICA, SOUTH_AMERICA, ANTARCTICA, EUROPE, AUSTRALIA;

	@Override
	public String toString() {
		return name().charAt(0) + name().substring(1).toLowerCase();
	}
}
