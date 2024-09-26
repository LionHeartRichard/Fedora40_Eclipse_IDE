package ru.yandex.practicum;

public class MonthData {
	private int[] days = new int[30];

	public MonthData() {
	}

	public MonthData(int[] days) {
		this.days = days;
	}

	public MonthData(int numberDaysByMonth) {
		this.days = new int[numberDaysByMonth];
	}

	public int getStepsByDay(int idxDay) {
		return days[idxDay];
	}

	public void setStepsByDay(int idxDay, int steps) {
		days[idxDay] = steps;
	}

	public int[] getDays() {
		return days;
	}

	public void setDays(int[] days) {
		this.days = days;
	}

	void printDaysAndStepsFromMonth() {

		for (int i = 0; i < days.length; ++i) {
			System.out.println("    В " + (i + 1) + "-й день вы прошли " + days[i] + " шагов");
		}
	}

	int sumStepsFromMonth() {
		int sum = 0;
		for (int i = 0; i < days.length; ++i) {
			sum += days[i];
		}
		return sum;
	}

	int[] maxSteps() {
		int max = 0, idxMax = 0;
		for (int i = 0; i < days.length; ++i) {
			if (max < days[i]) {
				max = days[i];
				idxMax = i;
			}
		}
		return new int[] { idxMax, max };
	}

	int[] bestSeries(int goalByStepsPerDay) {
		int currentSeries = 0;
		int finalSeries = 0;
		int beginIdx = 0;
		int beginIdxFinSeries = 0;
		for (int i = 0; i < days.length; ++i) {
			if (days[i] > goalByStepsPerDay) {
				if (beginIdx == 0) {
					beginIdx = i;
				}
				++currentSeries;
			} else {
				if (finalSeries < currentSeries) {
					finalSeries = currentSeries;
					beginIdxFinSeries = beginIdx;
				}
				currentSeries = 0;
			}
		}

		return new int[] { beginIdxFinSeries, finalSeries };
	}

	public int getNumberDays() {
		return days.length;
	}

}
