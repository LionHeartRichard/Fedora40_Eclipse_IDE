package lambda.closures;

public class EmailCreator {
	// объект GreetingGenerator используется для генерации приветствия в письме
	private GreetingGenerator greetingCreator;

	public EmailCreator(GreetingGenerator greetingCreator) {
		this.greetingCreator = greetingCreator;
	}

	public String createEmail(String login, String text) {
		return greetingCreator.generateGreeting(login) + text;
	}
}
