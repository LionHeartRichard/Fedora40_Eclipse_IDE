package practicum.yandex.trainer.generics.endtask;

abstract class Contact {
	// Класс должен содержать одно полe - имя пользователя name
	protected String name;

	// И два метода - sendMessage() для отправки сообщения и print() для печати
	// информации о контакте
	public Contact() {
	}

	public Contact(String name) {
		this.name = name;
	}

	public abstract void sendMessage();

	public String getName() {
		return name;
	}

	public void print() {
		System.out.println(name);
	}
}
