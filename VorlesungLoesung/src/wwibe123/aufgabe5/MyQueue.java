package wwibe123.aufgabe5;

public class MyQueue<T>  {

	private Node<T> first;
	private Node<T> last;
	
	private int size;
	
	public MyQueue() {
		first = null;
		last = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean add(T object) {
		Node<T> newNode = new Node<T>();
		newNode.setData(object);
		newNode.setNext(null);
		
		if(first == null) {
			first = newNode;
			last = newNode;
		}else {
			last.setNext(newNode);
			last = newNode;
		}
		
		size++;
		return true;
		
	}
	
	public boolean enqueue(T object) {
		return add(object);
	}
	
	public T dequeue() {
		T data = null;
		
		if(size == 0) {
			throw new IndexOutOfBoundsException();
		}
		
		if(size > 0) {
			if(first==null) {
				size = 0;
				return null;
			}
			data = first.getData();
			first = first.getNext();
			size--;
		}
		
		return data;
	}
}
