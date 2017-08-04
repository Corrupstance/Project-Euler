public class Q0012 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static long solve() {
		long s = 0;
		int i = 0;
		while (true) {
			i++;
			s += i;
			int div = 0;
			for (long j = 1; j * j <= s; j++) {	
				if (s % j == 0) div += 2;
			}
			if (div > 500) break;
		}
		return s;
	}
	
	
	
}