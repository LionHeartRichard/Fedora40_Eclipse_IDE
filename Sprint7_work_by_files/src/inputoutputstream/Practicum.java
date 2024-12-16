package inputoutputstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class Practicum {

	public static void main(String[] args) {
		Map<String, Integer> frequencyMap = new HashMap<>();

		try (FileReader reader = new FileReader("result.txt"); BufferedReader br = new BufferedReader(reader)) {

			while (br.ready()) {
				String letter = br.readLine();
				if (frequencyMap.containsKey(letter)) {
					frequencyMap.put(letter, frequencyMap.get(letter) + 1);
				} else {
					frequencyMap.put(letter, 1);
				}
			}

			frequencyMap.forEach((k, v) -> System.out.println(k + ": " + v));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
