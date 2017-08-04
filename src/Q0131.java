//import java.util.ArrayList;

public class Q0131 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {

		/*
		 * n^3 + pn^2 = m^3 for some m > n, so m = n + a for a > 0.
		 * n^3 + pn^2 = (n+a)^3
		 * n^3 + pn^2 = n^3 + 3an^2 + 3a^2n + a^3
		 * pn^2 = 3an^2 + 3a^2n + a^3
		 * pn^2 = a(3n^2 + 3an + a^2)
		 * 
		 * so a | pn^2 => a | p or a | n^2. Let a | p, so a = 1 or a = p. a = 1 is already counted since a | n^2,
		 * so consider a = p. Then an^2 = a(3n^2 + 3an + a^2) => 0 = 2n^2 + 3an + a^2, which has no solutions in 
		 * the positive integers. So a must be a divisor of n^2. 
		 * 
		 * p = a^3/n^2 + 3a^2/n + 3a. 
		 * 
		 * The commented code wasn't quick enough to give a solution, but produced this:
		 * 
		 *  p  |  n   | a
		 *  7  :  1   : 1.0
		 *  19 :  8   : 4.0
		 *  37 :  27  : 9.0
		 *  61 :  64  : 16.0
		 *  127 : 216 : 36.0
		 *  271 : 729 : 81.0
		 *  
		 * Clearly n = k^3, a = k^2 for some k. Since we are given that n is unique for each p, thus k is unique.
		 * Certainly a = k^2 | n^2 = k^6, so our results hold. Substituting n, a in terms of k into the equation gives
		 * p = 1 + 3k + 3k^2. We only need to find prime values of p.
		 * 
		 * 
		 * Interestingly note that p = 1 + 3k + 3k^2 = (1+k)^3 - k^3. So p is a difference of consecutive cubes.
		 * 
		 * 
		 */

		int end = 1000000;
		int counter = 0;
		
		boolean[] prime = primeSieve(end);

	/*	ArrayList<Long> div = new ArrayList<Long>();
	    for (int n = 1; n < end; n++) {
			div = divisorsL((long) (n * n));		
			for (int a = 0; a < div.size(); a++) {
				double divA = (double) div.get(a);
				if ((divA * divA * divA) / (n * n) >= end || (divA * divA * divA) / (n * n) < 0) break;
				else {
					if ((divA * divA * divA) % (n * n) == 0 && (3 * divA * divA) % n == 0) {
						int p = (int) ((divA * divA * divA)/(n * n) + ((3 * divA * divA)/n) + 3 * divA);
						if (p % 2 == 0) continue;
						if (p < 0 || p >= end) break;
						else if (p > 0 && p < end && prime[(int) p]) {
							System.out.println(p + " : " + n + " : " +  divA);
							counter++;
							break;
						}
					}
				}
			}
		}*/
		
		for (int k = 1; k < end; k++) {
			if ((long) 1 + 3 * k + 3 * k * k >= end) break;
			if (prime[1 + 3 * k  + 3 * k * k]) counter++;
		}
		return counter;
	}





}