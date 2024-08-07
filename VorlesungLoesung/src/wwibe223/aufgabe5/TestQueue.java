package wwibe223.aufgabe5;

public class TestQueue {

	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
		
		queue.add("String 1");
		queue.add("String 2");
		queue.add("String 3");
		
		while(queue.size() > 0) {
			System.out.println(queue.dequeue());
		}

	}

}
