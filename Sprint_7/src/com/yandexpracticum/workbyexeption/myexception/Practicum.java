package com.yandexpracticum.workbyexeption.myexception;

class Practicum {
	public static void main(String[] args) {
		printRangeInteger("10", 0, 100);
		printRangeInteger("-10", 0, 100);
		printRangeInteger("110", 0, 100);
		printRangeInteger("abc", 0, 100);
	}

	public static void printRangeInteger(final String inputString, final int from, final int to) {
		try {
			final int input = Integer.parseInt(inputString);
			if (input < from) {
				throw new InputException("Введённое число слишком маленькое!", input);
			}
			if (input > to) {
				throw new InputException("Введённое число слишком большое!", input);
			}
			System.out.println(input);
		} catch (NumberFormatException exception) {
			System.out.println("Ошибка ввода - введено не число!");
		} catch (InputException exception) {
			System.out.println(exception.getDetailMessage());
		}
	}
}
