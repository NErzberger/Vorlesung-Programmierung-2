package wwibe123;

import java.util.Comparator;
import java.util.List;

import wwibe123.csvReader.CsvReader;
import wwibe123.csvReader.Waehrung;

public class SortArrayByComparator {

	public static void main(String[] args) {
		CsvReader reader = new CsvReader();
		reader.readFile();
		List<Waehrung> myList = reader.getWaehrungList();
		
		myList.sort(new Comparator<Waehrung>() {

			@Override
			public int compare(Waehrung o1, Waehrung o2) {
				return o1.getKuerzel().compareTo(o2.getKuerzel());
			}
			
		});
	}
}
