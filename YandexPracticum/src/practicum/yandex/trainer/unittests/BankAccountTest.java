package practicum.yandex.trainer.unittests;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BankAccountTest {

	@Test
	public void shouldNotBeBlockedWhenCreated() {
		BankAccount account = new BankAccount("a", "b");
		assertFalse(account.isBlocked());
	}

	@Test
	public void shouldReturnZeroAmountAfterActivation() {
		BankAccount account = new BankAccount("a", "b");
		account.activate("RUB");
		assertEquals(Integer.valueOf(0), account.getAmount());
		assertEquals("RUB", account.getCurrency());
	}

	@Test
	public void shouldBeBlockedAfterBlockIsCalled() {
		BankAccount account = new BankAccount("a", "b");
		account.activate("RUB");
		account.block();
		assertTrue(account.isBlocked());
	}

	@Test
	public void shouldReturnFirstNameThenSecondName() {
		BankAccount account = new BankAccount("a", "b");
		account.activate("RUB");
		String[] actual = account.getFullName();
		String[] expexted = new String[] { "a", "b" };
		assertArrayEquals(expexted, actual);
	}

	@Test
	public void shouldReturnNullAmountWhenNotActive() {
		BankAccount account = new BankAccount("a", "b");
		assertNull(account.getCurrency());
	}
}
