package practicum.yandex.trainer;

class Train extends Transport {
	public Train() {
		wheelsNumber = 8;
	}

	public boolean isLocomotive;

	public void turnToLocomotive() {
		isLocomotive = true;
	}

	public void turnToСarriage() {
		isLocomotive = false;
	}
}
