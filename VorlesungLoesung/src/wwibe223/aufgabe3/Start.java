package wwibe223.aufgabe3;

import java.util.ArrayList;

import wwibe223.aufgabe4.MyArrayList;

public class Start {

	public static void main(String[] args) {
		
		//ArrayList<String> arrayList = new ArrayList<String>();
//		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
//		
//		int wert1 = Integer.parseInt("2");
		
		
		MyLinkedList<String> list = new MyLinkedList<String>();
		list.add("Wert 1");
		list.add("Wert 2");
		list.add("Wert 3");
		
//		System.out.println("Anzahl der Einträge: " + list.size());
//		System.out.println(list.get(2));
		
		list.delete(1);
		
//		System.out.println("Anzahl der Einträge: " + list.size());
		
		MyArrayList<String> arrayList = new MyArrayList<String>();
		
		arrayList.add("String1");
		arrayList.add("String2");
		arrayList.add("String3");
		arrayList.add("String4");
		arrayList.add("String5");
		
		String text1 = "Hallo";
		String text2 = text1;
		
		if(text1 == text2) {
			System.out.println("Das gleiche");
		}
		
		arrayList.remove(2);
		
		for(int i = 0; i < arrayList.size(); i++) {
//			System.out.println(arrayList.get(i));
		}
	}
}
