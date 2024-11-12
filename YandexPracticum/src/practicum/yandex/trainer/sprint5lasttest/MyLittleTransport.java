package practicum.yandex.trainer.sprint5lasttest;

import java.util.ArrayList;
import java.util.List;

class MyLittleTransport {

	public static void main(String[] args) {
		List<Transport> transportList = new ArrayList<>();

		TrafficInspector<Transport> trafficInspector = new TrafficInspector<>();
		trafficInspector.moveCarsInTraffic(transportList);
	}

}

interface Transport {
	boolean move(); // вернёт false — если нельзя проехать, если можно — true
}

interface Car extends Transport {
	int getPassengersCount(); // возвращает количество пассажиров
}

interface Truck extends Transport {
	String getCargoType(); // возвращает тип груза
}

class TrafficInspector<T extends Transport> {

	public List<T> moveCarsInTraffic(List<T> transports) {
		List<T> result = new ArrayList<>();
		for (T transport : transports) {
			if (!transport.move()) {
				result.add(transport);
			}
		}
		return result;
	}
}

// импл
