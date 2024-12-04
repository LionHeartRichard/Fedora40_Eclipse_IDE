package com.yandexpracticum.workbyexeption.myexception;

class InputException extends Exception {

	private final int inputValue;

	public InputException(final String message, final int inputValue) {
		super(message);
		this.inputValue = inputValue;
	}

	public String getDetailMessage() {
		return getMessage() + " = " + inputValue;
	}
}
