import java.util.ArrayList;

public class Q0077 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		
		/*
		 * See Q0076.
		 */
		
		int length = 10000;
		boolean[] prime = primeSieve(length);
		int[] arr = new int[length];
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		
		for (int i = 0; i < length; i++) {
			if (prime[i]) primeList.add(i);
		}
		
		arr[0] = 1;
		for (int i = 0; i < primeList.size(); i++) {
			for (int j = primeList.get(i); j < length; j++) {
				arr[j] += arr[j - primeList.get(i)];
			}
			if (arr[i] > 5000) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	
}