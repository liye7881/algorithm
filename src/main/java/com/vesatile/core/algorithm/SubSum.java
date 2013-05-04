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

	public int subSum1(int[] target) {
		int reuslt = 0;
		for (int i = 0; i < target.length; i++) {
			int temp = 0;
			for (int j = i; j < target.length; j++) {
				temp += target[j];

				if (temp > reuslt) {
					reuslt = temp;
				}
			}
		}
		return reuslt;
	}

	public int subSum2(int[] target) {
		return doSubSum2(target, 0, target.length - 1);
	}

	public int subSum3(int[] target) {
		int result = 0, thisSum = 0;
		for (int i = 0; i < target.length; i++) {
			thisSum += target[i];
			if (thisSum > result) {
				result = thisSum;
			} else if (thisSum < 0) {
				thisSum = 0;
			}
		}

		return result;
	}

	private int doSubSum2(int[] target, int left, int right) {
		if (left == right) {
			if (target[left] > 0) {
				return target[left];
			} else {
				return 0;
			}
		}

		int center = (left + right) / 2;

		int maxLeft = doSubSum2(target, left, center);
		int maxRight = doSubSum2(target, center + 1, right);

		int maxLeftBorderSum = 0, leftBorderSum = 0;
		for (int i = center; i >= left; i--) {
			leftBorderSum += target[i];
			if (leftBorderSum > maxLeftBorderSum) {
				maxLeftBorderSum = leftBorderSum;
			}
		}

		int maxRightBorderSum = 0, rightBorderSum = 0;
		for (int i = center + 1; i < right; i++) {
			rightBorderSum += target[i];
			if (rightBorderSum > maxRightBorderSum) {
				maxRightBorderSum = rightBorderSum;
			}
		}

		return Math.max(maxLeft,
				Math.max(maxRight, maxRightBorderSum + maxLeftBorderSum));

	}
}
