public class Q0037 extends Library {
	
	

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		
		/*
		 * Repeatedly check if left and right substring are primes. Note that the choice of 1 million in the prime
		 * sieve was a guess; we use the hint that there are only 11 truncatable primes to break out of the loop early.
		 */

		boolean[] prime = primeSieve(1000000);
		int counter = 0;
		int sum = 0;

		for (int i = 10; i < prime.length; i++) {
			if (prime[i]) {
				String tmpLeft = String.valueOf(i);
				String tmpRight = String.valueOf(i);
				boolean truncPrime = true;
				for (int j = String.valueOf(i).length() - 1; j > 0 ; j--) {
					tmpLeft = tmpLeft.substring(1);
					tmpRight = tmpRight.substring(0, j);
					if (!prime[Integer.valueOf(tmpLeft)] || !prime[Integer.valueOf(tmpRight)]) truncPrime = false;
				}
				if (truncPrime) {
					counter++;
					sum += i;
				}
			}
			if (counter == 11) break;
		}
		return sum;
		
	}



}