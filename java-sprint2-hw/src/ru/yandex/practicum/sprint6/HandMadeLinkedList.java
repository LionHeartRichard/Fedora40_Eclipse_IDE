package ru.yandex.practicum.sprint6;

import java.util.NoSuchElementException;

public class HandMadeLinkedList<T> {

	class Node<E> {
		public E data;
		public Node<E> next;
		public Node<E> prev;

		public Node(Node<E> prev, E data, Node<E> next) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}

	private Node<T> head;

	private Node<T> tail;

	private int size = 0;

	public void addFirst(T element) {
		final Node<T> oldHead = head;
		final Node<T> newNode = new Node<>(null, element, oldHead);
		head = newNode;
		if (oldHead == null)
			tail = newNode;
		else
			oldHead.prev = newNode;
		++size;
	}

	public void addLast(T element) {
		final Node<T> oldTail = tail;
		final Node<T> newNode = new Node<>(null, element, oldTail);
		tail = newNode;
		if (head == null)
			head = newNode;
		else
			oldTail.next = newNode;
		++size;
	}

	public T getFirst() {
		final Node<T> curHead = head;
		if (curHead == null)
			throw new NoSuchElementException();
		return head.data;
	}

	public T getLast() {
		final Node<T> currentTail = tail;
		if (currentTail == null)
			throw new NoSuchElementException();
		return tail.data;
	}

	public int size() {
		return this.size;
	}

	public static void main(String[] args) {
		HandMadeLinkedList<Integer> integers = new HandMadeLinkedList<>();

		integers.addFirst(1);
		integers.addFirst(2);
		integers.addFirst(3);
		integers.addLast(4);
		integers.addLast(5);
		integers.addFirst(1);

		System.out.println(integers.getFirst());
		System.out.println(integers.size());
		System.out.println(integers.getLast());
		System.out.println(integers.size());
	}
}
