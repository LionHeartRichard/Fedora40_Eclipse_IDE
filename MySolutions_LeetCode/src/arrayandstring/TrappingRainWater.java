package arrayandstring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Даны n неотрицательных целых чисел, представляющих карту высот, где ширина каждого столбца равна 1. 
 * Рассчитайте, сколько воды она может удержать после дождя.
 */

public class TrappingRainWater {
	public int trap(int[] height) {

		/*
		 * leftIdx and rightIdx!!!!
		 */

		int slowIdx = 0, fastIdx = 0, len = height.length;
		// создаем кэш предварительных результатов
		int[] cache = new int[len];
		int ans = 0;
		// используя быстрый и медленный указатель перемещяемся по высотам
		// медленный находит первую не нулевую высоту - которая барьер,
		// быстрый ищет следующую, перемножаем результат этих высот
		// далее внутри них двигаемся вычитая высоты встречающиеся на пути
		// после заносим в кэш
		while (slowIdx < len && fastIdx < len) {
			if (slowIdx + 1 < len && height[slowIdx] == 0 && height[slowIdx] < height[slowIdx + 1]) {
				++slowIdx;
			} else if (slowIdx + 1 < len) {
				fastIdx = slowIdx + 1;
				while (fastIdx < len && height[fastIdx] < height[slowIdx]) {
					++fastIdx;
				}
				int tmp = height[slowIdx] * (fastIdx - slowIdx - 1);
				while (slowIdx < fastIdx - 1) {
					tmp -= height[++slowIdx];
				}
				if (tmp > 0)
					cache[slowIdx] = tmp;
			}
		}
		// в цикле складываем кэш и получаем результат

		for (int item : cache) {
			ans += item;
		}

		return ans;
	}

	@Test
	public void case1() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		int expected = 6;
		int actual = trap(height);

		assertEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] height = { 4, 2, 0, 3, 2, 5 };

		int expected = 9;
		int actual = trap(height);

		assertEquals(expected, actual);
	}

	@Test
	public void case3() {
		int[] height = { 5, 2, 2, 3, 0, 3, 0, 4, 0, 5 };

		int expected = 26;
		int actual = trap(height);

		assertEquals(expected, actual);
	}

	@Test
	public void case4() {
		int[] height = { 2, 0, 0, 0, 4, 0, 0, 0, 0, 0, 4, 0, 0, 2 };

		int expected = 30;
		int actual = trap(height);

		assertEquals(expected, actual);
	}
}
