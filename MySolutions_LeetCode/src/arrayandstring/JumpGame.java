package arrayandstring;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/*
 * Мы можем начать прыгать с первого индекса
 * нам необходимо пропрыгать до конца
 * нам нельзя иметь 0 в начале массива, если только это не массив из одного элемента 
 */

public class JumpGame {

	public boolean canJump(int[] nums) {

		int len = nums.length;
		// создаем переменную куда будем записывать максимальный возможный прыжок
		int maxJump = 0;

		// итерируемся по всему массиву
		for (int idx = 0; idx < len; ++idx) {
			// если индекс превысил максимальный прыжок, значит нет больше возможности
			// прыгать
			if (idx > maxJump)
				return false;
			// узнаем что больше максимальный прыжок или сколько мы проитерировались
			maxJump = Math.max(maxJump, idx + nums[idx]);
			// если мы пропрыгали до последнего элемента то true
			if (maxJump >= len - 1)
				return true;
		}
		return false;
	}

	@Test
	public void case1() {
		int[] nums = { 2, 3, 0, 0, 4 };

		boolean actual = canJump(nums);

		assertTrue(actual);
	}

	@Test
	public void case2() {
		int[] nums = { 3, 2, 1, 0, 4 };

		boolean actual = canJump(nums);

		assertFalse(actual);
	}

	@Test
	public void case3() {
		int[] nums = { 2, 0, 2 };

		boolean actual = canJump(nums);

		assertTrue(actual);
	}
}
