package com.finapplication;

public class Expense {

	// величина траты
	private double value;

	// номер транзакции
	private int transaction;

	public double getValue() {
		return value;
	}

	public void setValue(double val) {
		value = val;
	}

	public Integer getTransaction() {
		return transaction;
	}

	public void setTransaction(Integer tr) {
		transaction = tr;
	}

	/*
	 * В конструкторе мы сгенерируем уникальный номер транзакции от 0 до 1 000 000 с
	 * помощью функции Math.random();
	 */
	public Expense(double val) {
		value = val;
		transaction = (int) Math.round(Math.random() * 1_000_000);
	}

}