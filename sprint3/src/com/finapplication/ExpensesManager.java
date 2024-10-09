package com.finapplication;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
	HashMap<String, ArrayList<Double>> expensesByCategories;

	ExpensesManager() {
		expensesByCategories = new HashMap<>();
	}

	double saveExpense(double moneyBeforeSalary, String category, double expense) {
		moneyBeforeSalary = moneyBeforeSalary - expense;
		System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
		if (expensesByCategories.containsKey(category)) {
			ArrayList<Double> expenses = expensesByCategories.get(category);
			expenses.add(expense);
		} else {
			ArrayList<Double> expenses = new ArrayList<>();
			expenses.add(expense);
			expensesByCategories.put(category, expenses);
		}
		if (moneyBeforeSalary < 1000) {
			System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
		}
		return moneyBeforeSalary;
	}

	void printAllExpensesByCategories() {
		for (String category : expensesByCategories.keySet()) {
			System.out.println(category);
			ArrayList<Double> expenses = expensesByCategories.get(category);
			for (Double expense : expenses) {
				System.out.println(expense);
			}
		}
	}

	double findMaxExpenseInCategory(String category) {
		double maxExpense = 0;
		if (expensesByCategories.containsKey(category)) {
			ArrayList<Double> expenses = expensesByCategories.get(category);
			for (Double expense : expenses) {
				if (expense > maxExpense) {
					maxExpense = expense;
				}
			}
		} else {
			System.out.println("Такой категории пока нет.");
		}
		return maxExpense;
	}

	void removeAllExpenses() {
		expensesByCategories.clear();
		System.out.println("Траты удалены.");
	}

	double getSumTotalExpenses() {
		double sum = 0.0;
		for (String category : expensesByCategories.keySet()) {
			ArrayList<Double> expenses = expensesByCategories.get(category);
			for (double exp : expenses) {
				sum += exp;
			}
		}
		return sum;
	}

	String getMaxCategoryExpense() {
		double maxCategorySum = 0;
		String maxCategoryName = "";
		for (String category : expensesByCategories.keySet()) {
			ArrayList<Double> expenses = expensesByCategories.get(category);
			double sum = 0.0;
			for (double exp : expenses) {
				sum += exp;
			}
			if (maxCategorySum < sum) {
				maxCategoryName = category;
				maxCategorySum = sum;
			}
		}
		return maxCategoryName;
	}

	public void removeCategory(String category) {
		if (expensesByCategories.containsKey(category)) {
			expensesByCategories.remove(category);
		}
	}
}