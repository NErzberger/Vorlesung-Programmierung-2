package wwibe123.aufgabe5;

public class QueueTest {

	public static void main(String[] args) {
		MyQueue<String> queue = new MyQueue<String>();
		queue.enqueue("String 1");
		queue.enqueue("String 2");
		queue.enqueue("String 3");
		queue.enqueue("String 4");

		
		for(int i = queue.size(); i>0; i--) {
			System.out.println(queue.dequeue());
		}
		System.out.println("\n------------------");
		MyStack<String> myStack = new MyStack<String>();
		myStack.add("Aufruf 1");
		myStack.add("Aufruf 2");
		myStack.add("Aufruf 3");
		myStack.add("Aufruf 4");
		
		while(myStack.size() > 0) {
			System.out.println(myStack.poll());
		}
	}

}
