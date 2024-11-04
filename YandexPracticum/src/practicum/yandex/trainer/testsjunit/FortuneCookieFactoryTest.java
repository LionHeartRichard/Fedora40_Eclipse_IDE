package practicum.yandex.trainer.testsjunit;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FortuneCookieFactoryTest {

	private static ArrayList<String> goodFortune;
	private static ArrayList<String> badFortune;
	private static FortuneConfig config;
	FortuneCookieFactory factory;

	@BeforeEach
	public void initFortuneCookieFactory() {
		goodFortune = new ArrayList<>();
		goodFortune.add("good!!!");
		badFortune = new ArrayList<>();
		badFortune.add("bad!!!");
		config = new FortuneConfig(true);
		factory = new FortuneCookieFactory(config, goodFortune, badFortune);
	}

	@Test
	public void shouldIncrementCountByOneAfterOneCookieBaked() {
		factory.bakeFortuneCookie();
		int actual = factory.getCookiesBaked();
		Assertions.assertEquals(1, actual);
	}

	@Test
	public void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
		factory.bakeFortuneCookie();
		factory.bakeFortuneCookie();
		int actual = factory.getCookiesBaked();
		Assertions.assertEquals(2, actual);
	}

	@Test
	public void shouldSetCounterToZeroAfterResetCookieCreatedCall() {
		factory.bakeFortuneCookie();
		factory.bakeFortuneCookie();
		factory.resetCookiesCreated();
		int actual = factory.getCookiesBaked();
		Assertions.assertEquals(0, actual);
	}
}
