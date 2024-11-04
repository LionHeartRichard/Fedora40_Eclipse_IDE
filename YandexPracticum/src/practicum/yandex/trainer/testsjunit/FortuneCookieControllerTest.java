package practicum.yandex.trainer.testsjunit;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FortuneCookieControllerTest {
	private static ArrayList<String> goodFortune;
	private static ArrayList<String> badFortune;
	private static FortuneConfig config;
	FortuneCookieFactory factory;

	@BeforeAll
	public static void initFortuneCookieFactory() {
		goodFortune = new ArrayList<>();
		goodFortune.add("good!!!");
		badFortune = new ArrayList<>();
		badFortune.add("bad!!!");
	}

	@Test
	public void shouldReturnPositiveFortune() {
		config = new FortuneConfig(true);
		factory = new FortuneCookieFactory(config, goodFortune, badFortune);
		Assertions.assertEquals("good!!!", factory.bakeFortuneCookie().getFortuneText());
	}

	@Test
	public void shouldReturnNegativeFortune() {
		config = new FortuneConfig(false);
		factory = new FortuneCookieFactory(config, goodFortune, badFortune);
		Assertions.assertEquals("bad!!!", factory.bakeFortuneCookie().getFortuneText());
	}
}
