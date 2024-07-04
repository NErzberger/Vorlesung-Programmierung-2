package wwibe123.array;

public class ArrayHandling {

	public static void main(String[] args) {
		int[] intArray= {1, 2, 3, 4};
		System.out.println(intArray.length);
		intArray = growArray(intArray);
		System.out.println(intArray.length);
	}
	
	public static int[] growArray(int[] oldArray) {
		int[] newArray = new int[oldArray.length + 1];
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
		return newArray;
	}
}
