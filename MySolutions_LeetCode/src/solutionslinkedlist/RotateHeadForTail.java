package solutionslinkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class RotateHeadForTail {

	public ListNode rotateHeadForTail(ListNode head) {
		return null;
	}

	@Test
	public void case1() {

		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);

		int[] expected = { 5, 2, 3, 4, 1 };
		ListNode actual = rotateHeadForTail(head);

		int i = 0;
		while (actual != null) {
			assertEquals(expected[i++], actual.val);
			actual = actual.next;
		}
		assertTrue(i == expected.length);
	}

	@Test
	public void case2() {

		ListNode node2 = new ListNode(2);
		ListNode node1 = new ListNode(1, node2);
		ListNode head = new ListNode(0, node1);

		int[] expected = { 2, 1, 0 };
		ListNode actual = rotateHeadForTail(head);

		int i = 0;
		while (actual != null) {
			assertEquals(expected[i++], actual.val);
			actual = actual.next;
		}
		assertTrue(i == expected.length);
	}
}
