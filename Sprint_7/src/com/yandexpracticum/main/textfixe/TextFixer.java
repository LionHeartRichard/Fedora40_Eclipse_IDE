package com.yandexpracticum.main.textfixe;

import java.util.HashMap;
import java.util.Map;

class TextFixer {

	public String capitalize(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public String changesSybol(String text, Map<Character, Character> symbolsChanges) {
		Map<Character, Character> changeMap = symbolsChanges;

		char[] arr = text.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int idx = 0; idx < arr.length; ++idx) {
			if (changeMap.containsKey(arr[idx])) {
				arr[idx] = changeMap.get(arr[idx]);
			}
			builder.append(arr[idx]);
		}

		return builder.toString();
	}

	public String fixText(String text) {
		text = text.trim();
		text = capitalize(text);

		Map<Character, Character> symbolsChanges = new HashMap<>();
		symbolsChanges.put('„', '«');
		symbolsChanges.put('“', '»');
		text = changesSybol(text, symbolsChanges);

		String wrongLine = "цевилизаций";
		String correctLine = "цивилизаций";
		text = text.replace(wrongLine, correctLine);
		return text;
	}

	public static void main(String[] args) {

		String text = "    история каждой из крупных галактических цевилизаций может быть разделена на три различные, "
				+ "ярко выраженные фазы: Борьба за выживание, Любопытство и Утонченность, также именуемые фазами "
				+ "„Как?“, „Зачем?“ и „Где?“. Пример: если для первой фазы характерен вопрос: „Как бы нам поесть?“,"
				+ " а для второй „Зачем мы едим?“, то третья отличается вопросом: „Где бы нам лучше поужинать?“.   ";

		var textFixer = new TextFixer();
		var fixedText = textFixer.fixText(text);
		System.out.println(fixedText);
	}
}