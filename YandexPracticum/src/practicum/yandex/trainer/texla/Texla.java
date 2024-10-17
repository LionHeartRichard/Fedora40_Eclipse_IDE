package practicum.yandex.trainer.texla;

class Texla extends Automobile {
	protected double autoPilotMaxSpeed;
	protected double autoPilotAcceleration;

	public Texla() {
		autoPilotMaxSpeed = 60;
		autoPilotAcceleration = 11;
	}

	public void accelerateByAutopilot() {
		if ((speed + autoPilotAcceleration) < autoPilotMaxSpeed) {
			speed += autoPilotAcceleration;
		} else {
			speed = autoPilotMaxSpeed;
		}
	}

	@Override
	public void accelerate() {
		if (speed + acceleration < maxSpeed) {
			speed += acceleration;
		} else {
			speed = maxSpeed;
		}
	}

	@Override
	public void brake() {
		if ((speed - brakingSpeed) > 0) {
			speed -= brakingSpeed;
		} else {
			speed = 0;
		}
	}
}
