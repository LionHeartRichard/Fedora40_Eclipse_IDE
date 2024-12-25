package dinamicprograming;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class Fibonacci {

	private int[] cach = new int[48];

	// Пример динамического программирования снизу!!!!!!!!
	public int fib(int n) {
		if (n <= 1)
			return n; // return n - used in Example or 1 - если нужно исключиьт повторение в начале
						// 1, 1
		if (cach[n] == 0)
			cach[n] = fib(n - 1) + fib(n - 2);
		return cach[n];
	}

	// Пример динамического программирования сверху!!!!!!!!!
	public int fibDinamic(int n) {
		int[] arrayFib = new int[n + 1];
		arrayFib[1] = 1;
		for (int i = 2; i <= n; ++i) {
			arrayFib[i] = arrayFib[i - 1] + arrayFib[i - 2];
		}
		return arrayFib[n];
	}

	// Пример расчета факториала
	public long getFactorial(int n) {
		long factorial = 1;
		for (int i = 2; i <= n; ++i) {
			factorial *= i;
		}
		return factorial;
	}

	@Test
	public void testFibRecursionWithCach() {
		int num = 46;
		int actual = fib(num);

		System.out.println("fib[" + num + "] = " + actual);

		int expected = 1836311903;

		assertEquals(expected, actual);
	}

	@Test
	public void testFibDinamic() {
		int num = 46;
		int actual = fibDinamic(num);

		System.out.println("fibDinamic[" + num + "] = " + actual);

		int expected = 1836311903;

		assertEquals(expected, actual);
	}

	@Test
	public void testFactorial() {
		long actual = getFactorial(10);
		long expected = 3628800l;

		assertEquals(expected, actual);
	}

}
