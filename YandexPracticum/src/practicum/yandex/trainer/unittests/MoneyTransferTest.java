package practicum.yandex.trainer.unittests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MoneyTransferTest {
	private final MoneyTransferService moneyTransferService = new MoneyTransferService();

	@Test
	void shouldMakeTransfer() {
		Account accountOne = new Account("1", 10);
		Account accountTwo = new Account("2", 10);

		assertEquals(0, moneyTransferService.transfer(7, accountOne, accountTwo),
				"Успешная транзакция должна возвращать результат 0");
		assertEquals(3, accountOne.balance);
		assertEquals(17, accountTwo.balance);
	}

	@Test
	void shouldNotTransferMoneyOnSameAccount() {
		Account accountOne = new Account("1", 10);
		assertEquals(-2, moneyTransferService.transfer(5, accountOne, accountOne),
				"Нельзя перевести деньги на тот же аккаунт. Id: 1");
	}

	@Test
	public void shouldNotTransferZero() {

		Account accountOne = new Account("1", 10);
		Account accountTwo = new Account("2", 10);

		assertEquals(-1, moneyTransferService.transfer(0, accountOne, accountTwo),
				"Сумма перевода должна быть больше 0. Текущая сумма: 0");
	}

	@Test
	public void shouldNotMakeBalanceLessThanZero() {

		Account accountOne = new Account("1", 10);
		Account accountTwo = new Account("2", 10);
		assertEquals(-3, moneyTransferService.transfer(15, accountOne, accountTwo),
				"Недостаточно средств на счёте с id 1. Перевод суммы 15 невозможен.");
	}

	@Test
	public void shouldNotMakeOverflowOnTransfer() {

		Account accountOne = new Account("1", 10);
		Account accountTwo = new Account("2", Integer.MAX_VALUE);

		assertEquals(-4, moneyTransferService.transfer(1, accountOne, accountTwo),
				"Перевод невозможен. Если транзакция выполнится, счёт с id 2 будет переполнен.");
	}
	
}

class MoneyTransferService {

	public int transfer(int amount, Account accountOne, Account accountTwo) {
		// переводить деньги можно только на другой счёт
		if (accountOne.id.equals(accountTwo.id)) {
			System.out.println("Нельзя перевести деньги на тот же аккаунт. Id: " + accountOne.id);
			return -2;
		}
		// сумма перевода должна быть больше 0
		if (amount <= 0) {
			System.out.println("Сумма перевода должна быть больше 0. Текущая сумма: " + amount);
			return -1;
		}

		// баланс не может стать отрицательным
		if (amount > accountOne.balance) {
			System.out.println("Недостаточно средств на счёте с id " + accountOne.id + ". Перевод суммы " + amount
					+ " невозможен.");
			return -3;
		}

		// перевод не должен приводить к переполнению баланса
		if (accountTwo.balance + amount < 0) {
			System.out.println(
					"Перевод невозможен. Если транзакция выполнится, счёт с " + accountTwo.id + " будет переполнен.");
			return -4;
		}

		accountOne.balance -= amount;
		accountTwo.balance += amount;
		return 0;
	}
}

class Account {
	public String id;
	public int balance;

	public Account(String id, int balance) {
		this.id = id;
		this.balance = balance;
	}
}
