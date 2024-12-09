package dinamicprograming;

public class Fibonacci {

	private int[] cach = new int[46];

	// Пример динамического программирования снизу!!!!!!!!
	public int fib(int n) {
		if (n <= 1)
			return 1; // return n - used in Example
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

}
