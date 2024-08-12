package wwibe223.aufgabe15;

import java.util.List;

import wwibe223.aufgabe2.CsvReader;
import wwibe223.aufgabe2.Waehrung;

public class Aufgabe15 {

	public static void main(String[] args) {
		CsvReader reader = new CsvReader();
		reader.readFile();
		List<Waehrung> myList = reader.getWaehrungList();
		
		Waehrung[] unsorted = new Waehrung[myList.size()];
		
		for(int i = 0; i < myList.size(); i++) {
			unsorted[i] = myList.get(i);
		}
		
		Waehrung[] sortedList = selectionSort(unsorted);

		System.out.println(binarySearch(sortedList, "EUR"));
	}
	
	public static Waehrung binarySearch(Waehrung[] sortedArray, String searchValue) {
		int pivotPos = 0;
		int rechteGrenze = sortedArray.length - 1;
		int linkeGrenze = 0;
		
		while(linkeGrenze <= rechteGrenze) {
			pivotPos = (linkeGrenze + rechteGrenze)/2;
			
			//if(sortedArray[pivotPos] == searchNum) {
			if (sortedArray[pivotPos].getKuerzel().equals(searchValue)) {
				return sortedArray[pivotPos];
			//} else if (sortedArray[pivotPos] < searchNum){
			} else if (sortedArray[pivotPos].getKuerzel().compareTo(searchValue) > 0) {
				linkeGrenze = pivotPos + 1;
			}else {
				rechteGrenze = pivotPos - 1;
			}
		}
		return null;
	}
	
	public static Waehrung[] selectionSort(Waehrung[] unsorted) {
		Waehrung temp = null;
		for(int i = 0; i < unsorted.length - 1; i++) {
			for(int j = i + 1; j < unsorted.length; j++) {
				if(unsorted[i].getKuerzel().compareTo(unsorted[j].getKuerzel()) < 0) {
					temp = unsorted[i];
					unsorted[i] = unsorted[j];
					unsorted[j] = temp;
				}
			}
		}
		return unsorted;
	}

}
