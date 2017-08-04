public class Q0049 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {

		/*
		 * Since we are dealing with 4-digit numbers we can begin our loop at i = 1000.
		 * The hint says there are only 3 terms. Hence the difference d must be greater
		 * or equal to 3000, since if there was 4 terms then the 4th term is at least
		 * 1000 + 3 * 3000 = 10000, but this is not a 4-digit number. Similarly,
		 * the upper bound of d must be 4500, since there cannot be 2 terms in the sequence.  
		 * 
		 * Thus the upper bound of i is 4000, since 4000 + 2 * 3000 = 10000.
		 * 
		 * After this we can perform checks on whether or not i, i+d, i+2d are prime
		 * and if they are permutations of each other. If they are then we break and output.
		 */
		
		boolean[] prime = primeSieve(100000);

		for (int i = 1000; i <= 3999; i++) {	
			for (int d = 3000; d < 4500; d++) {
				int tmp = i;
				int counter = 1;
				if (!prime[i]) break;
				boolean primeAndPerm = true;
				if (tmp + d >= 10000) primeAndPerm = false;
				while (tmp + d < 10000) {
					tmp += d;
					counter++;
					if (!prime[tmp] || !isPermutation(String.valueOf(tmp),String.valueOf(i))) {
						primeAndPerm = false;
						break;
					}
				}
				if (primeAndPerm && counter == 3 && i != 1487) {
					return i;
				}
			}	
		}
		return -1;
	}



}