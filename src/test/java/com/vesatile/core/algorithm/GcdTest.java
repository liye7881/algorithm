package com.vesatile.core.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class GcdTest extends AbstractRecordTimeTestCase {
	private Gcd gcd = new Gcd();

	@Test
	public void test() {
		Assert.assertEquals(Long.valueOf(3),
				execute(gcd, "gcd", new Object[] { 1989L, 1590L }));
	}

}
