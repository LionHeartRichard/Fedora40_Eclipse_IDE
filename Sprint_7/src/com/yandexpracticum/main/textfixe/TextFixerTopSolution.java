package com.yandexpracticum.main.textfixe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TextFixerTopSolution {

	public String capitalize(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public String fixText(String text) {
		text = text.trim();
		text = capitalize(text);
		text = text.replace("„", "«");
		text = text.replace("“", "»");
		text = text.replace("цевилизаций", "цивилизаций");
		return text;
	}

	@Test
	public void test() {
		String text = "    история каждой из крупных галактических цевилизаций может быть разделена на три различные, "
				+ "ярко выраженные фазы: Борьба за выживание, Любопытство и Утонченность, также именуемые фазами "
				+ "„Как?“, „Зачем?“ и „Где?“. Пример: если для первой фазы характерен вопрос: „Как бы нам поесть?“,"
				+ " а для второй „Зачем мы едим?“, то третья отличается вопросом: „Где бы нам лучше поужинать?“.   ";

		TextFixer textFixer = new TextFixer();
		String expected = textFixer.fixText(text);
		TextFixerTopSolution txtFix = new TextFixerTopSolution();
		String actual = txtFix.fixText(text);

		assertEquals(expected, actual);
	}
}