package com.vesatile.core.algorithm;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
	private static class Node<T> {
		private T t;
		private Node<T> prev;
		private Node<T> next;

		public Node(T t, Node<T> prev, Node<T> next) {
			this.t = t;
			this.prev = prev;
			this.next = next;
		}
	}

	private Node<T> begin;
	private Node<T> end;
	private int size;
	private int modCount;

	public MyLinkedList() {
		clear();
	}

	public void add(int idx, T t) {
		addBefore(getNode(idx), t);
	}

	public void add(T t) {
		add(size, t);
	}

	private void addBefore(Node<T> p, T t) {
		Node<T> newNode = new Node<T>(t, p.prev, p);
		p.prev.next = p.prev = newNode;
		size++;
		modCount++;
	}

	public void clear() {
		begin = new Node<T>(null, null, null);
		end = new Node<T>(null, begin, null);
		begin.next = end;
		size = 0;
		modCount++;
	}

	public T get(int idx) {
		return getNode(idx).t;
	}

	private Node<T> getNode(int idx) {
		Node<T> p = null;
		if (idx < 0 || idx > size) {
			throw new IndexOutOfBoundsException();
		}
		if (idx < size() / 2) {
			p = begin.next;
			for (int i = 0; i < idx; i++) {
				p = p.next;
			}
		} else {
			p = end;
			for (int i = size; i > idx; i--) {
				p = p.prev;
			}
		}
		return p;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	public T remove(int idx) {
		return remove(getNode(idx));
	}

	public T remove(Node<T> t) {
		t.next.prev = t.prev;
		t.prev.next = t.next;
		size++;
		modCount++;

		return t.t;
	}

	public T set(int idx, T t) {
		Node<T> old = getNode(idx);
		T oldValue = old.t;
		old.t = t;
		return oldValue;
	}

	public int size() {
		return size;
	}

}
