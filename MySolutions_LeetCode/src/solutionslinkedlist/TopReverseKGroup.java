package solutionslinkedlist;

public class TopReverseKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1)
			return head;

		int count = 0;
		ListNode pivot = head;
		while (count++ < k) {
			head = head.next;
		}

		ListNode newHead = reverseListFromTailToHead(pivot, head);
		count = 0;
		ListNode swap = null;

		while (head != null && count++ < k) {
			head = head.next;
			if (count == k) {
				count = 0;
				swap = pivot.next;
				pivot.next = reverseListFromTailToHead(pivot.next, head);
				pivot = swap;
			}
		}
		return newHead;
	}

	// реверс от хвоста к голове
	private ListNode reverseListFromTailToHead(ListNode head, ListNode tail) {
		ListNode previous = tail;

		while (head != tail) {
			ListNode swap = head.next;

			head.next = previous;
			previous = head;
			head = swap;
		}
		return previous;
	}
}
