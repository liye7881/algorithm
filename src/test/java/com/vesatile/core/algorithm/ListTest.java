package com.vesatile.core.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class ListTest extends AbstractRecordTimeTestCase {
	private class Make0 implements InvokeInternal {
		private List<Long> list;
		private Long count;

		public Make0(List<Long> list, Long count) {
			this.list = list;
			this.count = count;
		}

		@Override
		public Object execute() {
			make0(list, count);
			return null;
		}
	}

	private class Make1 implements InvokeInternal {
		private List<Long> list;
		private Long count;

		public Make1(List<Long> list, Long count) {
			this.list = list;
			this.count = count;
		}

		@Override
		public Object execute() {
			make1(list, count);
			return null;
		}
	}

	private class Remove0 implements InvokeInternal {
		private List<Long> list;

		public Remove0(List<Long> list) {
			this.list = list;
		}

		@Override
		public Object execute() {
			remove0(list);
			return null;
		}
	}

	private class Remove1 implements InvokeInternal {
		private List<Long> list;

		public Remove1(List<Long> list) {
			this.list = list;
		}

		@Override
		public Object execute() {
			remove1(list);
			return null;
		}
	}

	private class Sum0 implements InvokeInternal {
		private List<Long> list;

		public Sum0(List<Long> list) {
			this.list = list;
		}

		@Override
		public Object execute() {
			return sum(list);
		}
	}

	private static Logger logger = Logger.getLogger(ListTest.class);

	public void make0(List<Long> list, Long n) {
		list.clear();
		for (long i = 0; i < n; i++) {
			list.add(i);
		}
	}

	public void make1(List<Long> list, Long n) {
		list.clear();
		for (long i = 0; i < n; i++) {
			list.add(0, i);
		}
	}

	public void remove0(List<Long> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				list.remove(i);
			}
		}
	}

	public void remove1(List<Long> list) {
		Iterator<Long> iterator = list.iterator();
		while (iterator.hasNext()) {
			Long value = (Long) iterator.next();

			if (value % 2 == 0) {
				iterator.remove();
			}
		}
	}

	public long sum(List<Long> list) {
		long sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}

	@Test
	public void test() {
		final long count = 200000L;

		ArrayList<Long> arrayList = new ArrayList<Long>();
		LinkedList<Long> linkedList = new LinkedList<Long>();

		info("Make 0");
		execute(new Make0(arrayList, count));
		execute(new Make0(linkedList, count));

		info("Remove 0");
		execute(new Remove0(arrayList));
		execute(new Remove0(linkedList));

		info("Make 1");
		execute(new Make1(arrayList, count));
		execute(new Make1(linkedList, count));

		info("Sum 0");
		execute(new Sum0(arrayList));
		execute(new Sum0(linkedList));

		info("Remove 1");
		execute(new Remove1(arrayList));
		execute(new Remove1(linkedList));
	}

	private void info(String message) {
		if (logger.isInfoEnabled()) {
			logger.info(message);
		}
	}
}
