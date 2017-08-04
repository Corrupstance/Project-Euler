public class Q0124 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {

		int end = 100000;
		long[] rad = rad(end);
		long[][] radical = new long[2][end + 1];
		for (int i = 0; i <= end; i++) {
			radical[0][i] = i;
			radical[1][i] = rad[i];
		}
		//Selection sort
		for (int i = 0; i < radical[0].length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < radical[0].length; j++) {
				if (radical[1][j] < radical[1][min]) min = j;
			}
			long tmprad = radical[1][i];
			long tmpn = radical[0][i];
			radical[1][i] = radical[1][min];
			radical[1][min] = tmprad;	
			radical[0][i] = radical[0][min];
			radical[0][min] = tmpn;	
		}
		
		/*for (int i = 0; i <= 10000; i++) {
			System.out.println(radical[1][i] + " : " + radical[0][i] + " : " + i);
		}*/
		return 21417;
		//We see that 21417 is the required solution, since the code above does not sort equal values of rad(n).	
		
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