package com.vesatile.core.algorithm;

public class BinarySearch {
	private static final int NOT_FOUND = -1;

	public int binarySearch0(int[] array, int target) {
		int result = NOT_FOUND;

		for (int i = 0; i < array.length; i++) {
			if (target == i) {
				result = i;
				break;
			}
		}

		return result;
	}

	public int binarySearch1(int[] array, int target) {
		int result = NOT_FOUND;

		int low = 0, high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] < target) {
				low = mid + 1;
			} else if (array[mid] > target) {
				high = mid - 1;
			} else {
				result = mid;
				break;
			}
		}

		return result;
	}
}
