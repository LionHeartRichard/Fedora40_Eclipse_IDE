package practicum.yandex.trainer.sprint5lasttest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathsTest {

	@Test
	public void sumOfTwoPositiveIsCorrect() {
		Assertions.assertEquals(5, 2 + 3, "Сумма некорректна!");
	}

	@Test
	public void sumOfPositiveAndNegativeIsCorrect() {
		Assertions.assertEquals(-1, 2 + (-3), "Сумма некорректна!");
	}

	@Test
	public void sumOfTwoNegativeIsCorrect() {
		Assertions.assertEquals(-5, (-2) + (-3), "Сумма некорректна!");
	}

	@Test
	public void sumOfPositiveAndZeroIsCorrect() {
		Assertions.assertEquals(7, 0 + 7, "Сумма некорректна!");
	}
}
