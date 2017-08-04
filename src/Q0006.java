public class Q0006 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());		
	}
	
	public static int solve() {
		int sum = 0;
		int sumSq = 0;
		int sqSum = 0;
		
		for (int i = 1; i <= 100; i++) {
			sum += i;
			sqSum += i*i;
		}
		sumSq = sum * sum;
		return sumSq - sqSum;
	}
	
	
}