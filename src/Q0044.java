public class Q0044 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static long solve() {
		/*
		 * P = n(3n-1)/2
		 * 2P = 3n^2 - n
		 * 24P + 1 = 36n^2 - 12n + 1
		 * 24P + 1 = (6n-1)^2
		 * n = [sqrt(24P + 1) + 1]/6 
		 * 
		 * so if n is a natrual number then P is the n^th pentagonal number.
		 */
		
		long D = 10000000;
		for (int a = 3; a < 10000; a++) {
			for (int b = 3; b < 10000; b++) {
				long j = pentagonal(a);
				long k = pentagonal(b);
				if (isPentagonal(Math.abs(j - k)) > 0 && isPentagonal(Math.abs(j + k)) > 0 && Math.abs(j - k) < D) D = Math.abs(j-k);
			}
			
		}
		
		return D;
	}
	
	private static int isPentagonal(long p) {
		double n = (Math.sqrt(24 * p + 1) + 1)/6; 
		if (n % 1 == 0) return (int) n;
		return -1;
	}
	
	private static long pentagonal(int n) {
		return n * (3 * n-1) / 2;
	}

	
	
	
}