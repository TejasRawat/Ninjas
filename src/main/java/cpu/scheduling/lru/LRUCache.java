package cpu.scheduling.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * tejasrawat
 */
public class LRUCache {

    private Map<Integer, Entry> cache;
    private int capacity;
    private Entry front , rear;

    public LRUCache(int capacity) {
        cache = new HashMap<Integer,Entry>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Entry entry = cache.get(key);
            reloadCache(key);
            return entry.getData();
        }else{
            return -1;
        }
    }

    /**
     * Swapping the recently used to front
     *
     * @param key
     */
    private void reloadCache(int key) {
        // Make the entry to front
        Entry entry = cache.get(key);

        if (cache.size() <= 1) {
            // Dont do anythung
        } else if (cache.size() == 2) {
            entry.setNext(front);
            front.setPrev(entry);
            entry.setPrev(null);
            front.setNext(null);
            rear = front;
            front = entry;
        } else {
            Entry temp = front;
            while (temp != null) {
                if (temp.getNext() == entry) {
                    if (entry.getNext() != null) {
                        temp.setNext(entry.getNext());
                        entry.getNext().setPrev(temp);
                        entry.setPrev(null);
                        entry.setNext(front);
                        front.setPrev(entry);
                        front = entry;
                    }
                }
                temp = temp.getNext();
            }

        }
    }

    public void put(int key, int value) {
        Entry entry = new Entry(key, value, null, null);
        if (cache.size() < capacity) {
            addAtFront(entry);
            cache.put(key, entry);
        } else {
            if (keyAlreadyPresent(key)) {
                Entry data = cache.get(key);
                data.setData(value);
                reloadCache(key);
            } else {
                removeAtLast();
                addAtFront(entry);
                cache.put(key, entry);
            }
        }
    }

    private boolean keyAlreadyPresent(int key) {
        return cache.containsKey(key);
    }

    private void removeAtLast() {
        if (cache.size() == 0) {
            return;
        }
        if (cache.size() == 1) {
            cache.remove(rear.getKey());
            front = null;
            rear = null;
        } else {
            Entry temp = front;
            while (temp.getNext() != rear) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            cache.remove(rear.getKey());
            rear = temp;
        }
    }

    private void addAtFront(Entry entry) {
        if (front == null && rear == null) {
            front = entry;
            rear = entry;
        } else {
            entry.setNext(front);
            front.setPrev(entry);
            front = entry;
        }
    }
}

class Entry {
    private int key;
    private int data;
    private Entry next;
    private Entry prev;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    public Entry getPrev() {
        return prev;
    }

    public void setPrev(Entry prev) {
        this.prev = prev;
    }

    public Entry(int key, int data) {
        this.key = key;
        this.data = data;
    }

    public Entry(int key, int data, Entry next, Entry prev) {
        this.key = key;
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", data=" + data +
                '}';
    }
}
