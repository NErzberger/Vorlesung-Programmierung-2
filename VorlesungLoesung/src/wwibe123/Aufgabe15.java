package wwibe123;

import java.util.List;

import wwibe123.csvReader.CsvReader;
import wwibe123.csvReader.Waehrung;


public class Aufgabe15 {

	public static void main(String[] args) {
		CsvReader reader = new CsvReader("currenciec.csv");
		reader.readFile();
		List<Waehrung> myList = reader.getWaehrungList();
		Waehrung[] unsorted = new Waehrung[myList.size()];
		
		// Hilfsfunktion, da beim toArray ein Casting nicht funktioniert von Object -> Waehrung
		for(int i = 0; i < myList.size();  i++) {
			unsorted[i] = myList.get(i);
		}
		
		quicksort(unsorted, 0, unsorted.length-1);
		
		int index = binarySearch(unsorted, "USD");
		
		if (index >= 0) {
			System.out.println(unsorted[index]);
		}else {
			System.out.println("Währung wurde nicht gefunden.");
		}
	}
	
	public static int binarySearch(Waehrung[] sortedArray, String searchValue) {
		int pivotPos = 0;
		int rechteGrenze = sortedArray.length - 1;
		int linkeGrenze = 0;
		
		while(linkeGrenze <= rechteGrenze) {
			pivotPos = (linkeGrenze + rechteGrenze)/2;
			
			//if(sortedArray[pivotPos] == searchNum) {
			if (sortedArray[pivotPos].getKuerzel().equals(searchValue)) {
				return pivotPos;
			//} else if (sortedArray[pivotPos] < searchNum){
			} else if (sortedArray[pivotPos].getKuerzel().compareTo(searchValue) < 0) {
				linkeGrenze = pivotPos + 1;
			}else {
				rechteGrenze = pivotPos - 1;
			}
		}
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
