package practicum.yandex.trainer.animal;

import java.util.ArrayList;
import java.util.List;

public class Practicum {
	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<>();
		Dog dog = new Dog();
		animals.add(dog);
		Cat cat = new Cat();
		animals.add(cat);

		animals.forEach(v -> System.out.println(v.getClass().getName() + " goes " + v.say()));

	}

}