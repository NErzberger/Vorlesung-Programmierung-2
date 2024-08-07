package wwibe223.aufgabe9;

import java.util.List;

import wwibe223.aufgabe2.CsvReader;
import wwibe223.aufgabe2.Waehrung;

public class Aufgabe9 {

	public static void main(String[] args) {
		CsvReader reader = new CsvReader();
		reader.readFile();
		List<Waehrung> myList = reader.getWaehrungList();
		
		Waehrung[] unsorted = new Waehrung[myList.size()];
		
		for(int i = 0; i < myList.size(); i++) {
			unsorted[i] = myList.get(i);
		}
		
		Waehrung[] sortedList = bubbleSort(unsorted);
		
		for(Waehrung w : sortedList) {
			System.out.println(w);
		}
	}

	
	public static Waehrung[] bubbleSort(Waehrung[] unsorted) {
		int n = unsorted.length;
		
		Waehrung tmp = null;
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(unsorted[j].getKuerzel().compareTo(unsorted[j + 1].getKuerzel()) > 0) {
					tmp = unsorted[j];
					unsorted[j] = unsorted[j + 1];
					unsorted[j + 1] = tmp;
				}
			}
		}
		return unsorted;
	}
}
