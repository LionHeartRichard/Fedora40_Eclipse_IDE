package functionimmutable;

import java.util.Collection;
import java.util.Set;

public class Candy {

	final String name;

	final String producer;

	final int price;
	// проданное количество
	final int amountSold;

	final Set<String> alternateNames;

	public Candy(String name, String producer, int price, int amountSold, Collection<String> alternateNames) {
		this.name = name;
		this.producer = producer;
		this.price = price;
		this.amountSold = amountSold;
		this.alternateNames = Set.copyOf(alternateNames);
	}

	public static int compareByName(Candy c1, Candy c2) {
		return c1.name.compareTo(c2.name);
	}

	@Override
	public String toString() {
		return "Candy{" + "name='" + name + '\'' + ", producer='" + producer + '\'' + ", price=" + price
				+ ", amountSold=" + amountSold + ", alternateNames=" + alternateNames + '}';
	}

}
