package com.vesatile.core.algorithm;

import org.junit.Test;

public class PowerTest extends AbstractRecordTimeTestCase {
	private Power power = new Power();

	@Test
	public void testPower0() {
		execute(power, "power0", new Object[] { 2L, 300000000L });
	}

	@Test
	public void testPower1() {
		execute(power, "power1", new Object[] { 2L, 300000000L });
	}
}
