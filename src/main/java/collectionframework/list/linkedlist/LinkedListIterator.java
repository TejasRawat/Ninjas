package collectionframework.list.linkedlist;

import java.util.Iterator;

public class LinkedListIterator<E> implements Iterator<E> {

	private Node<E> front;

	public LinkedListIterator(Node<E> front) {
		this.front = front;
		}

	@Override
	public boolean hasNext() {

		boolean iterFlag = false;

		if (front == null) {
			iterFlag = false;
		} else {
			iterFlag = true;
		}

		return iterFlag;
	}

	@Override
	public E next() {

		Node<E> temp = front;
		front = front.next;

		return temp.data;

	}

	@Override
	public void remove() {

	}

	public Node<E> getNode() {
		return front;
	}

	public void setNode(Node<E> front) {
		this.front = front;
	}

}