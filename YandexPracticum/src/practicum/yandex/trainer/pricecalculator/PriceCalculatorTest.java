package practicum.yandex.trainer.pricecalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PriceCalculatorTest {

	private final PriceCalculator priceCalculator = new PriceCalculator();

	@Test
	public void shouldBeNegativeWhenBikeAndDistanceIs0Km() {
		Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.BIKE, 0) < 0);
	}

}
