package wwibe123.aufgabe9;

import java.util.List;

import wwibe123.csvReader.CsvReader;
import wwibe123.csvReader.Waehrung;

public class Aufgabe9 {

	public static void main(String[] args) {
		CsvReader reader = new CsvReader();
		reader.readFile();
		List<Waehrung> myList = reader.getWaehrungList();
		Waehrung[] unsorted = new Waehrung[myList.size()];
		
		for(int i = 0; i< myList.size(); i++) {
			unsorted[i] = myList.get(i);
		}
		
		Waehrung[] sortedList = bubbleSort(unsorted);
		for(int i = 0; i < sortedList.length -1; i++) {
			System.out.println(sortedList[i]);
		}
		
	}
	
	public static Waehrung[] bubbleSort(Waehrung[] waehrungArray) {
		int n = waehrungArray.length;
		Waehrung tmp = null;
		for(int i = 0; i < n -1; i++) {
			for(int j = 0; j < n -i -1; j++ ) {
				if(waehrungArray[j].getKuerzel().compareTo(
							waehrungArray[j + 1].getKuerzel()) > 0) {
					tmp = waehrungArray[j];
					waehrungArray[j] = waehrungArray[j + 1];
					waehrungArray[j + 1] = tmp;
				}
			}
		}
		return waehrungArray;
	}
}
