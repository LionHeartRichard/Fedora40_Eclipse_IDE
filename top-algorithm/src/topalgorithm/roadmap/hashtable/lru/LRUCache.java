package topalgorithm.roadmap.hashtable.lru;

//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Optional;
//import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache<K, V>  {//implements Cache<K, V>
/*
	private int size;
	private final Map<K, LinkedListNode<CacheElement<K, V>>> linkedListNodeMap;
	private final DoublyLinkedList<CacheElement<K, V>> doublyLinkedList;
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public LRUCache(int size) {
		this.size = size;
		this.linkedListNodeMap = new ConcurrentHashMap<>(size);
		this.doublyLinkedList = new DoublyLinkedList<>();
	}

	public boolean put(K key, V value) {
		this.lock.writeLock().lock();
		try {
			CacheElement<K, V> item = new CacheElement<K, V>(key, value);
			LinkedListNode<CacheElement<K, V>> newNode;
			if (this.linkedListNodeMap.containsKey(key)) {
				LinkedListNode<CacheElement<K, V>> node = this.linkedListNodeMap.get(key);
				newNode = doublyLinkedList.updateAndMoveToFront(node, item);
			} else {
				if (this.size() >= this.size) {
					this.evictElement();
				}
				newNode = this.doublyLinkedList.add(item);
			}
			if (newNode.isEmpty()) {
				return false;
			}
			this.linkedListNodeMap.put(key, newNode);
			return true;
		} finally {
			this.lock.writeLock().unlock();
		}

	}

	public Optional<V> get(K key) {
		this.lock.readLock().lock();
		try {
			LinkedListNode<CacheElement<K, V>> linkedListNode = this.linkedListNodeMap.get(key);
			if (linkedListNode != null && !linkedListNode.isEmpty()) {
				linkedListNodeMap.put(key, this.doublyLinkedList.moveToFront(linkedListNode));
				return Optional.of(linkedListNode.getElement().getValue());
			}
			return Optional.empty();
		} finally {
			this.lock.readLock().unlock();
		}

	}

	private boolean evictElement() {
		this.lock.writeLock().lock();
		try {
			// ...
		} finally {
			this.lock.writeLock().unlock();
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}*/
}
