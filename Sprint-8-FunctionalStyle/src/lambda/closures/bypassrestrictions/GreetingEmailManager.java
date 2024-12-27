package lambda.closures.bypassrestrictions;

import java.util.HashMap;
import java.util.Map;

interface GreetingGenerator {
	String generateGreeting(String login);
}

class EmailCreator {

	private GreetingGenerator greetingCreator;

	public EmailCreator(GreetingGenerator greetingCreator) {
		this.greetingCreator = greetingCreator;
	}

	public String createEmail(String login, String text) {
		return greetingCreator.generateGreeting(login) + text;
	}
}

public class GreetingEmailManager {
	/*
	 * 🔥 При любых изменениях содержимого объекта, который используется в
	 * замыкании, стоит соблюдать осторожность. В таких случаях значение, с которым
	 * работает функция, становится непредсказуемым. Нужно следить, будет ли объект
	 * в нужном состоянии, когда с ним будет работать лямбда-функция. Так что
	 * обходной путь лучше использовать только в крайних случаях — изменение
	 * значения переменной, используемой в лямбда-функции, может вызвать
	 * трудноотлавливаемые логические ошибки.
	 */

	public static void main(String[] args) {
		Map<String, String> fullNames = new HashMap<>();
		fullNames.put("mr_Dark", "Николай");
		fullNames.put("craziest", "Вячеслав Юрьевич");

		// лямбда-функция всё та же
		GreetingGenerator gg = login -> "Приветствуем вас, " + fullNames.get(login) + " (" + login + ")" + "!\n";

		EmailCreator emailCreator = new EmailCreator(gg);
		System.out.println(emailCreator.createEmail("mr_Dark", "Рады видеть вас в нашем приложении"));

		fullNames.put("mr_Dark", "Николай Сергеевич");
		System.out.println(emailCreator.createEmail("mr_Dark", "Рады видеть вас в нашем приложении"));
	}
}
