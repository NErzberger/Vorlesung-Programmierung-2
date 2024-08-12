package wwibe123;

import java.util.Iterator;

public class Aufgabe13 {

	public static void main(String[] args) {
		int[] array = {3, 6, 8, 4, 2, 1, 7, 5};
		quicksort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void quicksort(int[] array, int l, int r) {
		if(l < r) {
			int q = partition(array, l, r);
			quicksort(array, l, q);
			quicksort(array, q+1, r);
		}
	}
	
	public static int partition(int[] array, int l, int r) {
		int x = array[(l + r) / 2];
		int i = l;
		int j = r;
		
		while(true) {
			while(array[j] > x) {
				j = j - 1;
			}
			while(array[i] < x) {
				i = i + 1;
			}
			
			if(i < j) {
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
			}else {
				return j;
			}
		}
	}
}
