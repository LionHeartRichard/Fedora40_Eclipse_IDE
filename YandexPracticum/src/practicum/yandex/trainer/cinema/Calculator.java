package practicum.yandex.trainer.cinema;

import java.util.List;

class Calculator {

	private Calculator() {
	}

	private static final int NUNBER_OF_MINUTES_IN_HOUR = 60;
	private static final int NUMBER_HOUR_IN_DAY = 24;

	public static double calculate(List<MediaItem> mediaItems) {
		// Напишите реализацию метода, который будет возвращать общее количество дней,
		// потраченных на просмотр фильмов и сериалов
		double countDay = 0;
		for (MediaItem item : mediaItems) {
			if (item instanceof Series) {
				Series series = (Series) item;
				countDay += series.getRuntime() * series.getSeriesCount();
			} else {
				countDay += item.getRuntime();
			}
		}
		countDay /= NUMBER_HOUR_IN_DAY;
		countDay /= NUNBER_OF_MINUTES_IN_HOUR;
		return countDay;
	}

}