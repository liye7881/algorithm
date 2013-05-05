package com.vesatile.core.algorithm;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class MyArrayList<T> implements Iterable<T> {

	@SuppressWarnings("hiding")
	private class ArrayListIterator<T> implements Iterator<T> {
		private int current;

		@Override
		public boolean hasNext() {
			return current < size;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return (T) items[current++];
		}

		@Override
		public void remove() {
			MyArrayList.this.remove(current--);
		}

	}

	private static final int DEFAULT_CAPACITY = 10;

	private int size;

	private T[] items;

	public MyArrayList() {
		size = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	public void add(int idx, T t) {
		if (items.length == size) {
			ensureCapacity(size * 2 + 1);
		}
		for (int i = size; i > idx; i--) {
			items[i] = items[i - 1];
		}
		items[idx] = t;
		size++;
	}

	public void add(T t) {
		add(size, t);
	}

	public void ensureCapacity(int newCapacity) {
		if (newCapacity < size) {
			return;
		}

		T[] old = items;
		items = (T[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			items[i] = old[i];
		}
	}

	public T get(int idx) {
		if (idx < 0 || idx > size) {
			throw new ArrayIndexOutOfBoundsException(idx);
		} else {
			return items[idx];
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		return Arrays.toString(items);
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator<T>();
	}

	public T remove(int idx) {
		T t = items[idx];
		for (int i = idx; i < size - 1; i++) {
			items[i] = items[i + 1];
		}
		size--;
		return t;
	}

	public T set(int idx, T t) {
		if (idx < 0 || idx > size) {
			throw new ArrayIndexOutOfBoundsException(idx);
		} else {
			T old = items[idx];
			items[idx] = t;
			return old;
		}

	}

	public int size() {
		return size;
	}

	public void trimToSize() {
		ensureCapacity(size);
	}

}
