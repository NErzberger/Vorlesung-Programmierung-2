package wwibe223.aufgabe4;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyArrayList<T> extends AbstractList<T> implements List<T>{

	private static final int DEFAULT_CAPACITY = 10;
	
	private static final Object[] EMPTY_ELEMENTDATA = {};
	
	private Object[] dataElements;
	
	private int size;
	
	public MyArrayList() {
		this.dataElements = EMPTY_ELEMENTDATA;
		size = 0;
	}
	
	public MyArrayList(int capacity) {
		if (capacity > 0) {
			this.dataElements = new Object[capacity];
			size = capacity - 1;
		}else if (capacity == 0){
			this.dataElements = EMPTY_ELEMENTDATA;
			size = 0;
		}else {
			throw new IllegalArgumentException("Illegal capacity: " + capacity);
		}
	}
	
	public int size() {
		return this.size;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int position) {
		return (T) dataElements[position];
	}
	
	private Object[] grow(int minCapacity) {
		int oldCapacity = dataElements.length;
		if(oldCapacity > 0 || dataElements != EMPTY_ELEMENTDATA) {
			int preferredGrowth = oldCapacity + 1; // -> Bisherige Größe + 1;
			int newCapacity = ArraysSupport.newLength(oldCapacity, 
												minCapacity - oldCapacity, /*minimum growth*/
												preferredGrowth); /*preferred growth*/
			
			return dataElements = Arrays.copyOf(dataElements, newCapacity);
		}else {
			return dataElements = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
		}
	}
	
	private Object[] grow() {
		return grow(size + 1);
	}
	
	public boolean add(T element) {
		if(size == dataElements.length) {
			grow();
		}
		
		dataElements[size] = element;
		size++;
		return true;
	}
	
	public T remove(int index) {
		fastRemove(dataElements, index);
		return null;
	}
	
	public T myremove(T object) {
		for(int i = 0; i < size; i++) {
			if(dataElements[i].equals(object)) {
				fastRemove(dataElements, i);
				break;
			}
		}
		return null;
	}
	
	private void fastRemove(Object[] es, int i) {
		int newSize;
		if ((newSize = size - 1) > i) {
			System.arraycopy(es, i + 1, es, i, newSize - 1);
		}
		es[size = newSize] = null;
	}
	
	public void sort(Comparator<? super T> c) {
		T tmp = null;
		for(int i = 0; i < size; i++) {
			tmp = (T) dataElements[i];
			int j = i;
			
			while(j > 0 && c.compare((T) dataElements[j - 1], tmp)> 0) {
				dataElements[j] = dataElements[j - 1];
				j--;
			}
			dataElements[j] = tmp;
		}
	}
}
