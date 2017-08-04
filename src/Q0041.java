public class Q0041 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {

		/*
		 * Perform a check for all 1-9 digit numbers.
		 */

		boolean[] prime = primeSieve(10000000);

		for (int i = 9999999; i >= 2; i-=2) {
			if (onePandigital(i) && prime[i]) return i;
		}
		return -1;
	}



}