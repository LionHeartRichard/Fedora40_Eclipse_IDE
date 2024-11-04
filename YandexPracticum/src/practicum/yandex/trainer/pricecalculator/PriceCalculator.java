package practicum.yandex.trainer.pricecalculator;

class PriceCalculator {

	private static final int BIKE_PRICE_PER_KM = 10;
	private static final int CAR_PRICE_PER_KM = 7;
	private static final int TRUCK_PRICE_PER_KM = 5;

	public Integer calculatePrice(TransportType transportType, int distanceKm) {
		switch (transportType) {
		case BIKE:
			return calculateForBike(distanceKm);
		case CAR:
			return calculateForCar(distanceKm);
		case TRUCK:
			return calculateForTruck(distanceKm);
		default:
			return null;
		}
	}

	private int calculateForTruck(int distanceKm) {
		if (distanceKm <= 0)
			return -1;
		return distanceKm * TRUCK_PRICE_PER_KM;
	}

	private int calculateForCar(int distanceKm) {
		if (distanceKm > 1000)
			return -2;
		if (distanceKm <= 0)
			return -1;
		return distanceKm * CAR_PRICE_PER_KM;
	}

	private int calculateForBike(int distanceKm) {
		if (distanceKm > 20)
			return -2;
		if (distanceKm <= 0)
			return -1;
		return distanceKm * BIKE_PRICE_PER_KM;
	}
}
