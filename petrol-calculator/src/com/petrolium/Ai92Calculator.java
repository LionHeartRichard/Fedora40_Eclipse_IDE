package com.petrolium;

class Ai92Calculator {
	double price = 42.74;

	public double calculate(double volume, double discount) {
		double fullPrice = price * (1 + discount);
		System.out.println("fullPrice = " + fullPrice);
		return volume * fullPrice;
	}
}
