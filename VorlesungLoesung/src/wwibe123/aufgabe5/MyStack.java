package wwibe123.aufgabe5;

public class MyStack<T> {

	private Node<T> head;
	
	private int size;
	
	public MyStack() {
		size = 0;
		head = null;
	}
	
	public boolean add(T element) {
		Node<T> node = new Node<T>(element, head);
		size++;
		head = node;
		return true;
	}
	
	public int size() {
		return this.size;
	}
	
	public T poll() {
		T data = null;
		
		if(size == 0) {
			throw new IndexOutOfBoundsException();
		}
		
		if(size > 0) {
			data = head.getData();
			head = head.getNext();
			size--;
		}
		return data;
	}
	
	
}
