package wwibe223.aufgabe11;

import java.util.List;

import wwibe223.aufgabe2.CsvReader;
import wwibe223.aufgabe2.Waehrung;

public class Aufgabe11 {
	
	public static void main(String[] args) {
		CsvReader reader = new CsvReader();
		reader.readFile();
		List<Waehrung> myList = reader.getWaehrungList();
		
		Waehrung[] unsorted = new Waehrung[myList.size()];
		
		for(int i = 0; i < myList.size(); i++) {
			unsorted[i] = myList.get(i);
		}
		
		Waehrung[] sortedList = selectionSort(unsorted);
		
		for(Waehrung w : sortedList) {
			System.out.println(w);
		}
	}
	
	public static Waehrung[] selectionSort(Waehrung[] unsorted) {
		for(int i = 0; i < unsorted.length - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < unsorted.length; j++) {
				if(unsorted[j].getKuerzel().compareTo(unsorted[minIndex].getKuerzel()) < 0) {
					minIndex = j;
				}
			}
			Waehrung tmp = unsorted[minIndex];
			unsorted[minIndex] = unsorted[i];
			unsorted[i] = tmp;
		}
		return unsorted;
	}
}
