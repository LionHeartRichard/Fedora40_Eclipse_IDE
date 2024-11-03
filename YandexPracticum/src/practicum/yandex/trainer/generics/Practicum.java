package practicum.yandex.trainer.generics;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Practicum {
	public static void main(String[] args) {
		// создаём двухуровневую хеш-таблицу для хранения расписания уроков
		AdvancedHashMap<String, Integer, String> timetable = new AdvancedHashMap<>();
		// добавляем уроки, с указанием дня недели и номера урока
		timetable.put("Понедельник", 1, "Русский язык");
		timetable.put("Понедельник", 2, "Математика");
		timetable.put("Вторник", 1, "Физкультура");
		timetable.put("Вторник", 2, "Русский язык");

		// выводим первый урок во вторник
		System.out.println(timetable.get("Вторник", 1));

		// получаем и выводим все уроки в понедельник
		List<String> mondayLessons = timetable.getAll("Понедельник");
		System.out.println(mondayLessons);
	}

}

class AdvancedHashMap<T1, T2, T3> {
	// данные будем хранить в хеш-таблице из хеш-таблиц
	Map<T1, Map<T2, T3>> internalHashMap = new HashMap<>();

	public void put(T1 key1, T2 key2, T3 value) {
		// получаем хеш-таблицу по первому ключу
		Map<T2, T3> innerHashMap = internalHashMap.get(key1);
		if (innerHashMap == null) {
			// вложенной хеш-таблицы по первому ключу пока нет — создаём её и добавляем в
			// internalHashMap
			innerHashMap = new HashMap<>();
			internalHashMap.put(key1, innerHashMap);
		}
		// добавляем элемент во вложенную хеш-таблицу
		innerHashMap.put(key2, value);
		internalHashMap.put(key1, innerHashMap);
	}

	public T3 get(T1 key1, T2 key2) {
		// получаем хеш-таблицу по первому ключу
		Map<T2, T3> innerHashMap = internalHashMap.get(key1);
		if (innerHashMap == null) {
			return null;
		}
		// получаем элемент из вложенной хеш-таблицы
		T3 item = innerHashMap.get(key2);
		return item;
	}

	public List<T3> getAll(T1 key1) {
		Map<T2, T3> innerHashMap = internalHashMap.get(key1);
		if (innerHashMap == null) {
			return new ArrayList<>();
		}
		return new ArrayList<T3>(innerHashMap.values());
	}
}
