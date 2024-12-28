package functionimmutable;

import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {

	public static void main(String[] args) {
		List<Integer> inputNumbers = List.of(2, 5, 4, 2, 3, 8);

		List<Integer> evenNumbers = inputNumbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
		System.out.println(evenNumbers);
	}
}
