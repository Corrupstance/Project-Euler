public class Q0076 extends Library {
	
	public static void main(String[] args) {
		
	}
	
	public static int solve() {
		/*
		 * Dynamic Programming: see Q0031.
		 */
		
		int[] arr = new int[101];
		arr[0] = 1;
		
		for (int i = 1; i <= 100; i++) {
		    for (int j = i; j <= 100; j++) {
		        arr[j] += arr[j - i];
		    }
		}
		return arr[100] - 1; 	//Don't include 100 itself.
	}
	
	
	
}