package practicum.yandex.trainer;

class Transport {
	double speed;
	double maxSpeed;
	double acceleration;
	double brakingSpeed;
	int wheelsNumber;

	/*
	 * speed = 0; maxSpeed = 120; acceleration = 10; brakingSpeed = 50;
	 */

	public void accelerate() {
		if (speed < maxSpeed) {
			speed += acceleration;
		}
	}

	public void brake() {
		if (speed > 0) {
			speed -= brakingSpeed;
		}
	}
}
