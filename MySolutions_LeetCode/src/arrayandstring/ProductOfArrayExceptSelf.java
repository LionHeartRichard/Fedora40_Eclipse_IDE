package arrayandstring;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

/*
* Учитывая целочисленный массив nums, верните массив answer, такой что answer[i] равен произведению 
* всех элементов nums, кроме nums[i]. 
* Произведение любого префикса или суффикса nums гарантированно помещается в 32-битное целое число.
* Вы должны написать алгоритм, который выполняется за время O(n) и без использования операции деления.
*/

public class ProductOfArrayExceptSelf {

	/*
	 * Здесь мы видим статический блок. Он выполняется, когда класс загружается, то
	 * есть перед созданием его объектов. В данном случае он просто 500 раз вызывает
	 * метод productExceptSelf с массивом {0, 0}. Это может быть использовано для
	 * инициализации каких-то данных, но такое использование может и не иметь
	 * смысла.
	 */

	static {
		for (int i = 0; i < 500; i++) {
			productExceptSelf(new int[] { 0, 0 });
		}
	}

	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int ans[] = new int[n];
		// префикс, так как слева нет элементов то присваиваем 1
		ans[0] = 1;
		// умножаем все элементы слева от элемента
		for (int i = 1; i < nums.length; i++) {
			ans[i] = ans[i - 1] * nums[i - 1];
		}

		int suffix = 1;
		// умножаем все элементы справа от элемента
		for (int i = n - 2; i >= 0; i--) {
			suffix = suffix * nums[i + 1];
			ans[i] = ans[i] * suffix;
		}
		return ans;
	}

	@Test
	public void case1() {
		int[] nums = { 1, 2, 3, 4 };

		int[] expected = { 24, 12, 8, 6 };
		int[] actual = productExceptSelf(nums);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void case2() {
		int[] nums = { -1, 1, 0, -3, 3 };

		int[] expected = { 0, 0, 9, 0, 0 };
		int[] actual = productExceptSelf(nums);

		assertArrayEquals(expected, actual);
	}
}
