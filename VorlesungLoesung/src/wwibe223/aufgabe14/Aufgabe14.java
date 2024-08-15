package wwibe223.aufgabe14;

import java.util.List;

import wwibe223.aufgabe2.CsvReader;
import wwibe223.aufgabe2.Waehrung;


public class Aufgabe14 {

	public static void main(String[] args) {
		CsvReader reader = new CsvReader();
		reader.readFile();
		List<Waehrung> myList = reader.getWaehrungList();
		Waehrung[] unsorted = new Waehrung[myList.size()];
		
		// Hilfsfunktion, da beim toArray ein Casting nicht funktioniert von Object -> Waehrung
		for(int i = 0; i < myList.size();  i++) {
			unsorted[i] = myList.get(i);
		}
		
		quicksort(unsorted, 0, unsorted.length-1);
		
		int index = linearSearch(unsorted, "JPY");
		
		if (index >= 0) {
			System.out.println(unsorted[index]);
		}else {
			System.out.println("Währung wurde nicht gefunden.");
		}
	}
	
	public static int linearSearch(Waehrung[] sortedArray, String searchValue) {
		for(int i = 0; i < sortedArray.length; i++) {
			//Vergleiche jedes Element im Array mit dem Suchwert
			//if(sortedArray[i]==searchValue) {
			if(sortedArray[i].getKuerzel().equals(searchValue)) {
				return i;
			}
			//Breche Suche ab, falls aktueller Wert größer als Suche ist
//			}else if(sortedArray[i] > searchValue){
//				return -1;
//			}
		}		
		//Wenn das Element nicht gefunden wurde gebe -1 zurück
		return -1;
	}
	
	
	public static void quicksort(Waehrung[] arr, int l, int r) {
		if (l < r) {
			int q = partition(arr, l, r);
			quicksort(arr, l, q);
			quicksort(arr, q+1, r);
		}
	}
	
	public static int partition(Waehrung[] arr, int l, int r) {
		Waehrung x = arr[(l + r) / 2];
		int i = l;
		int j = r;
		
		while(true) {
//			while(arr[j] > x) j--;
//			while(arr[i] < x) i++;
			while(arr[j].getKuerzel().compareTo(x.getKuerzel()) > 0) j--;
			while(arr[i].getKuerzel().compareTo(x.getKuerzel()) < 0) i++;
			
			if (i < j) {
				Waehrung tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			} else {
				return(j);
			}			
		}		
	}
}
