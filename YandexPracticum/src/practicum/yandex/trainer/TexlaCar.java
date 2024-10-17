package practicum.yandex.trainer;

class TexlaCar extends Automobile {
	protected double autoPilotMaxSpeed;
	protected double autoPilotAcceleration;

	public TexlaCar() {
		autoPilotMaxSpeed = 60;
		autoPilotAcceleration = 10;
	}

	public void accelerateByAutopilot() {
		if (speed < autoPilotMaxSpeed) {
			speed += autoPilotAcceleration;
		}
	}
}