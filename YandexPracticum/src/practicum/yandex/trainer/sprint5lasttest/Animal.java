package practicum.yandex.trainer.sprint5lasttest;

interface Animal {

}

interface Herbivore {
	void eat(Plant plant);
}

interface Carnivore {
	void eat(Herbivore herbivore);

	void eat(Animal animal);
}

interface Plant {

}

interface Wolf extends Animal, Carnivore {

}

interface Rabbit extends Animal, Herbivore {

}

interface Ape extends Animal, Herbivore, Carnivore {

}
