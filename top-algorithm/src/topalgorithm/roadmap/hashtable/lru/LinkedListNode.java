package topalgorithm.roadmap.hashtable.lru;

public class LinkedListNode<T> {
	private LinkedListNode<T> dummyNode;
	private LinkedListNode<T> head;

	public LinkedListNode<T> updateAndMoveToFront(LinkedListNode<T> node, T newValue) {
		if (node.isEmpty() || (this != (node.getListReference()))) {
			return dummyNode;
		}
		detach(node);
		add(newValue);
		return head;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public LinkedListNode<T> getListReference() {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(T newValue) {
		// TODO Auto-generated method stub

	}

	public void detach(LinkedListNode<T> node) {
		// TODO Auto-generated method stub

	}
}
