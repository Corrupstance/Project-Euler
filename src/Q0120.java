public class Q0120 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		
		/*
		 * Note that for any even n, 
		 * (a-1)^n + (a-1)^n = 2(nC0a^n + nC2a^(n-2) + nc4a^(n-4) + ... + 1) (mod a^2) congruent to 2 (mod a^2).
		 * 
		 * For any odd n,
		 * (a-1)^n + (a-1)^n = 2(nC0a^n + nC2a^(n-2) + nc4a^(n-4) + ... + na) (mod a^2) congruent to 2na (mod a^2).
		 * 
		 * Since 2na > 2 as n >= 1 and a > 3, we consider the odd case only. To maximise the remainder, we have to find
		 * 2an congruent to r (mod a^2) => 2an = r + ka^2. Taking k = 0, we get that 2an = r.
		 * Note that since 0 <= r < a^2, then for r to be maximised, r is of the form a^2 - c, 
		 * where the smaller the c the better. Solving for n gives 
		 * n = [a^2 - c]/2a. To guarantee that n is an integer, we can take c = a.
		 * (we can take a instead of 2a because if a is odd, then a^2 is odd and a^2 - a is even, so it is divisible by 2.
		 * if a is even, then a^2 is even and a^2 - a is even.)
		 * So n = (a - 1)/2.
		 * So r = 2a((a-1)/2) is the maximum remainder. 
		 */
		
		int rem = 0;
		for (int a = 3; a <= 1000; a++) {
			rem += 2 * a * ((a-1) / 2);
		}
		return rem;
	}
}