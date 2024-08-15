package wwibe223;

import java.util.Enumeration;
import java.util.Hashtable;

public class Aufgabe17 {

	public static void main(String[] args) {
	Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
		
		hashtable.put(1, "Java");
		hashtable.put(2, "C++");
		hashtable.put(3, "Python");
		hashtable.put(4, "Go");
		
		Enumeration<Integer> keys = hashtable.keys();
		while(keys.hasMoreElements()) {
			int key = keys.nextElement();
			System.out.println("Key: " + key + ", Value: "+ hashtable.get(key));
		}
	}
}
