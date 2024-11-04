package practicum.yandex.trainer.testsjunit;

import java.util.ArrayList;
import java.util.Random;

class FortuneCookieFactory {

	private final FortuneConfig fortuneConfig;
	private int cookiesBaked = 0;

	private final Random rnd = new Random();
	private final ArrayList<String> goodFortune;
	private final ArrayList<String> badFortune;

	public FortuneCookieFactory(FortuneConfig fortuneConfig, ArrayList<String> goodFortune,
			ArrayList<String> badFortune) {
		this.fortuneConfig = fortuneConfig;
		this.goodFortune = goodFortune;
		this.badFortune = badFortune;
	}

	/**
	 * Возвращает количество испечённых печенек
	 */
	public int getCookiesBaked() {
		return this.cookiesBaked;
	}

	/**
	 * Обнуляет счётчик созданных печенек
	 */
	public void resetCookiesCreated() {
		this.cookiesBaked = 0;
	}

	/**
	 * Печёт печеньку!
	 */
	public FortuneCookie bakeFortuneCookie() {
		final String fortune;

		// Возвращает хорошее или плохое предсказание
		if (this.fortuneConfig.isPositive()) {
			fortune = goodFortune.get(rnd.nextInt(goodFortune.size()));
		} else {
			fortune = badFortune.get(rnd.nextInt(badFortune.size()));
		}
		incrementNumberOfCookiesCreated();
		return new FortuneCookie(fortune);
	}

	/**
	 * Увеличивает счётчик испечённых печенек
	 */
	private void incrementNumberOfCookiesCreated() {
		this.cookiesBaked++;
	}
}
