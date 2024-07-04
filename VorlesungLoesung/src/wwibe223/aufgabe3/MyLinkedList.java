package wwibe223.aufgabe3;

public class MyLinkedList<T> {

	private int size;
	
	private Node<T> first;
	private Node<T> last;
	
	public MyLinkedList() {
		this.size = 0;
		this.first = null;
		this.last = null;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean add(T object) {
		if(first == null) {
			// Es wird das erste Element hinzugefügt.
			first = new Node<T>();
			first.setData(object);
			first.setNext(null);
			first.setPrev(null);
			
			size++;
		}else if(last == null && first.getNext() == null) {
			// Es wird das zweite Element hinzugefügt.
			last = new Node<T>();
			last.setData(object);
			last.setPrev(first);
			last.setNext(null);
			
			first.setNext(last);
			
			size++;
		}else {
			// Es sind 2 Element vorhanden, nun kann regulär die Liste befüllt werden.
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
}
