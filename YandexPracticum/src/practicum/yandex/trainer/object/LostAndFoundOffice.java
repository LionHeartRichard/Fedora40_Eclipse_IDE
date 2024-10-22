package practicum.yandex.trainer.object;

import java.util.ArrayList;
import java.util.List;

class LostAndFoundOffice {

	List<Object> things = new ArrayList<>();

	void put(Object object) {
		things.add(object);
	}


	boolean check(Object target) {
		for (Object object : things) {
			if (object.equals(target)) {
				return true;
			}
		}
		return false;
	}
}
