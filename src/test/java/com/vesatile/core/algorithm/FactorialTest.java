package com.vesatile.core.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class FactorialTest {

	@Test
	public void testFactorial() {
		Factorial factorial = new Factorial();
		Assert.assertEquals(1, factorial.factorial(1));
		Assert.assertEquals(2, factorial.factorial(2));
		Assert.assertEquals(6, factorial.factorial(3));
		Assert.assertEquals(24, factorial.factorial(4));

		try {
			factorial.factorial(-1);
			Assert.assertTrue(false);
		} catch (ArithmeticException e) {
			Assert.assertTrue(true);
		}
	}

}
