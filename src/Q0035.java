public class Q0035 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		
		/*
		 * First find all primes under one million, and then use the rotation algorithm to rotate the prime
		 * and check all the rotations are prime. If they are then add one to the total counter.
		 */
		
		
		boolean prime[] = primeSieve(1000000);
		int total = 0;
		
		for (int i = 0; i < prime.length; i++) {
			if (prime[i]) {
				int counter = 0;
				String[] rotations = rotations(String.valueOf(i));
				for (int j = 0; j < rotations.length; j++) {
					if (prime[Integer.valueOf(rotations[j])]) counter++;
				}
				if (counter == rotations.length) total++;
			}
		}
		
		return total;
	}
	
	
}