package wwibe123.aufgabe10;

import java.util.Comparator;
import java.util.List;

import wwibe123.csvReader.CsvReader;
import wwibe123.csvReader.Waehrung;

public class Aufgabe10 {

	public static void main(String[] args) {
		CsvReader reader = new CsvReader();
		reader.readFile();
		List<Waehrung> myList = reader.getWaehrungList();
		Waehrung[] unsorted = new Waehrung[myList.size()];
		
		myList.sort(new Comparator<Waehrung>() {

			@Override
			public int compare(Waehrung o1, Waehrung o2) {
				return o1.getKuerzel().compareTo(o2.getKuerzel());
			}
		});
		
		for(int i = 0; i< myList.size(); i++) {
			unsorted[i] = myList.get(i);
		}
		
		Waehrung[] sortedList = insertSort(unsorted);
		for(int i = 0; i < sortedList.length -1; i++) {
			System.out.println(sortedList[i]);
		}
	}
	
	public static Waehrung[] insertSort(Waehrung[] unsortedArray) {
		Waehrung tmp = null;
		for(int i = 0; i < unsortedArray.length; i++) {
			tmp = unsortedArray[i];
			int j = i;
			
			while(j > 0 && unsortedArray[j - 1].getKuerzel().compareTo(tmp.getKuerzel())> 0) {
				unsortedArray[j] = unsortedArray[j - 1];
				j--;
			}
			unsortedArray[j] = tmp;
		}
		return unsortedArray;
	}
}
