public class Q0009 extends Library {
	


	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		for (int a = 1; a < 1000; a++) {
			for (int b = 1; b < 1000; b++) {
				if (1000 * (a + b) == 500000 + a * b) {
					int prod = a * b * (1000 - a - b);
					return prod;
				}
			}
		}
		return -1;
	}


}