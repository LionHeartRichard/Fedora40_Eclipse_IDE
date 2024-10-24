package practicum.yandex.trainer.workbyenum;

class PopulationInformer {
	public static String getPopulationPercent(Continent continent) {
		String result;
		switch (continent) {
		case ASIA -> result = "59.5%";
		case AFRICA -> result = "16.9%";
		case NORTH_AMERICA -> result = "7.7%";
		case SOUTH_AMERICA -> result = "5.6%";
		case ANTARCTICA -> result = "<0.1%";
		case EUROPE -> result = "9.7%";
		case AUSTRALIA -> result = "0.5%";
		default -> result = "Invalide data - Такого материка не существует!!!";
		}
		return result;
	}
}
