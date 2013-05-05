package com.vesatile.core.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest extends AbstractRecordTimeTestCase {
	private BinarySearch binarySearch = new BinarySearch();

	private int[] target;

	@Before
	public void setup() {
		int length = 10;
		target = new int[length];
		for (int i = 0; i < length; i++) {
			target[i] = i;
		}
	}

	@Test
	public void test() {
		int target = 1;
		Assert.assertEquals(
				1,
				execute(binarySearch, "binarySearch0", new Object[] {
						this.target, target }));
		Assert.assertEquals(
				1,
				execute(binarySearch, "binarySearch1", new Object[] {
						this.target, target }));
	}

}
