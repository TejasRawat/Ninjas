package collectionframework.list.arraylist;

import java.lang.reflect.Array;
import java.util.*;

public class ArrayList<E> extends AbstractList<E> implements List<E> {

	private E eArray[]		 = null;
	private E doubleArray[]  = null;
	private int top 		 = 0;
	private int capacity 	 = 1;
	private Class<E> classType = null;
	
	@SuppressWarnings("unchecked")
	public ArrayList(Class<E> classType) {
		eArray = (E[]) Array.newInstance(classType, capacity);
		this.classType = classType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E e) {

		if (top < capacity) {
			eArray[top++] = e;
			return true;
		}

		else {
			doubleArray = (E[]) Array.newInstance(classType, capacity * 2);
			updateArray();
			eArray[top++] = e;

			return true;
		}

	}

	private void updateArray() {

		for (int i = 0; i < eArray.length; i++) {
			doubleArray[i] = eArray[i];
		}
		eArray = doubleArray;
		capacity = capacity *2;

	}

	public E remove() {
		top--;
		return null;
	}

	@Override
	public Iterator<E> iterator() {

		ArrayListIterator<E> iter = new ArrayListIterator<E>(eArray, top);

		return iter;
	}

	@Override
	public void add(int index, E element) {

		if (index <= top) {

			eArray[index] = element;

			if (index == top) {
				top++;
			}
		}

		else {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	@Override
	public int size() {
		return top;
	}

	@Override
	public boolean isEmpty() {
		if (top == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public E get(int index) {
		if (index >= top) {
			throw new ArrayIndexOutOfBoundsException(index);
		} else {
			return eArray[index];
		}
	}

	@Override
	public E remove(int index) {

		if (index >= top) {
			throw new ArrayIndexOutOfBoundsException(index);
		}

		else {
			for (int i = index; i < top; i++) {
				eArray[i] = eArray[i + 1];
			}
			top--;
		}

		return null;
	}

	@Override
	public E set(int index, E element) {

		if (index >= top) {
			throw new ArrayIndexOutOfBoundsException(index);
		} else {
			eArray[index] = element;
		}
		return null;
	}

	@Override
	public void clear() {
		top = 0;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {

		if (fromIndex >= top) {
			throw new ArrayIndexOutOfBoundsException(fromIndex);
		}

		else if (toIndex >= top) {
			throw new ArrayIndexOutOfBoundsException(toIndex);
		}

		else {

			ArrayList<E> subList = new ArrayList<E>(classType);

			for (int i = fromIndex; i <= toIndex; i++) {
				subList.add(eArray[i]);
			}

			return subList;

		}

	}

	@Override
	public boolean removeAll(Collection<?> c) {

		top = 0;
		eArray = null;

		return false;
	}

	@Override
	public Object[] toArray() {
		return eArray;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
