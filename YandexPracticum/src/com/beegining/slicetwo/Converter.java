package com.beegining.slicetwo;

public class Converter {
	double rateUSD = 94.8;
	double rateEUR = 103.8;
	double rateCNY = 13.1;

	void convert(double rubles, int currency) {
		if (currency == 1) {
			System.out.println("Ваши сбережения в долларах: " + rubles / rateUSD);
		} else if (currency == 2) {
			System.out.println("Ваши сбережения в евро: " + rubles / rateEUR);
		} else if (currency == 3) {
			System.out.println("Ваши сбережения в юанях: " + rubles / rateCNY);
		} else {
			System.out.println("Введена неизвестная валюта.");
		}
	}
}
