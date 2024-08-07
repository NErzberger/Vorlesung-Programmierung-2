package wwibe123.aufgabe4;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList<E> extends AbstractList<E> implements List<E>{

	private static final int DEFAULT_CAPACITY = 10;
	
	private static final Object[] EMPTY_ELEMENTDATA = {};
	
	private Object[] dataElements;
	
	private int size;
	
	public MyArrayList() {
		this.dataElements = EMPTY_ELEMENTDATA;
		size=0;
	}
	
	public MyArrayList(int capacity) {
		if (capacity>0) {
			this.dataElements = new Object[capacity];
			size = capacity - 1;
		}else if(capacity == 0) {
			this.dataElements = EMPTY_ELEMENTDATA;
			size=0;
		}else {
			throw new IllegalArgumentException("Illegal capacity: " + capacity);
		}
	}
	
	public int size() {
		return this.size;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int position) {
		return (E) dataElements[position];
	}
	
	private Object[] grow(int minCapacity) {
		int oldCapacity = dataElements.length;
		if(oldCapacity > 0 || dataElements != EMPTY_ELEMENTDATA) {
			int preferdCapacity = oldCapacity + 1;
			int newCapacity = ArraysSupport.newLength(oldCapacity, 
									minCapacity-oldCapacity, 
									preferdCapacity);
			return dataElements = Arrays.copyOf(dataElements, newCapacity);
		}else {
			return dataElements = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
		}
	}
	
	private Object[] grow() {
		return grow(size + 1);
	}
	
	public boolean add(E element) {
		if(size == dataElements.length) {
			grow();
		}
		dataElements[size] = element;
		size++;
		return true;
	}
	
	public E remove(int index) {
		E e = (E) dataElements[index];
		fastRemove(dataElements, index);
		return e;
	}
	
	public boolean remove(Object o) {
		
		for(int i = 0; i < size; i++) {
			
			if (dataElements[i].equals(o)) {
				fastRemove(dataElements, i);
				break;
			}
		}
		return true;
	}
	
	
	private void fastRemove(Object[] es, int i) {
		int newSize;
		if((newSize=size-1)>i) {
			System.arraycopy(es, i + 1, es, i, newSize - 1);
		}
		es[size = newSize] = null;
	}
}
