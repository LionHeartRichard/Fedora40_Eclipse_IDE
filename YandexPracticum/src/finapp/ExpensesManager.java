package finapp;

public class ExpensesManager {
	private double[] expenses;

	public ExpensesManager() {
		expenses = new double[7];
	}

	public double saveExpense(double moneyBeforeSalary, double expense, int day) {
		moneyBeforeSalary = moneyBeforeSalary - expense;
		expenses[day - 1] = expenses[day - 1] + expense;
		System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
		if (moneyBeforeSalary < 1000) {
			System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
		}
		return moneyBeforeSalary;
	}

	public void printAllExpenses() {
		for (int i = 0; i < expenses.length; i++) {
			System.out.println("День " + (i + 1) + ". Потрачено " + expenses[i] + " рублей");
		}
	}

	public double findMaxExpense() {
		double maxExpense = 0;
		for (int i = 0; i < expenses.length; i++) {
			if (expenses[i] > maxExpense) {
				maxExpense = expenses[i];
			}
		}
		return maxExpense;
	}
}
