package practicum.yandex.trainer.workbyenum;

enum VisaType {
	CLASSIC, GOLD, PLATINUM, SIGNATURE, INFINITE;

	@Override
	public String toString() {
		return name().charAt(0) + name().substring(1).toLowerCase();
	}
}
