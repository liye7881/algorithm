package com.vesatile.core.algorithm;

public class Fibonacci {
	public int fibonacci(int i) {
		int result = 0;
		if (i == 0) {
			result = 1;
		} else if (i == 1) {
			result = 1;
		} else if (i > 1) {
			return fibonacci(i - 1) + fibonacci(i - 2);
		} else {
			throw new ArithmeticException("Nagitive value is not support");
		}

		return result;
	}
}
