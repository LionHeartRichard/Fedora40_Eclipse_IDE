package practicum.yandex.trainer.iss;

class ISS extends Mir {
	// доступ к изменению параметров запрещён
	public ISS(double initialOxygenLevel, double initialEnergyLevel, double initialFuel) {

		super.oxygenLevel = initialEnergyLevel / 2;
		super.energyReserve = initialEnergyLevel + 15.0;

		// требуется увеличить уровень кислорода и энергетических резервов

		// доступ к изменению полей запрещён
		fuel = initialFuel;
		vibration = 0;
		energyConsumption = 20;
	}

	// доступ к изменению метода запрещён
	public void moduleDocking(Zvezda module) {
		connectEnergyCableTo(module);
		connectOxygenCableTo(module);
		stabilize();
	}

	/*
	 * Ожидалось стабилизация. Выводится модуль Ожидалось малыми. Выводится
	 * пристыкован Ожидалось двигателями. Выводится проверка Ожидалось стабилизация.
	 * Выводится систем Ожидалось малыми. Выводится уровень
	 */

	// получен доступ к переопределению метода стабилизации
	@Override
	void stabilize() {
		while (vibration > 1.0) {
			stabilizeBySmallEngines();
		}
	}

	// доступ к изменению метода запрещён
	private void connectOxygenCableTo(Zvezda module) {
		double oxygenLosses = (oxygenLevel + module.oxygenLevel) / 2 + 9;
		oxygenLevel -= oxygenLosses;
		vibration += 2;
	}

	// доступ к изменению метода запрещён
	private void connectEnergyCableTo(Zvezda module) {
		energyReserve += module.getEnergyReserve();
		energyConsumption += module.getEnergyConsumption() * 1.3;
		vibration += 2;
	}
}
