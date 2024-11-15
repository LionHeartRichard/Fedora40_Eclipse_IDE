package topalgorithm.roadmap.hashtable.lru;

public class CacheElement<K, V> {

	K key;
	V value;

	public CacheElement(K key, V value) {
		this.key = key;
		this.value = value;
	}

}
