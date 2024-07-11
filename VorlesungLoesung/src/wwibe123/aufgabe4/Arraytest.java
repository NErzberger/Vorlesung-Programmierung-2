package wwibe123.aufgabe4;

import java.util.Iterator;

import wwibe123.csvReader.CsvReader;
import wwibe123.csvReader.Waehrung;

public class Arraytest {

	public static void main(String[] args) {
		MyArrayList<String> arrayList = new MyArrayList<String>();
		arrayList.add("String 1");
		arrayList.add("String 2");
		arrayList.add("String 3");
		arrayList.add("String 4");
		arrayList.add("String 5");
		
		System.out.println("Size: " + arrayList.size());
		
		arrayList.remove(2);
		
		System.out.println("Size: " + arrayList.size());
		
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
		
		CsvReader csvReader = new CsvReader();
		csvReader.readFile();
		
		for(Waehrung waehrung : csvReader.getWaehrungList()) {
			System.out.println(waehrung);
		}
	}
}
