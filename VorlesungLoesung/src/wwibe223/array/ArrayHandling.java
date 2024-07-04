package wwibe223.array;

public class ArrayHandling {

	public static void main(String[] args) {
		int[] integerArray = {1, 2, 3, 4};
		System.out.println("Alte Länge: " + integerArray.length);
		
		integerArray = growArray(integerArray);
		
		System.out.println("Neue Länge: " + integerArray.length);
	}
	
	private static int[] growArray(int[] arrayOld) {
		int[] newArray = new int[arrayOld.length + 1];
		
		for(int i = 0; i< arrayOld.length; i++) {
			newArray[i] = arrayOld[i];
		}
		return newArray;
	}
}