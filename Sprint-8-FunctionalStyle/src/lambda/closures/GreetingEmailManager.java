package lambda.closures;

public class GreetingEmailManager {

	public static void main(String[] args) {
		String fullName = "Николай";

		// лямбда сохранена в переменную gg и будет использована позже
		GreetingGenerator gg = login -> "Приветствуем вас, " + fullName + " (" + login + ")" + "!\n";
		// теперь переменная fullName не изменяемая (final), зато мы имее доступ к ней
		// из методов!!!

		EmailCreator emailCreator = new EmailCreator(gg);
		System.out.println(emailCreator.createEmail("mr_Dark", "Рады видеть вас в нашем приложении"));

	}
}
