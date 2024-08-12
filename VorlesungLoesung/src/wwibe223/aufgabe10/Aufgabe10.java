package wwibe223.aufgabe10;

import java.util.List;

import wwibe223.aufgabe2.CsvReader;
import wwibe223.aufgabe2.Waehrung;

public class Aufgabe10 {

	public static void main(String[] args) {
		CsvReader reader = new CsvReader();
		reader.readFile();
		List<Waehrung> myList = reader.getWaehrungList();
		
		Waehrung[] unsorted = new Waehrung[myList.size()];
		
		for(int i = 0; i < myList.size(); i++) {
			unsorted[i] = myList.get(i);
		}
		
		Waehrung[] sortedList = insertSort(unsorted);
		
		for(Waehrung w : sortedList) {
			System.out.println(w);
		}
	}
	
	public static Waehrung[] insertSort(Waehrung[] unsorted) {
		Waehrung temp = null;
		for(int i = 0; i < unsorted.length; i++) {
			temp = unsorted[i];
			int j = i;
			while(j > 0 && unsorted[j-1].getKuerzel().compareTo(temp.getKuerzel()) > 0) {
				unsorted[j] = unsorted[j - 1];
				j--;
			}
			unsorted[j] = temp;
		}
		return unsorted;
	}
}
