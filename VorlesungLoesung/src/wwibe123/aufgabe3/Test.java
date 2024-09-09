package wwibe123.aufgabe3;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList<Integer>();
		
		MyLinkedList<String> list = new MyLinkedList<String>();
		String myString = "Mein String";
		list.add(myString);
		list.add("Wert 1");
		list.add("Wert 2");
		list.add("Wert 3");
		
		
		
		
		System.out.println(list.get(1));
		
		System.out.println("Size: " + list.size());
		
		list.delete(2);
		
		System.out.println("Size: " + list.size());
		
		list.delete(myString);
	}

}
