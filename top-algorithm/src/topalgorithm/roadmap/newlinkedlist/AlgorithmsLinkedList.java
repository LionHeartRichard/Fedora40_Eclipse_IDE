package topalgorithm.roadmap.newlinkedlist;

public class AlgorithmsLinkedList {
	/*
	 * Удалить k-элемент с конца связного списка
	 */

	public static ListNode removeKElementFormEndList(ListNode head, int k) {
		ListNode dummyNode = new ListNode(0, head);// фейковая голова, для удаления головы...
		int length = 0;
		ListNode node = dummyNode;
		while (node != null) {
			++length;
			node = node.next;
		}
		node = dummyNode;
		int range = length - k;
		for (int i = 1; i < range; ++i) {
			node = node.next;
		}

		// delete NODE!!!
		node.next = node.next.next;
		return dummyNode.next;
	}

	public static ListNode getHead(int[] nums) {
		if (nums == null) {
			return null;
		}
		ListNode head = new ListNode();
		ListNode node = new ListNode(nums[0], null);
		head.next = node;
		for (int i = 1; i < nums.length; ++i) {
			ListNode next = new ListNode(nums[i]);
			node.next = next;
			node = next;
		}
		return head.next;
	}
}
