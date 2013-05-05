package com.vesatile.core.algorithm;

public class Power {
	public long power0(long target, long power) {
		long result = 1;
		for (int i = 1; i <= power; i++) {
			result *= power;
		}

		return result;
	}

	public long power1(long target, long power) {
		long result = 1;
		if (power == 0) {
			result = 1;
		} else if (power == 1) {
			result = target;
		} else if (power % 2 == 0) {
			result = power1(target * target, power / 2);
		} else {
			result = power1(target * target, power / 2) * target;
		}

		return result;
	}
}
