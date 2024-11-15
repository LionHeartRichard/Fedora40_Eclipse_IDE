package topalgorithm.roadmap.sorting.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class CountSort {

	// time O[1]
	// memory O[1]

	private int[] arrayCounterLettersNoCapital = new int[26];

	public boolean isAnagram(String strA, String strB) {
		if (strA.length() == strB.length()) {
			int idx;
			for (int idxChar = 0; idxChar < strA.length(); ++idxChar) {
				idx = strA.charAt(idxChar) - 'a';
				++arrayCounterLettersNoCapital[idx];
				idx = strB.charAt(idxChar) - 'a';
				--arrayCounterLettersNoCapital[idx];
			}

			for (int item : arrayCounterLettersNoCapital) {
				if (item != 0)
					return false;
			}
			return true;
		}
		return false;
	}

	@Test
	public void isAnagramWhenValidDataThenReturnTrue() {
		String strA = "arturdefrance";
		String strB = "artuedrecnfra";

		assertTrue(isAnagram(strA, strB));
	}

	@Test
	public void isAnagramWhenValidDataThenReturnFalse() {
		String strA = "arturdefranceoerptfgdgnkdfgewnrlnkdsnldnsfklnsldnlsdknsdnlkgnlksdnglkdsgfnvslkdnksfhwalnvd";
		String strB = "artuedrecnfradsoflkadasnfslaknlskdekrndsiodfsaklnaklgndsklagkladsgnsdlgndgnlsnglassavmlsdf";

		assertFalse(isAnagram(strA, strB));
	}

}
