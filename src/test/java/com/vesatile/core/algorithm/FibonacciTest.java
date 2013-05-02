package com.vesatile.core.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

	@Test
	public void testFactorial() {
		Fibonacci fibonacci = new Fibonacci();
		Assert.assertEquals(1, fibonacci.fibonacci(0));
		Assert.assertEquals(1, fibonacci.fibonacci(1));
		Assert.assertEquals(2, fibonacci.fibonacci(2));
		Assert.assertEquals(3, fibonacci.fibonacci(3));
		Assert.assertEquals(5, fibonacci.fibonacci(4));

		try {
			fibonacci.fibonacci(-1);
			Assert.assertTrue(false);
		} catch (ArithmeticException e) {
			Assert.assertEquals("Nagitive value is not support", e.getMessage());
		}
	}

}
