package collectionframework.list.arraylist;

import java.util.Iterator;

public class ArrayListIterator<E> implements Iterator<E>{

	private E e[] = null;
	private int top = 0;
	private int ptr = 0;


	public ArrayListIterator(E[] e, int top) {
		
		this.e 	 = e;
		this.top = top;
	
	}

	@Override
	public boolean hasNext() {

		boolean flag = false;
		
		if(ptr < top){
			flag = true;
		}
		
		return flag;
	}

	@Override
	public E next() {

		return e[ptr++];
	}

	@Override
	public void remove() {

		
		
	}

}