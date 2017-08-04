public class Q0039 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		
		/*
		 * We substitute c = sqrt(a^2 + b^2) into a + b + c = p to obtain
		 * that the necessary condition must be a + b + sqrt(a^2 + b^2) = p.
		 * Then by fixing p for 0 <= x <= 1000, we check for solutions by
		 * looping over a and b.
		 */

		int max = 0;
		int sol = 0;
		int counter = 0;

		for (int p = 0; p <= 1000; p++) {
			for (int a = 0; a <= 1000; a++) {
				for (int b = 0; b <= 1000; b++) {
					if (a + b + Math.sqrt(a * a + b * b) == p) counter++;
				}			
			}	
			if (counter > max) {
				max = counter;
				sol = p;
			}	
			counter = 0;
		} 
		return sol;

	}


}