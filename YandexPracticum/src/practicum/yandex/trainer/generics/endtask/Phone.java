package practicum.yandex.trainer.generics.endtask;

class Phone extends Contact {
	private final String phoneNumber;

	public Phone(String name, String phoneNumber) {
		super(name);
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	// Метод sendMessage переопределяет метод базового класса
	@Override
	public void sendMessage() {
		System.out.println("Звоним другу по номеру " + phoneNumber + " и зовем на кофе.");
	}

	@Override
	public void print() {
		System.out.println("Номер телефона: " + getPhoneNumber());
	}
}
