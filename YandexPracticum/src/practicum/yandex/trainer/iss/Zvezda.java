package practicum.yandex.trainer.iss;

class Zvezda extends Zarya {

	public Zvezda() { // доступ к изменению конструктора запрещён
		super();
		energyConsumption = 44;
		activateModule();
	}
	// доступ к созданию новых конструкторов запрещён

	// разрешено переопределение методов
}
