package com.vesatile.core.algorithm;

import java.util.HashMap;
import java.util.Map;

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

	public int fibonacciOpt(int input) {
		if (input < 0) {
			throw new ArithmeticException("Nagitive value is not support");
		}
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		resultMap.put(0, 1);
		resultMap.put(1, 1);
		for (int i = 2; i <= input; i++) {
			resultMap.put(i, resultMap.get(i - 1) + resultMap.get(i - 2));
		}

		return resultMap.get(input);
	}
}
