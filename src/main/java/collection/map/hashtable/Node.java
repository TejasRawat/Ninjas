package collection.map.hashtable;

import java.util.Map;

public class Node<K, V> implements Map.Entry<K, V> {

	int hash;
	K key;
	V value;

	public Node(int hash, K key, V value) {
		super();
		this.hash = hash;
		this.key = key;
		this.value = value;
	}

	public String toString() {
		return "Hash=" + hash + ", key=" + key + ", value=" + value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		this.value = value;
		return null;
	}

}
