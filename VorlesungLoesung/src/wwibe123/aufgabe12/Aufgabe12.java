package wwibe123.aufgabe12;

import java.util.List;

import wwibe123.csvReader.CsvReader;
import wwibe123.csvReader.Waehrung;

public class Aufgabe12 {

	public static void main(String[] args) {
		CsvReader reader = new CsvReader();
		reader.readFile();
		List<Waehrung> myList = reader.getWaehrungList();
		Waehrung[] unsorted = new Waehrung[myList.size()];
		
		for(int i = 0; i< myList.size(); i++) {
			unsorted[i] = myList.get(i);
		}
		
		mergeSort(unsorted, 0, unsorted.length - 1);
		for(int i = 0; i < unsorted.length -1; i++) {
			System.out.println(unsorted[i]);
		}
	}
	
	public static void mergeSort(Waehrung[] unsortiert, int linkeGrenze, int rechteGrenze) {
		int i, j, k, mitte;
		Waehrung[] tmp = new Waehrung[unsortiert.length];
		
		if (rechteGrenze > linkeGrenze) {
			mitte = (linkeGrenze + rechteGrenze) / 2;
			mergeSort(unsortiert, linkeGrenze, mitte);
			mergeSort(unsortiert, mitte + 1, rechteGrenze);
			
			for(i = mitte; i >= linkeGrenze; i--) {
				tmp[i] = unsortiert[i];
			}
			for(j = mitte+1; j <= rechteGrenze; j++) {
				tmp[rechteGrenze + mitte + 1 - j] = unsortiert[j];
			}
			i = linkeGrenze; j = rechteGrenze;
			for(k = linkeGrenze; k <= rechteGrenze; k++) {
				//if(tmp[i] < tmp[j]) {
				if(tmp[i].getKuerzel().compareTo(tmp[j].getKuerzel())<0) {
					unsortiert[k] = tmp[i++];
				} else {
					unsortiert[k] = tmp[j--];
				}
			}
		}
	}
	
	
}
