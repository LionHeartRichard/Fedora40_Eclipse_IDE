package com.beegining.slicetwo;

public class Hamster {

	 String name;   // имя
	    int age;       // возраст
	    int weight; // вес в граммах
	    String color;  // цвет

	    // конструктор № 1 создаёт только рыжих хомяков (нельзя изменить цвет при создании)
	    Hamster(String hamsterName, int hamsterAge, int hamsterWeight) {
	        name = hamsterName;
	        age = hamsterAge;
	        weight = hamsterWeight;
	        color = "Рыжий"; // закрепили за переменной постоянное значение
	    }

	    // конструктор № 2 создаёт разных хомяков (помимо прочего можно указать и цвет)
	    Hamster(String hamsterName, int hamsterAge, int hamsterWeight, String hamsterColor) {
	        name = hamsterName;
	        age = hamsterAge;
	        weight = hamsterWeight;
	        color = hamsterColor;
	    }
}
