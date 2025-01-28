package begin.collectiondeserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

class User {
	private String name;
	private int age;

	public User() {
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}

// вспомогательный класс для определения типа коллекции и типа её элементов
class UserListTypeToken extends TypeToken<List<User>> {
	// здесь ничего не нужно реализовывать
}

public class Practicum {

	public static void main(String[] args) {
		List<User> users = List.of(new User("Мария", 26), new User("Иван", 41), new User("Григорий", 16));

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String usersArrayJson = gson.toJson(users);

		// используем TypeToken для указания правильного типа
		List<User> usersList = gson.fromJson(usersArrayJson, new UserListTypeToken().getType());

		// используем методы класса User у элементов списка пользователей
		System.out.println("User name: " + usersList.get(0).getName() + ", User age: " + usersList.get(0).getAge());
	}
}
