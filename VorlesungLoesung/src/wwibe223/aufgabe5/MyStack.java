package wwibe223.aufgabe5;

public class MyStack<E> {

	private Node<E> head;
	
	private int size;
	
	public MyStack() {
		size = 0;
	}
	
	public void add(E element) {
		Node<E> node = new Node<E>(element, head);
		size++;
		head = node;
	}
	
	public E poll() {
		E data = null;
		
		if(size == 0) {
			throw new IndexOutOfBoundsException(size - 1);
		}
		
		if(size > 0) {
			data = head.getData();
			
			head = head.getNext();
			size--;
		}
		return data;
	}
	
	public int size() {
		return size;
	}
}
