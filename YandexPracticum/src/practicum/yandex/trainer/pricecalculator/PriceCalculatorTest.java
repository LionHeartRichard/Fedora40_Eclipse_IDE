package practicum.yandex.trainer.pricecalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PriceCalculatorTest {

	private final PriceCalculator priceCalculator = new PriceCalculator();

	@Test
	public void shouldBeNegativeWhenBikeAndDistanceIs0Km() {
		Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.BIKE, 0) < 0);
	}

	@Test
	public void shouldBeNegativeWhenBikeAndDistanceIs21Km() {
		Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.BIKE, 21) < 0);
	}

	@Test
	public void checkPriceDeliveriesBikeWhenDistance10Km() {
		int expected = 10 * 10;
		int actual = priceCalculator.calculatePrice(TransportType.BIKE, 10);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void shouldBeNegativeWhenCarAndDistanceIs0Km() {
		Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 0) < 0);
	}

	@Test
	public void shouldBeNegativeWhenCarAndDistanceIs1001Km() {
		Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 1001) < 0);
	}

	@Test
	public void checkPriceDeliveriesCarWhenDistance700Km() {
		int expected = 7 * 700;
		int actual = priceCalculator.calculatePrice(TransportType.CAR, 700);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void shouldBeNegativeWhenTruckAndDistanceIs0Km() {
		Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.TRUCK, 0) < 0);
	}

	@Test
	public void checkPriceDeliveriesTruckWhenDistance_7_000Km() {
		int expected = 5 * 7_000;
		int actual = priceCalculator.calculatePrice(TransportType.TRUCK, 7_000);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void checkUsingTransportDroneShouldReturnNull() {
		Assertions.assertNull(priceCalculator.calculatePrice(TransportType.DRONE, 10));
	}
}
