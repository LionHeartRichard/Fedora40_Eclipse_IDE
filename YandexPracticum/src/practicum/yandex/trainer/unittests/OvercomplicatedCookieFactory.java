package practicum.yandex.trainer.unittests;

import java.util.ArrayList;
import java.util.Random;

class OvercomplicatedCookieFactory {
	private int cookiesCreated = 0;
	private final ArrayList<String> positiveTexts;
	private final ArrayList<String> negativeTexts;
	private final boolean isPositive;

	// класс Random используется, чтобы возвращать случайное предсказание из списка.
	private final Random rnd = new Random();

	public OvercomplicatedCookieFactory(ArrayList<String> positiveTexts, ArrayList<String> negativeTexts,
			boolean isPositive) {
		this.positiveTexts = positiveTexts;
		this.negativeTexts = negativeTexts;
		this.isPositive = isPositive;
	}

	// Печём печеньку!
	public String bakeFortuneCookie() {
		StringBuilder cookieBuilder = new StringBuilder();

		// увеличиваем счётчик печенек:
		this.incrementNumberOfCookiesCreated();

		// возвращаем хорошее или плохое предсказание:
		if (isPositive) {
			cookieBuilder.append(randomPositive());
		} else {
			cookieBuilder.append(randomNegative());
		}

		// преобразовываем результат в строку:
		return cookieBuilder.toString();
	}

	// возвращаем количество испечённых печенек:
	public int getCookiesCreated() {
		return this.cookiesCreated;
	}

	// обнуляем счётчик созданных печенек:
	public void resetCookiesCreated() {
		this.cookiesCreated = 0;
	}

	// Увеличиваем счётчик испечённых печенек:
	private void incrementNumberOfCookiesCreated() {
		this.cookiesCreated++;
	}

	// Выбираем произвольное предсказание из списка позитивных:
	private String randomPositive() {
		// Получаем целое случайное число от нуля до максимального размера массива - 1.
		int randomIndex = rnd.nextInt(positiveTexts.size());
		return positiveTexts.get(randomIndex);
	}

	// Выбираем произвольное предсказание из списка негативных:
	private String randomNegative() {
		// Получаем целое случайное число от нуля до максимального размера массива - 1.
		int randomIndex = rnd.nextInt(negativeTexts.size());
		return negativeTexts.get(randomIndex);
	}
}
