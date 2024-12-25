package solutionslinkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ReverseBetween {

	public ListNode reverseBetween(ListNode head, int leftIdx, int rightIdx) {

		if (head == null || leftIdx == rightIdx) {
			return head;
		}

		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode previous = dummy;

		for (int i = 1; i < leftIdx; ++i) {
			previous = previous.next;
		}

		ListNode leftNode = previous.next;

		for (int i = 0; i < rightIdx - leftIdx; ++i) {
			ListNode swap = leftNode.next;

			leftNode.next = swap.next;
			swap.next = previous.next;
			previous.next = swap;
		}

		return dummy.next;
	}

	public ListNode reversListNode(ListNode head) {
		ListNode previous = null;

		while (head != null) {
			ListNode swap = head.next;

			head.next = previous;
			previous = head;
			head = swap;
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

		// [1,4,3,2,5]
		int[] expected = { 1, 4, 3, 2, 5 };
		ListNode actual = reverseBetween(head, left, right);

		int i = 0;
		while (actual != null) {
			assertEquals(expected[i++], actual.val);
			actual = actual.next;
		}
		assertTrue(i == expected.length);

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

		int i = 0;
		while (actual != null) {
			assertEquals(expected[i++], actual.val);
			actual = actual.next;
		}
		assertTrue(i == expected.length);
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

		int i = 0;
		while (actual != null) {
			assertEquals(expected[i++], actual.val);
			actual = actual.next;
		}
		assertTrue(i == expected.length);

	}

	@Test
	public void reversTest() {
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
