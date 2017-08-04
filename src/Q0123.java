public class Q0123 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {
		

		/*
		 * (p + 1)^n + (p - 1)^n = 2 mod p^2 for even n.
		 * (p + 1)^n + (p - 1)^n = 2pn mod p^2 for odd n.
		 * 2pn > 10^10.
		 * pn > 5 * 10^9
		 * log p + log n > log 5 + 9
		 * 
		 * So the condition is log p + log n > log 5 + 9 and odd n.
		 * 
		 * I honestly don't know the ending number to sieve to, so I made an educated guess of end = 10000000.
		 */

		int end = 10000000;
		boolean[] prime = primeSieve(end);
		int n = 1;
		for (int p = 0; p < end; p++) {
			if (prime[p]) {
				if ((double) (Math.log10(p) + Math.log10(n)) > (double) (Math.log10(5) + 9) && n % 2 == 1)	 {
					return n;
				}
				n++;
			}
		}
		return -1;
	}



}