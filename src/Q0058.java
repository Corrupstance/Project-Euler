public class Q0058 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		
		/*
		 * For a (2n + 1) x (2n + 1) spiral
		 * Bottom Right: n^2 
		 * Bottom Left: n^2 - n + 1
		 * Top Left: n^2 - 2n + 2
		 * Top Right: n^2 - 3n + 3
		 */
		
		boolean[] prime = primeSieve(1000000000);
		int i = 3;
		
		while(true) {
			int sum = 0;
			for (int j = 3; j <= i; j+=2) {
				if (prime[j * j]) sum += 1;
				if (prime[j * j - j + 1]) sum += 1;
				if (prime[j * j - 2 * j + 2]) sum += 1;
				if (prime[j * j - 3 * j + 3]) sum += 1;
			}
			// Note that in the code below, (2*i + 1) is not the total number of diagonals on n = 3, but
			// this doesn't matter since the ratio is nowhere near 0.1 at n = 3.
			if ((double) sum/(2 * i + 1) < 0.1) break;	
			else i += 2;
		}
		
		return i;
	}
	
	
}