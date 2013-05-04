package com.vesatile.core.algorithm;

public class SubSum {
	public int subSum0(int[] target) {
		int reuslt = 0;
		for (int i = 0; i < target.length; i++) {
			for (int j = i; j < target.length; j++) {
				int temp = 0;
				for (int k = i; k < j; k++) {
					temp += target[k];
				}

				if (temp > reuslt) {
					reuslt = temp;
				}
			}
		}

		return reuslt;
	}
}
