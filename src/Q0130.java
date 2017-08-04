public class Q0130 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static long solve() {
		long sum = 0;
		int counter = 0;
		int i = 91;
		boolean[] prime = primeSieve(10000000);
		while (true) {
			if (i % 5 != 0) {
				if ((i - 1) % repDiv(i) == 0 && !prime[i]) {
					counter++;
					sum += i;
				}
				if (counter == 25) break;
			}
			i += 2;
		}
		return sum;		
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