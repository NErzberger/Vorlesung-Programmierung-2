package wwibe123.aufgabe3;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {

	private int size;
	
	private Node<T> first;
	private Node<T> last;
	
	public MyLinkedList() {
		size = 0;
		first = null;
		last = null;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean add(T object) {
		if(first == null) {
			// Es wird das erste Element hinzugefügt.
			
			first= new Node<T>();
			first.setData(object);
			first.setNext(null);
			first.setPrev(null);
			
			size++;
		}else if (last == null && first.getNext() == null) {
			// Es wird das zweite Element hinzugefügt.
			
			last = new Node<T>();
			last.setData(object);
			last.setPrev(first);
			last.setNext(null);
			
			first.setNext(last);
			size++;
		}else {
			// Es sind 2 Elemente vorhanden, nun kann regulär die Liste befüllt werden.
			
			Node<T> tmp = last;
			last = new Node<T>();
			last.setData(object);
			last.setPrev(tmp);
			last.setNext(null);
			
			tmp.setNext(last);
			
			size++;
		}
		return true;
	}
	
	public T get(int index) {
		int i = 0;
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if(size / 2 > index) {
			Node<T> n = first;
			while(true) {
				if(i == index) {
					return n.getData();
				}
				n = n.getNext();
				if(n == null) {
					throw new NoSuchElementException();
				}
				i++;
			}
		}else {
			i = size - 1;
			Node<T> n = last;
			while(true) {
				if(i == index) {
					return n.getData();
				}
				n = n.getPrev();
				if (n == null) {
					throw new NoSuchElementException();
				}
				i--;
			}
		}
	}
	
	public void delete(int index) {
		int i = 0;
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		if(size / 2 > index) {
			Node<T> n = first;
			while(true) {
				if(i == index) {
					if(n.getPrev() != null) {
						Node<T> nPrev = n.getPrev();
						nPrev.setNext(n.getNext());
					} else {
						first = n.getNext();
					}
					if(n.getNext() != null) {
						n.getNext().setPrev(n.getPrev());
					} else {
						last = n.getPrev();
					}
					size--;
					break;
				}
				i++;
				n = n.getNext();
			}
		}else {
			i = size - 1;
			Node<T> n = last;
			while(true) {
				if(i == index) {
					if(n.getPrev() != null) {
						Node<T> nPrev = n.getPrev();
						nPrev.setNext(n.getNext());
					} else {
						first = n.getNext();
					}
					if(n.getNext() != null) {
						n.getNext().setPrev(n.getPrev());
					} else {
						last = n.getPrev();
					}
					size--;
					break;
				}
				i--;
				n = n.getPrev();
			}
		}
	}
	
	public void delete(T object) {
		if (first == null) {
			throw new NullPointerException("Empty list");
		}
		
		Node<T> n = first;
		while(true) {
			if(n.getData().equals(object)) {
				if(n.getPrev() != null) {
					Node<T> nPrev = n.getPrev();
					nPrev.setNext(n.getNext());
				} else {
					first = n.getNext();
				}
				if(n.getNext() != null) {
					n.getNext().setPrev(n.getPrev());
				} else {
					last = n.getPrev();
				}
				size--;
				break;
			}
			n = n.getNext();
		}
	}
}
