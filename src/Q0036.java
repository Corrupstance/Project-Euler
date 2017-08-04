public class Q0036 extends Library {



	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {
		
		/*
		 * Check if the decimal and binary format of i are palindromes. 
		 */
		
		int sum = 0;
		for (int i = 0; i < 1000000; i++) {
			String bin = Integer.toBinaryString(i);
			if (palindrome(String.valueOf(i)) && palindrome(bin)) sum += i;
		}
		return sum;	
	}
}