public class Q0127 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static long solve() {

		/*
		 * gcd(a,b) = gcd(a,a+b) = gcd(b,a+b) = 1 => rad(abc) = rad(a)rad(b)rad(c). 
		 */

		long sum = 0;
		int end = 120000;
		long[] rad = rad(end);

		for (int a = 1; a < end; a++) {
			for (int b = a + 1; b < end; b++) {
				if (a + b >= end) break;
				if (rad[a] * rad[b] * rad[a + b] < a+b && gcd(a,b) == 1) sum += a + b;
			}
		}
		return sum;
	}
	
	/*
	 * For any prime p, we set rad(p) = p, since the only prime divisor of p is itself.
	 * Set rad(n) = 1 for non-prime n.
	 * Take any prime p. Then 2p, 3p, ..., kp is divisible by p. So we multiply rad(kp) by p.
	 * Beginning from 2,3,5,..., this sieves out the radicals of non primes up to any natural number n.
	 */

	public static long[] rad(int n) {
		boolean[] prime = primeSieve(n);
		long[] rad = new long[n + 1];
		for (int i = 0; i < rad.length; i++) {
			if (!prime[i]) rad[i] = 1;
			else rad[i] = i;
		}
		for (int i = 0; i <= n; i++) {
			if (prime[i]) {
				for (int j = 2 * i; j <= n; j += i) {
					rad[j] *= i;
				}
			}
		}
		return rad;
	}
}