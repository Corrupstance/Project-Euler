public class Q0179 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	/*
	 * Over 1 min.
	 */
	
	public static int solve() {
		int end = 10000000;
		int counter = 0;
		int first = 0;
		int second = 0;
		first = numDivisors(2);
		for (int i = 2; i < end; i++) {
			second = numDivisors(i + 1);
			if (first == second) counter++;
			first = second;
			//System.out.println(i);
		}
		return counter;
		
	}
	
	
	
	
}