public class Q0014 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		int max_count = 0;
		int result = 0;
		
		for (int i = 2; i < 1000000; i++) {
			long j = i;
			int counter = 0;
			while (j != 1) {
				if (j % 2 == 1) j = 3 * j + 1;
				else j/=2;
				counter++;
			}
			if (counter > max_count) {
				max_count = counter;
				result = i;
			}
		}
		return result;
	}
	
	
	
}