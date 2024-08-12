package wwibe223.aufgabe12;

public class Aufgabe12 {

	public static void main(String[] args) {
		int[] array = {3, 1, 8, 4, 2, 6, 7, 5};
		
		mergeSort(array, 0, array.length-1);
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void mergeSort(int[] array, int linkeGrenze, int rechteGrenze) {
		int i;
		int j;
		int k;
		int mitte;
		
		int[] tmp = new int[array.length];
		
		if(rechteGrenze > linkeGrenze) {
			mitte = (linkeGrenze + rechteGrenze) / 2;
			mergeSort(array, linkeGrenze, mitte);
			mergeSort(array, mitte+1, rechteGrenze);
			
			for(i = mitte; i >= linkeGrenze; i--) {
				tmp[i] = array[i];
			}
			
			for(j = mitte + 1; j <= rechteGrenze; j++) {
				tmp[rechteGrenze + mitte + 1 -j] = array[j];
			}
			
			i = linkeGrenze;
			j = rechteGrenze;
			for(k = linkeGrenze; k <= rechteGrenze; k++) {
				if(tmp[i] < tmp[j]) {
					array[k] = tmp[i]; 
					i++;
				}else {
					array[k] = tmp[j]; 
					j--;
				}
			}
		}
	}
}
