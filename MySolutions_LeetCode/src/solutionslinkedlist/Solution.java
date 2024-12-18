package solutionslinkedlist;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Solution {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		List<Integer> swap = new ArrayList<>();
		while (head != null) {
			swap.add(head.val);
			head = head.next;
		}

		int len = swap.size();
		if (len == 2 && left != right) {
			ListNode next = new ListNode(swap.get(0));
			head = new ListNode(swap.get(1), next);
			return head;
		}

		int tmp = swap.get(len - 1) == right ? left : swap.get(len - 1);
		head = new ListNode(tmp);
		for (int i = len - 2; i >= 0; --i) {
			int val = swap.get(i);
			if (val == left) {
				head = new ListNode(right, head);
			} else if (val == right) {
				head = new ListNode(left, head);
			} else {
				head = new ListNode(val, head);
			}
		}
		return head;
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
		while (actual != null) {
			assertEquals(expected[i++], actual.val);
			actual = actual.next;
		}
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
	}
}
