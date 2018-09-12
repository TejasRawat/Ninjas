package collection.list.linkedlist;

import java.util.*;


public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E> {

	private Node<E> front = null;
	private Node<E> rear = null;
	private int size = 0;

	@Override
	public boolean add(E e) {

		addFirst(e);

		return true;
	}

	@Override
	public void addFirst(E e) {

		Node<E> temp = new Node<E>();

		if (front == null && rear == null) {
			temp.data = e;
			temp.next = null;
			temp.prev = null;

			front = temp;
			rear = temp;
		}

		else {
			temp.data = e;
			temp.next = front;
			front.prev = temp;
			temp.prev = null;

			front = temp;
		}

		size++;
	}

	@Override
	public void addLast(E e) {

		Node<E> temp = new Node<E>();

		if (front == null && rear == null) {
			temp.data = e;
			temp.next = null;
			temp.prev = null;

			front = temp;
			rear = temp;
		}

		else {
			temp.data = e;
			temp.next = null;
			temp.prev = rear;
			rear.next = temp;

			rear = temp;
		}
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		front = null;
		rear = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public E remove() {

		if (rear == null) {
			System.err.println("List is Empty");
		} else if (front == rear) {
			front = null;
			rear = null;
		} else {
			rear = rear.prev;
		}
		return null;
	}

	@Override
	public Iterator<E> iterator() {

		Iterator<E> iter = new LinkedListIterator<E>(front);

		return iter;
	}

	@Override
	public E peek() {
		return rear.data;
	}

	@Override
	public E getFirst() {
		return front.data;
	}

	@Override
	public E getLast() {
		return rear.data;
	}

	@Override
	public E peekFirst() {
		return front.data;
	}

	@Override
	public E peekLast() {
		return rear.data;
	}

	@Override
	public E poll() {

		if (front == null && rear == null) {
			throw new ArrayIndexOutOfBoundsException();
		}

		else {
			Node<E> temp = front;

			front = front.next;

			return temp.data;
		}
	}

	@Override
	public boolean removeAll(Collection<?> c) {

		front = null;
		rear = null;

		return true;
	}

	@Override
	public boolean offer(E e) {

		addLast(e);

		return true;
	}

	@Override
	public boolean offerFirst(E e) {

		addFirst(e);

		return true;
	}

	@Override
	public boolean offerLast(E e) {

		addLast(e);

		return true;
	}

	@Override
	public E element() {
		return front.data;
	}

	@Override
	public void add(int index, E element) {

		int i = 0;

		if (index > size) {
			throw new IndexOutOfBoundsException("" + index + ", Current List Size-" + size);
		} else if (index == 0) {
			Node<E> temp = new Node<E>();
			temp.data = element;
			temp.prev = null;
			temp.next = front;
			front.prev = temp;
			front = temp;

			size++;
		} else if (index == size) {
			Node<E> temp = new Node<E>();
			temp.data = element;
			temp.prev = rear;
			temp.next = null;
			rear.next = temp;
			rear = temp;

			size++;
		} else {
			Node<E> temp = front;
			while (temp != null) {

				if (i == index - 1) {
					Node<E> tempNode = new Node<E>();

					tempNode.data = element;
					tempNode.next = temp.next;
					tempNode.prev = temp;
					temp.next.prev = tempNode;
					temp.next = tempNode;

					size++;

					break;
				} else {
					temp = temp.next;
					i++;
				}
			}
		}

	}

	@Override
	public E remove(int index) {

		if (index > size) {
			throw new IndexOutOfBoundsException("" + index + "" + size);
		}

		else if (index == 0) {
			if (front == null) {
				throw new NullPointerException("list" + front);
			} else if (front == rear) {
				front = null;
				rear = null;
				size--;
			} else {
				front = front.next;
				front.prev = null;
				size--;
			}
		}

		else if (index == (size - 1)) {

			if (rear == null) {
				throw new NullPointerException("Rear" + rear);
			} else if (front == rear) {
				front = null;
				rear = null;
				size--;
			} else {
				rear = rear.prev;
				rear.next = null;
				size--;
			}
		}

		else {
			int i = 0;
			Node<E> temp = front;

			while (temp != null) {
				if (i == index - 1) {
					temp.next = temp.next.next;
					temp.next.next.prev = temp;

					size--;
					break;
				} else {
					temp = temp.next;
					i++;
				}
			}
		}

		return null;
	}

	@Override
	public boolean remove(Object o) {

		Node<E> temp = front;

		while (temp != null) {

			if (o == temp.data) {

				if (temp == front) {

					front = front.next;
					front.prev = null;

					size--;
					break;
				}

				else if (temp == rear) {

					rear = rear.prev;
					rear.next = null;

					size--;
					break;
				}

				else {

					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
					temp = null;

					size--;
					break;
				}
			}

			else {
				temp = temp.next;
			}

		}
		return false;

	}

	@Override
	public E get(int index) {

		if (size == 0) {
			throw new IndexOutOfBoundsException("" + index);
		}

		return null;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean removeFirstOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void push(E e) {
		// TODO Auto-generated method stub

	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	



}