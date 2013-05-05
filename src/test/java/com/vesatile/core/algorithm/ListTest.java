package com.vesatile.core.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ListTest extends AbstractRecordTimeTestCase {

	protected void make(List<Integer> list, int n) {
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
	}

	@Test
	public void test() {
		execute(this, "make", new Object[] { new ArrayList<Integer>(), 10000 });
		execute(this, "make", new Object[] { new LinkedList<Integer>(), 10000 });
	}
}
