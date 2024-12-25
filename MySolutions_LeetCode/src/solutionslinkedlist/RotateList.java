package solutionslinkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
//		ListNode dummy = new ListNode();
//		dummy.next = head;

		ListNode next = head;
		for (int i = 0; i < k; ++i) {
			next = next.next;
		}
		ListNode newHead = next.next;

		while (next.next != null) {
			next = next.next;
		}
		next.next = head;

		ListNode tail = newHead;
		while (tail.next != newHead) {
			tail = tail.next;
		}
		tail.next = null;

		return newHead;
	}

	@Test
	public void case1() {
		/*
		 * Input: head = [1,2,3,4,5], k = 2 Output: [4,5,1,2,3]
		 */

		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
		int k = 2;

		int[] expected = { 4, 5, 1, 2, 3 };
		ListNode actual = rotateRight(head, k);

		int i = 0;
		while (actual != null) {
			assertEquals(expected[i++], actual.val);
			actual = actual.next;
		}
		assertTrue(i == expected.length);
	}

	@Test
	public void case2() {
		/*
		 * Input: head = [0,1,2], k = 4 Output: [2,0,1]
		 */
		
		
	}
}