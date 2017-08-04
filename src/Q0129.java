public class Q0129 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {
		
		/*
		 * Notice that n > A(n). 
		 * Also, gcd(n,10) = 1 implies n % 10 = 1,3,7,9. This means we can check odd numbers excluding 5.
		 * We apply trial division to finish the problem (repDiv function).
		 */
		
		int end = 1000000;
		int n = end + 1;
		while (true) {
			if (n % 5 != 0 && repDiv(n) > end) break;
			n+=2;
		}
		return n;
	}

	private static int repDiv(int n) {
		int r = 1;
		int counter = 1;
		while (r != 0) {
			r = (r * 10 + 1) % n;
			counter++;
		}
		return counter;
	}



}