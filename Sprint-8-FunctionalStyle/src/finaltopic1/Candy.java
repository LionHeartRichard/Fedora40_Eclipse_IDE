package finaltopic1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Candy {

	final String name;
	final double price;
	final int amount;
	final Set<String> alternativeNames;

	public Candy(String name, double price, int amount, Collection<String> alternativeNames) {
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.alternativeNames = Set.copyOf(alternativeNames);
	}

	public Candy(String name, double price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.alternativeNames = new HashSet<>();
	}
}