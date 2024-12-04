package com.yandexpracticum.workbyexeption.trainer;

class LimitException extends RuntimeException {

	private final int attempts;

	public LimitException(final String message, final int attempts) {
		super(message);
		this.attempts = attempts;
	}

	public String getDetailMessage() {
		return getMessage() + attempts;
	}
}
