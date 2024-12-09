package topalgorithm.roadmap.newlinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static topalgorithm.roadmap.newlinkedlist.AlgorithmsLinkedList.*;

public class TestAlgorithmsLinkedList {

	@Test
	public void getHeadWhenValidDataThenReturnHead() {
		int[] expected = { -2, 5, 7, 10, 12 };

		ListNode head = getHead(expected);
		int[] actual = new int[expected.length];
		int idx = 0;
		while (head != null) {
			actual[idx++] = head.val;
			head = head.next;
		}

		assertArrayEquals(expected, actual);
	}

	@Test
	public void removeKElementFormEndListWhenValidData() {
		int[] nums = { -2, 5, 7, 10, 12 };
		ListNode head = getHead(nums);
		head = removeKElementFormEndList(head, 3);

		int[] expected = { -2, 5, 10, 12 };
		int[] actual = new int[expected.length];
		int idx = 0;
		while (head != null) {
			actual[idx++] = head.val;
			head = head.next;
		}

		assertArrayEquals(expected, actual);
	}
}
