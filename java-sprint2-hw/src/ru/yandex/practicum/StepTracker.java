package ru.yandex.practicum;

import java.util.Scanner;

public class StepTracker {
	private MonthData[] monthToData = new MonthData[12];
	private int goalByStepsPerDay = 10000;

	private Converter converter;
	private Scanner scanner;

	public StepTracker(Scanner scanner) {
		this.scanner = scanner;
		for (int i = 0; i < monthToData.length; ++i) {
			monthToData[i] = new MonthData();
		}
	}

	void addNewNumberStepsPerDay() {
		int month, day, steps;
		System.out.print("Введите номер месяца: ");
		month = isValid();
		System.out.print("Введите день: ");
		day = isValid();
		System.out.print("Введите пройденные шаги: ");
		steps = isValid();

		if (!isValidMonthDaySteps(month, day, steps)) {
			System.out.println("Введены не валидные данные!!!");
			return;
		}
		monthToData[month - 1].setStepsByDay(day - 1, steps);
	}

	private int isValid() {
		if (scanner.hasNextInt()) {
			return scanner.nextInt();
		}
		scanner.next();
		return 0;
	}

	private boolean isValidMonthDaySteps(int month, int day, int steps) {
		if (month < 1 || month > 12)
			return false;
		if (day < 1 || day > 30)
			return false;
		if (steps < 1)
			return false;
		return true;
	}

	void changeStepGoal() {
		System.out.print("Сколько шагов является вашей целью: ");
		int goalByStepsPerDay = isValid();
		if (goalByStepsPerDay < 1) {
			System.out.println("Ваша цель не может быть отрицательной или нулевой");
			return;
		}
		this.goalByStepsPerDay = goalByStepsPerDay;
	}

	void printStatistic() {
		System.out.print("Введите номер месяца: ");
		int currentMonth = isValid();
		int idx = currentMonth - 1;
		if (idx >= 0 && idx < 12) {
			if (isEmptyDays(idx)) {
				System.out.println("Дынные по этому месяцу не заполнены");
				return;
			}
			converter = new Converter();
			monthToData[idx].printDaysAndStepsFromMonth();
			System.out.println("_".repeat(20));

			int totalSteps = monthToData[idx].sumStepsFromMonth();
			System.out.println("Общее кол-во шагов: " + totalSteps);
			int[] maxStepsArray = monthToData[idx].maxSteps();
			System.out.println("В этот день вы преодолели максимальное количество шагов за месяц: " + maxStepsArray[0]);
			System.out.println("Максимальное пройденное количество шагов за месяц: " + maxStepsArray[1]);
			int mediumSteps = monthToData[idx].sumStepsFromMonth() / monthToData[idx].getNumberDays();
			System.out.println("_".repeat(20));
			System.out.println("Среднее количество шагов: " + mediumSteps);
			System.out.println("Пройденная дистанция в километрах: " + converter.convertToKm(totalSteps));
			System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(totalSteps));
			printBestSeries(idx);
		} else {
			System.out.println("Месяца с таким номером не существует!!!");
		}
	}

	private boolean isEmptyDays(int month) {
		for (int i = 0; i < monthToData[month].getNumberDays(); ++i) {
			int steps = monthToData[month].getStepsByDay(i);
			if (steps > 0) {
				return false;
			}
		}
		return true;
	}

	private void printBestSeries(int month) {
		int[] bestSeries = monthToData[month].bestSeries(goalByStepsPerDay);
		if (bestSeries != null) {
			int beginBestDay = bestSeries[0] + 1;
			int countBestDays = bestSeries[1];
			System.out.println("*".repeat(20));
			System.out.println("Лучшая серия месяца длилась " + countBestDays + " дней.");
			if (countBestDays > 1) {
				System.out.println(
						"Началась с " + beginBestDay + " по " + (beginBestDay + countBestDays) + " день включительно");
			}
			System.out.println("Вы отлично потрудились, так держать!!!");
		}
	}
}
