package practicum.yandex.trainer.workbyenum;

import java.util.ArrayList;

class Practicum {

	public static void main(String[] args) {
		ArrayList<Task> tasks = new ArrayList<>();
		tasks.add(new Task(TaskPriority.HIGH, "Оплатить интернет."));
		tasks.add(new Task(TaskPriority.LOW, "Сходить в парикмахерскую."));
		tasks.add(new Task(TaskPriority.MEDIUM, "Выбрать подарок подруге на ДР."));
		tasks.add(new Task(TaskPriority.MEDIUM, "Купить билеты в театр."));
		tasks.add(new Task(TaskPriority.HIGH, "Посетить вебинар по английскому языку."));
		tasks.add(new Task(TaskPriority.LOW, "Купить пылесос."));

		System.out.println("Задачи с наивысшим приоритетом на сегодня:");
		for (Task task : tasks) {
			if (task.getPriority() == TaskPriority.HIGH)
				System.out.println(task.getDescription());
		}

		System.out.println("-".repeat(50));
		System.out.println("Vusa type:");
		for (VisaType type : VisaType.values()) {
			System.out.println(type);
		}

		System.out.println("-".repeat(50));
		System.out.println(getDownloadLink(DeviceType.ANDROID));

		System.out.println("-".repeat(50));
		for (Continent continent : Continent.values()) {
			System.out.println(continent + " " + PopulationInformer.getPopulationPercent(continent));
		}
	}

	public static String getDownloadLink(DeviceType type) {
		String link = null;
		switch (type) {
		case ANDROID -> link = "https://play.google.com/store/apps/раздельный_сбор_мусора";
		case IOS -> link = "https://apps.apple.com/ru/app/раздельный_сбор_мусора";
		default -> link = "https://сайт_про_раздельный_сбор_мусора.ru";
		}
		return link;
	}
}
