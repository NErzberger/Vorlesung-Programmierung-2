package wwibe223.aufgabe5;

public class TestStack {

	public static void main(String[] args) {
		MyStack<String> stack = new MyStack<String>();
		
		stack.add("Aufruf 1");
		stack.add("Aufruf 2");
		stack.add("Aufruf 3");
		
		while(stack.size() > 0){
			System.out.println(stack.poll());
		}
	}

}
