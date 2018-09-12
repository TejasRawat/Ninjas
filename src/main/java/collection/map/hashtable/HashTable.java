package collection.map.hashtable;

import java.util.*;

/**
 * This class is a LinkedList implementation of Hash table It implement Map<K,V>
 * , And provides all the operation
 * 
 * 
 * Hash table based implementation of the Map interface. This implementation
 * provides all of the optional map operations, and permits null values and the
 * null key. (The HashMap class is roughly equivalent to Hashtable, except that
 * it is unsynchronized and permits nulls.) This class makes no guarantees as to
 * the order of the map; in particular, it does not guarantee that the order
 * will remain constant over time.
 * 
 * This implementation provides constant-time
 * performance for the basic operations (get and put), assuming the hash
 * function disperses the elements properly among the buckets. Iteration over
 * collection views requires time proportional to the "capacity" of the HashMap
 * instance (the number of buckets) plus its size (the number of key-value
 * mappings). Thus, it's very important not to set the initial capacity too high
 * (or the load factor too low) if iteration performance is important. 
 * 
 * An instance of HashMap has two parameters that affect its performance: initial
 * capacity and load factor. The capacity is the number of buckets in the hash
 * table, and the initial capacity is simply the capacity at the time the hash
 * table is created. The load factor is a measure of how full the hash table is
 * allowed to get before its capacity is automatically increased. When the
 * number of entries in the hash table exceeds the product of the load factor
 * and the current capacity, the hash table is rehashed (that is, internal data
 * structures are rebuilt) so that the hash table has approximately twice the
 * number of buckets.
 * 
 * 
 * 
 * 
 * 
 * @author tejasrawat
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K, V> implements Map<K, V> {

	LinkedList<Node<K, V>>[] table = null;

	@SuppressWarnings("unchecked")
	public HashTable() {

		// Initializing Row Model
		table = new LinkedList[5];

		// Initializing Column Model
		for (int i = 0; i < table.length; i++) {
			table[i] = new LinkedList<Node<K, V>>();
		}
	}

	@Override
	public V put(K key, V value) {

		int hashVal = key.hashCode() % 5;

		table[hashVal].add(new Node<K, V>(key.hashCode(), key, value));

		return null;
	}

	@Override
	public int size() {

		int size = 0;

		for (int i = 0; i < table.length; i++) {
			size += table[i].size();
		}
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		// Initializing Row Model
		table = new LinkedList[5];

		// Initializing Column Model
		for (int i = 0; i < table.length; i++) {
			table[i] = new LinkedList<Node<K, V>>();
		}
	}

	@Override
	public V get(Object key) {

		int hash = key.hashCode() % 5;

		Node<K, V> node = null;
		V returnElement = null;

		LinkedList<Node<K, V>> list = table[hash];

		Iterator<Node<K, V>> itr = list.iterator();

		while (itr.hasNext()) {
			node = itr.next();

			if (node.hash == key.hashCode()) {
				returnElement = node.value;
				break;
			}
		}
		return returnElement;
	}

	@Override
	public boolean isEmpty() {

		if (size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean containsKey(Object key) {

		boolean flag = false;

		int hash = key.hashCode() % 5;

		Node<K, V> node = null;

		LinkedList<Node<K, V>> list = table[hash];

		Iterator<Node<K, V>> itr = list.iterator();

		while (itr.hasNext()) {
			node = itr.next();

			if (node.hash == key.hashCode()) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public boolean containsValue(Object value) {

		boolean flag = false;

		for (int i = 0; i < table.length; i++) {

			LinkedList<Node<K, V>> list = table[i];
			flag = isPresent(list, value);

			if (flag) {
				break;
			}

		}

		return flag;
	}

	private boolean isPresent(LinkedList<Node<K, V>> list, Object value) {

		Iterator<Node<K, V>> itr = list.iterator();

		while (itr.hasNext()) {
			Node<K, V> node = itr.next();

			if (node.value == value) {
				return true;
			}
		}

		return false;
	}

	@Override
	public V remove(Object key) {

		int hash = key.hashCode() % 5;

		Node<K, V> node = null;

		LinkedList<Node<K, V>> list = table[hash];

		Iterator<Node<K, V>> itr = list.iterator();

		while (itr.hasNext()) {
			node = itr.next();

			if (node.hash == key.hashCode()) {
				list.remove(itr.next());
				break;
			}
		}
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {

		Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();

		for (int i = 0; i < table.length; i++) {

			List<Node<K, V>> list = table[i];

			set.addAll(list);
		}

		return set;
	}

	@Override
	public Set<K> keySet() {

		return null;
	}

	@Override
	public Collection<V> values() {

		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {

	}

}
