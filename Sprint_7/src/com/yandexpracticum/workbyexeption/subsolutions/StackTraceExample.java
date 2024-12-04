package com.yandexpracticum.workbyexeption.subsolutions;

class StackTraceExample {
	public static void main(String[] args) {
		try {
			calculate1();
		} catch (ArithmeticException exception) {
			for (StackTraceElement stack : exception.getStackTrace()) {
				System.out.println(String.format("Класс: " + stack.getClassName() + ", " + "метод: "
						+ stack.getMethodName() + ", " + "имя файла: " + stack.getFileName() + ", " + "строка кода: "
						+ stack.getLineNumber()));
			}
		}
	}

	public static void calculate1() {
		calculate2();
	}

	public static void calculate2() {
		System.out.println(10 / 0);
	}
}
