package solutionslinkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Solution {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode keepHead = head;
		ListNode current = null;
		ListNode previous = null;
		ListNode leftNode = null;

		while (keepHead != null) {
			current = keepHead;
			while (current != null && current.val != right) {
				if (current.val == left)
					leftNode = current;
				current = current.next;
			}
			if (current == null) {
				previous.next = keepHead;
				return head;
			}

			ListNode next = current.next;
			current.next = null;
			reversToInterval(leftNode, right);
			if (keepHead == head) {
				head = current;
			} else {
				previous.next = current;
			}
			previous = keepHead;
			keepHead = next;
		}

		return head;
	}

	public ListNode reversToInterval(ListNode leftNode, int right) {
		ListNode previous = leftNode;
		ListNode current = leftNode;
		ListNode next = leftNode;
		while (current != null && current.val != right) {
			next = next.next;

			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	public ListNode reversListNode(ListNode head) {
		ListNode previous = null;
		ListNode current = head;
		ListNode next = head;

		while (current != null) {
			next = next.next;

			current.next = previous;
			previous = current;
			current = next;
		}

		return previous;
	}

	@Test
	public void case1() {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
		int left = 2;
		int right = 4;

		int[] expected = { 1, 4, 3, 2, 5 };
		ListNode actual = reverseBetween(head, left, right);

		int i = 0;
//		while (actual != null) {
//			assertEquals(expected[i++], actual.val);
//			actual = actual.next;
//		}

	}

	@Test
	public void case2() {
		ListNode node4 = new ListNode(4);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
		int left = 1;
		int right = 4;

		int[] expected = { 4, 3, 2, 1 };
		ListNode actual = reverseBetween(head, left, right);

//		int i = 0;
//		while (actual != null) {
//			assertEquals(expected[i++], actual.val);
//			actual = actual.next;
//		}

		while (actual != null) {
			System.out.println(actual.val);
			actual = actual.next;
		}
	}

	@Test
	public void case3() {
		ListNode node10 = new ListNode(10);
		ListNode node9 = new ListNode(9, node10);
		ListNode node8 = new ListNode(8, node9);
		ListNode node7 = new ListNode(7, node8);
		ListNode node6 = new ListNode(6, node7);
		ListNode node5 = new ListNode(5, node6);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
		int left = 3;
		int right = 7;

		ListNode actual = reverseBetween(head, left, right);
		int[] expected = { 1, 2, 7, 6, 5, 4, 3, 8, 9, 10 };

//		int i = 0;
//		while (actual != null) {
//			assertEquals(expected[i++], actual.val);
//			actual = actual.next;
//		}

	}

	@Test
	public void reversTes() {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);

		int[] expected = { 5, 4, 3, 2, 1 };
		ListNode actual = reversListNode(head);

		int i = 0;
		while (actual != null) {
			assertEquals(expected[i++], actual.val);
			actual = actual.next;
		}
		assertTrue(i == expected.length);
	}
}
