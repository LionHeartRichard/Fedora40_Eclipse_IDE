package solutionslinkedlist.repeat1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import solutionslinkedlist.ListNode;

public class RepeatSolutionRotateList {

	public ListNode rotateRight(ListNode head, int k) {

		// Обрабатываем крайний случай
		if (head == null || head.next == null || k == 0)
			return head;

		// Считаем длину списка и получаем крайний элемент
		int len = 1;
		ListNode last = head;
		while (last.next != null) {
			last = last.next;
			++len;
		}

		// получаем бесконечно зациленный элемент начинающийся с последнего
		last.next = head;

		// считаем количество ротаций - К
		k = k % len;
		k = len - k;

		// смещаемся на К - ротаций
		while (k-- > 0) {
			last = last.next;
		}

		head = last.next;
		// разрываем бесконечность
		last.next = null;

		return head;
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

		ListNode node2 = new ListNode(2);
		ListNode node1 = new ListNode(1, node2);
		ListNode head = new ListNode(0, node1);
		int k = 4;

		int[] expected = { 2, 0, 1 };
		ListNode actual = rotateRight(head, k);

		int i = 0;
		while (actual != null) {
			assertEquals(expected[i++], actual.val);
			actual = actual.next;
		}
		assertTrue(i == expected.length);
	}

}