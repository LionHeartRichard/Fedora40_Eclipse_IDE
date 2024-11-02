package practicum.yandex.trainer.atc;

class MobilePhone extends Phone {

	public MobilePhone(String number) {
		super(number);
	}

	// объявите метод sendSms()
	public void sendSms(String messageText, String targetNumber) {
		System.out.println("Отправляем сообщение " + messageText + " по номеру " + targetNumber);
	}
}
