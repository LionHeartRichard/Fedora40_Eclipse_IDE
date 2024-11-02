package practicum.yandex.trainer.atc;

//допишите реализацию класса Smartphone
class Smartphone extends Phone {

	public Smartphone(String number) {
		super(number);
	}

	// объявите метод sendEmail()
	public void sendEmail(String messageText, String email) {
		System.out.println("Напишем другу сообщение " + messageText + " по email " + email);
	}

	public void makeCall(String targetNumber) {
		System.out.println("Звоним с номера " + super.number);
		System.out.println("Набираем номер " + targetNumber + " и звоним по сотовой связи");
		System.out.println("Привет!");
	}
}
