package lambda.higherorderfunctions;

import java.util.function.BiFunction;

public class ArithmeticOperationExample {

	public static void main(String[] args) {
		// Попробуйте выбрать другое значение операции из набора "+", "-", "*", "/"
		String operation = "max";
		// получаем лямбда-функцию, реализующую требуемую операцию
		BiFunction<Integer, Integer, Integer> arithmeticOperation = getOperation(operation);
		// Попробуйте изменить аргументы
		int arg1 = 7;
		int arg2 = 3;

		// вызываем полученную лямбда-функцию с заданными аргументами
		int result = arithmeticOperation.apply(arg1, arg2);
		System.out.println(result);
	}

	// функция, которая в зависимости от аргумента возвращает лямбда-функцию,
	// вычисляющую соответствующую операцию
	private static BiFunction<Integer, Integer, Integer> getOperation(String sign) {
		switch (sign) {
		case "+":
			return (value1, value2) -> value1 + value2;
		case "-":
			return (value1, value2) -> value1 - value2;
		case "*":
			return (value1, value2) -> value1 * value2;
		case "/":
			return (value1, value2) -> value1 / value2;
		case "min":
			return (value1, value2) -> value1 < value2 ? value1 : value2;
		case "max":
			return (value1, value2) -> value1 < value2 ? value2 : value1;
		default:
			throw new IllegalArgumentException("Неизвестная операция");
		}

	}
}
