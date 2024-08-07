package wwibe223.aufgabe5;

public class Queue<E> {

	private Node<E> first;
	private Node<E> last;

	private int size;
	
	public Queue() {
		
	}
	
	public boolean add(E object) {
		Node<E> newNode = new Node<E>();
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
	
	public boolean enqueue(E object) {
		return add(object);
	}
	
	public E dequeue() {
		E data = null;
		
		if(size == 0) {
			throw new IndexOutOfBoundsException(size - 1);
		}
		
		if(size > 0) {
			if(first == null) {
				size = 0;
				return null;
			}
			data = first.getData();
			first = first.getNext();
			size--;
		}
		return data;
	}
	
	public int size() {
		return size;
	}
}
