package ru.yandex.practicum.sprint6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class PairGenerator {

	private static final Random rnd = new Random();

	public List<List<Stranger>> splitByPairs(List<Stranger> strangers) {
		List<List<Stranger>> pairs = new ArrayList<>();
		while (!strangers.isEmpty()) {
			List<Stranger> pair = getRandomPair(strangers);
			pairs.add(pair);
		}
		return pairs;
	}

	private List<Stranger> getRandomPair(List<Stranger> strangers) {

		int p1Index = rnd.nextInt(strangers.size());
		int p2Index = rnd.nextInt(strangers.size());
		while (p2Index == p1Index) {
			p2Index = rnd.nextInt(strangers.size());
		}

		Stranger strangerOne = strangers.get(p1Index);
		Stranger strangerTwo = strangers.get(p2Index);

		List<Stranger> res = new ArrayList<>();
		res.add(strangerOne);
		res.add(strangerTwo);

		strangers.removeAll(res);

		return res;
	}
}
