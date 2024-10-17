package practicum.yandex.trainer;

class TexlaTruck extends TexlaCar {
	protected double maxSpeedByDirt;

	public TexlaTruck() {
		maxSpeedByDirt = 30;
	}

	public void accelerateByDirt() {
		if (speed < maxSpeedByDirt) {
			speed += acceleration * 0.5;
		}
	}

	public void brakeByDirt() {
		if (speed > 0) {
			speed -= brakingSpeed * 0.5;
		}
	}
}
