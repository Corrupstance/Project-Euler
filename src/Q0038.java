public class Q0038 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		
		/*
		 * Let k denote the number that generates the pandigital p.
		 * Since we require 9 digits and n > 1, it follows k has at most 4 digits.
		 * Also, since we begin with n = 1, the largest digit of k must be 9.
		 * 
		 * Suppose k has 1 digit. As we established before, k has to begin with 9.
		 * So as in the example we get the concatenated product of 9 and (1,2,3,4,5).
		 * 
		 * Suppose k has 2 digits; then p is of the form 9a for 0 <= a <= 8.
		 * But 9a * 2 = 180 + 2a (3 digits) and 9a * 3 = 270 + 3 (3 digits), so in particular taking
		 * n = 3 implies that p has 8 digits. Similarly taking n = 4 implies that p has 11 digits. So this case is impossible.
		 * 
		 * Suppose k has 3 digits; then n = 2 implies p has 7 digits, n = 3 implies p has 11 digits.
		 * So this case is impossible.
		 * 
		 * Suppose k has 4 digits; then n = 2 implies p has 9 digits. So we check all 4 digits beginning from 9. 
		 */
		
		int max = 0;
		
		for (int k = 9000; k <= 9999; k++) {
			String s = String.valueOf(k) + String.valueOf(2 * k);
			if (onePandigital(Integer.valueOf(s)) && Integer.valueOf(s) > max) max = Integer.valueOf(s); 
		}
		return max;
	}
	
	
}