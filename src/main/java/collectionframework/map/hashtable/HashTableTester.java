package collectionframework.map.hashtable;

import java.util.Iterator;
import java.util.Map.Entry;

public class HashTableTester {
	public static void main(String args[]) {

		HashTable<Integer, String> map = new HashTable<Integer, String>();

		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(5, "e");
		map.put(6, "f");

		/*System.out.println("map.size()" + map.size());

		System.out.println("map.get(1)" + map.get(1));

		System.out.println(map.containsKey(1));

		System.out.println(map.containsValue("ab"));

		map.remove(1);

		System.out.println(map.size());*/

		Iterator<Entry<Integer, String>> itr = map.entrySet().iterator();

		while (itr.hasNext()) {

			Entry<Integer, String> entry = itr.next();
			System.out.println("entry.getKey() = " + entry.getKey() + ", " + "entry.getValue() =" + entry.getValue());

		}
	}
}
