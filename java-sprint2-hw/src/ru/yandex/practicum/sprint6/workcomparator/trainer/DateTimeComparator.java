package ru.yandex.practicum.sprint6.workcomparator.trainer;

import java.util.Comparator;

class DateTimeComparator implements Comparator<DateTime> {

	private static final int BIT_DEPTH = 10;

	@Override
	public int compare(DateTime dateTime1, DateTime dateTime2) {
		int value = dateTime1.year - dateTime1.year;
		value *= BIT_DEPTH;
		value += dateTime1.month - dateTime2.month;
		value *= BIT_DEPTH;
		value += dateTime1.day - dateTime2.day;
		value *= BIT_DEPTH;
		value += dateTime1.hours - dateTime2.hours;
		value *= BIT_DEPTH;
		value += dateTime1.minutes - dateTime2.minutes;
		value *= BIT_DEPTH;
		value += dateTime1.seconds - dateTime2.seconds;
		return value;
	}
}
