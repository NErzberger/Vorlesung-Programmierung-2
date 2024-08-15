package wwibe123.aufgabe16;

public class Aufgabe16 {

	public static void main(String[] args) {
		int[] searchBase = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(interpolationSearch(searchBase, 3));

	}
	
	public static int interpolationSearch(int[] searchBase, int searchValue) {
		int pivotPos = 0;
		int rechteGrenze = searchBase.length - 1;
		int linkeGrenze = 0;
		while(linkeGrenze < rechteGrenze) {
			pivotPos = linkeGrenze + (searchValue - searchBase[linkeGrenze]) /
					(searchBase[rechteGrenze] - searchBase[linkeGrenze]) * 
					(rechteGrenze - linkeGrenze);
			
			if(searchBase[pivotPos] == searchValue) {
				return pivotPos;
			}else if(searchBase[pivotPos] < searchValue) {
				linkeGrenze = pivotPos + 1;
			}else {
				rechteGrenze = pivotPos - 1;
			}
		}
		if(linkeGrenze == rechteGrenze && searchBase[linkeGrenze]==searchValue) {
			return linkeGrenze;
		}
		return -1;
	}

}
