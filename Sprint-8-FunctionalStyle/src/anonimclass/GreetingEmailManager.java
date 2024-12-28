package anonimclass;

import java.util.HashSet;
import java.util.Set;

public class GreetingEmailManager {

	public static void main(String[] args) {
		String fullName = "Николай";

		// создаём анонимный класс, реализующий интерфейс GreetingGenerator
		GreetingGenerator gg = new GreetingGenerator() {
			// поле с набором всех логинов, с которыми вызывался метод generateGreeting
			Set<String> processedLogins = new HashSet<>();

			@Override
			public String generateGreeting(String login) {
				// вступительная часть приветствия зависит от того,
				// первый раз или нет обрабатывается данный логин
				String introString;
				if (processedLogins.contains(login)) {
					introString = "Снова приветствуем вас, ";
				} else {
					introString = "Приветствуем вас, ";
				}
				// добавляем текущий логин к обработанным
				processedLogins.add(login);

				return introString + fullName + " (" + login + ")" + "!\n";
			}
		};

		EmailCreator emailCreator = new EmailCreator(gg);
		System.out.println(emailCreator.createEmail("mr_Dark", "Рады видеть вас в нашем приложении"));
		// второе письмо к пользователю mr_Dark будет содержать новое приветствие
		System.out.println(emailCreator.createEmail("mr_Dark", "Рады видеть вас в нашем приложении"));

	}
}

@FunctionalInterface
interface GreetingGenerator {
	String generateGreeting(String login);
}

class EmailCreator {
	// объект GreetingGenerator используется для генерации приветствия в письме
	private GreetingGenerator greetingCreator;

	public EmailCreator(GreetingGenerator greetingCreator) {
		this.greetingCreator = greetingCreator;
	}

	public String createEmail(String login, String text) {
		return greetingCreator.generateGreeting(login) + text;
	}
}
