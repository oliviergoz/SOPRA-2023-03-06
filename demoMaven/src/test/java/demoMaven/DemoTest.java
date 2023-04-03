package demoMaven;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DemoTest {

	@BeforeEach
	void beforeEach() {
		System.out.println("execution avant chaque test");
	}

	@AfterEach
	void afterEach() {
		System.out.println("apres chaque test");
	}

	@BeforeAll
	static void beforeAll() {
		System.out.println("1 fois avant le premier test");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("1 fois apres le dernier test");
	}

	@Test
	// @Disabled
	void test() {
		Calculatrice calculatrice = new Calculatrice();
		assertEquals(4, calculatrice.addition(2, 2));
		assertEquals(-2, calculatrice.soustraction(2, 4));
	}

	@Test
	@Disabled
	void test2() {
		assertFalse(10 > 20);
		assertTrue(20 > 10);
	}

	@Test
	@Disabled
	void assertAllTest() {
		Calculatrice calculatrice = new Calculatrice();
		assertAll("assertAll", () -> assertEquals(4, calculatrice.addition(2, 2)),
				() -> assertEquals(-2, calculatrice.soustraction(2, 4)));
	}

	@Test
	void arithmeticExceptionTest() {
		Calculatrice calculatrice = new Calculatrice();
		assertThrows(ArithmeticException.class, () -> calculatrice.division(3, 0));
	}

	@Test
	void devTest() {
		Calculatrice calculatrice = new Calculatrice();
		assumeTrue(calculatrice.getProfil().equals("dev"));
		assertEquals("dev", calculatrice.getProfil());

	}

	@Test
	void prodTest() {
		Calculatrice calculatrice = new Calculatrice();
		assumeTrue(calculatrice.getProfil().equals("prod"));
		assertEquals("prod", calculatrice.getProfil());
	}
}
