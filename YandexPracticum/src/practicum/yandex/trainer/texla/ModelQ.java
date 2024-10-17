package practicum.yandex.trainer.texla;

class ModelQ extends Texla {

	/*
	 * Характеристики модели: Ускорение: 100.0 км/(ч*с) Максимальная скорость: 300.0
	 * км/ч
	 * 
	 * Едем на автопилоте: Скорость Q спустя 5с на автопилоте: 55.0 км/ч ✅ Скорость
	 * Q спустя ещё 5с на автопилоте: 60.0 км/ч ✅ Переходим в ручной режим: Скорость
	 * Q спустя 2с в ручном режиме: 260.0 км/ч ✅ Скорость Q спустя ещё 2с в ручном
	 * режиме: 300.0 км/ч ✅ Проверяем торможение: Время торможения до полной
	 * остановки: 3c ✅ Скорость Q: 0.0 км/ч ✅
	 */

	public ModelQ() {
		speed = 0;
		acceleration = 100;
		maxSpeed = 300;
	}
}
