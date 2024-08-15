package wwibe123.aufgabe17;

import java.util.Hashtable;

public class Aufgabe17 {

	public static void main(String[] args) {
		Hashtable<Integer, String> hashTable = new Hashtable<Integer, String>();
		hashTable.put(1, "String1");
		hashTable.put(2, "String2");
		hashTable.put(3, "String3");
		hashTable.put(4, "String4");
		hashTable.put(5, "String5");
		
		System.out.println(hashTable.get(3));

	}

}
