package practicum.yandex.trainer.sprint5lasttest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PracticumTest {

	@BeforeAll
	static void beforeAll() {
		System.out.println("@BeforeAll");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("@AfterAll");
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("@BeforeEach");
	}

	@AfterEach
	void afterEach() {
		System.out.println("@AfterEach");
	}

	@Test
	public void someTestOne() {
		System.out.println("Test 1");
	}

	@Test
	public void someTestTwo() {
		System.out.println("Test 2");
	}
}