package com.vesatile.core.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class SubSumTest extends AbstractRecordTimeTestCase {
	private SubSum subSum = new SubSum();

	private int[] target = new int[] { 4, -3, 5, -2, -1, 2, 6, -2 };

	public void testSubSum0() {
		Assert.assertEquals(11,
				execute(subSum, "subSum0", new Object[] { target }, true));
	}

	@Test
	public void testSubSum1() {
		Assert.assertEquals(11,
				execute(subSum, "subSum1", new Object[] { target }, true));
	}

	@Test
	public void testSubSum2() {
		Assert.assertEquals(11,
				execute(subSum, "subSum2", new Object[] { target }, true));
	}

	@Test
	public void testSubSum3() {
		Assert.assertEquals(11,
				execute(subSum, "subSum3", new Object[] { target }, true));
	}
}
