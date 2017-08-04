public class Q0001 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		return sum(1000);
	}
	
	private static int sum(int n) {
		
		/*
		 * Check for modulo 3/5 == 0.
		 */
		
		int val = 0;
		for (int i = 0; i < n; i++) {
			if (i % 3 == 0 || i % 5 == 0) val += i;
		}
		return val;
	}
	
}