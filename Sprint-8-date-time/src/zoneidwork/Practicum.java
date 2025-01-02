package zoneidwork;

class Practicum {
	public static void main(String[] args) {
		Watch watch = new Watch();

		// настройка часов
		watch.changeTimeZone();
		watch.changeTimeZone();
		watch.addTenHours();
		watch.addTenMinutes();
		watch.addTenMinutes();
		for (int i = 1; i <= 6; ++i) {
			watch.addMinute();
		}
		System.out.println(watch.getCurrentTime());
	}
}
