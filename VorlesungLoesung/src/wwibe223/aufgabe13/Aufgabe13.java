package wwibe223.aufgabe13;

import java.util.ArrayList;

public class Aufgabe13 {

	public static void main(String[] args) {
		int[] arr = {3, 6, 8, 4, 2, 5, 7, 9};
		quicksort(arr, 0, arr.length - 1);
	}
	
	public static void quicksort(int[] arr, int linkeGrenze, int rechteGrenze) {
		if (linkeGrenze < rechteGrenze) {
			ArrayList<String> a = new ArrayList<String>();
			int q = partition(arr, linkeGrenze, rechteGrenze);
			quicksort(arr, linkeGrenze, q);
			quicksort(arr, q+1, rechteGrenze);
		}
	}
	
	public static int partition(int[] arr, int l, int r) {
		int x = arr[(l + r) / 2];
		int i = l;
		int j = r;
		
		while(true) {
			while(arr[j] > x) {
				j--;
			}
			while(arr[i] < x) {
				i++;
			}
			
			if (i < j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			} else {
				return(j);
			}			
		}		
	}
}
