package wwibe123.aufgabe4;

public class ArraysSupport {

	public static final int SOFT_MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;
	
	 public static int newLength(int oldLength, int minGrowth, int prefGrowth) {
	        // preconditions not checked because of inlining
	        // assert oldLength >= 0
	        // assert minGrowth > 0

	        int prefLength = oldLength + Math.max(minGrowth, prefGrowth); // might overflow
	        if (0 < prefLength && prefLength <= SOFT_MAX_ARRAY_LENGTH) {
	            return prefLength;
	        } else {
	            // put code cold in a separate method
	            return hugeLength(oldLength, minGrowth);
	        }
	    }

	    private static int hugeLength(int oldLength, int minGrowth) {
	        int minLength = oldLength + minGrowth;
	        if (minLength < 0) { // overflow
	            throw new OutOfMemoryError(
	                "Required array length " + oldLength + " + " + minGrowth + " is too large");
	        } else if (minLength <= SOFT_MAX_ARRAY_LENGTH) {
	            return SOFT_MAX_ARRAY_LENGTH;
	        } else {
	            return minLength;
	        }
	    }
}