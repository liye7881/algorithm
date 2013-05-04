package com.vesatile.core.algorithm;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {
	private static Logger logger = Logger.getLogger(FibonacciTest.class);

	private long currentTime() {
		return System.currentTimeMillis();
	}

	private void execute(Fibonacci fibonacci, int input, boolean opt) {
		long start = currentTime();
		if (opt) {
			fibonacci.fibonacciOpt(input);
		} else {
			fibonacci.fibonacci(input);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Opt is " + opt+ " cost " + (currentTime() - start));
		}
	}

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

	@Test
	public void testFactorialOpt() {
		Fibonacci fibonacci = new Fibonacci();
		Assert.assertEquals(1, fibonacci.fibonacciOpt(0));
		Assert.assertEquals(1, fibonacci.fibonacciOpt(1));
		Assert.assertEquals(2, fibonacci.fibonacciOpt(2));
		Assert.assertEquals(3, fibonacci.fibonacciOpt(3));
		Assert.assertEquals(5, fibonacci.fibonacciOpt(4));
		try {
			fibonacci.fibonacciOpt(-1);
			Assert.assertTrue(false);
		} catch (ArithmeticException e) {
			Assert.assertEquals("Nagitive value is not support", e.getMessage());
		}
	}

	@Test
	public void testPerf() {
		Fibonacci fibonacci = new Fibonacci();

		execute(fibonacci, 30, false);
		execute(fibonacci, 30, true);
	}

}
