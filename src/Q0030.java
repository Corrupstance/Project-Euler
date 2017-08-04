public class Q0030 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		int finalSum = 0;
		for (int i = 2; i < 1000000; i++) {
			int n = i;
			int powsum = 0;
			while (n > 0) {
				int rem = n % 10;
				n /= 10;        
				powsum += Math.pow(rem, 5);
			}

			if (powsum == i) finalSum += i;


		}
		return finalSum;
	}
}