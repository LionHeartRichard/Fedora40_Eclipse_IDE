package begin;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

class Practicum {

	public static void main(String[] args) {
		// создайте экземпляр класса Owner (владелец)
		Owner owner = new Owner("D", "Dracula");

		// создайте экземпляр класса Dog (собака)
		Dog dog = new Dog("Mehanicys", owner, 200);

		Gson gson = new Gson();

		// сериализуйте объект класса Dog в JSON
		String jsonString = gson.toJson(dog);
		System.out.println(jsonString);

		jsonString = "{\"name\":\"Тузик\",\"owner\":{\"name\":\"Игорь\",\"surname\":\"Петров\"},\"age\":3}";

		// получаем объект из JSON-строки (десереализуем)
		dog = gson.fromJson(jsonString, Dog.class);

		// выводим значения полей десериализованного объекта
		System.out.println("Собака:");
		System.out.println("Кличка: " + dog.getName());
		System.out.println("Возраст: " + dog.getAge());
		System.out.println("Владелец:");

		owner = dog.getOwner();
		System.out.println("Имя: " + owner.getName());
		System.out.println("Фамилия: " + owner.getSurname());
	}
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class Dog {
	private String name;
	private Owner owner;
	private int age;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class Owner {
	private String name;
	private String surname;
}
