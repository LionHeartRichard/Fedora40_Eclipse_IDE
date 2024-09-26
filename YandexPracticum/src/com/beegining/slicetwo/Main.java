package com.beegining.slicetwo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Hamster bite = new Hamster("Байт", 2, 350, "Рыжий");

		Hamster ninja = new Hamster("Ниндзя", 1, 250, "Белый");

		Hamster kuzya = new Hamster("Кузя", 3, 450, "Пятнистый");

		Hamster paskal = new Hamster("Паскаль", 2, 320, "Чёрный");

		System.out.println(bite.name);
		System.out.println(ninja.name);
		System.out.println(kuzya.name);
		System.out.println(paskal.name);
	}
}