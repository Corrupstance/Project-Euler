public class Q0002 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		return paritySumFib(1,2,0,32);
	}
	
	/*
	 * USE: Generates the nth Fibonacci number, starting from f_0 = a, f_1 = b.
	 */

	private static int fib(int a, int b, int n) {
		int arr[] = new int[n + 1];
		arr[0] = a;
		arr[1] = b;
		for (int i = 2; i < n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n - 1];
	}

	/*
	 * USE: Finds the parity sum (0 = even, 1 = odd) until the nth Fibonacci Numbers.
	 */

	private static int paritySumFib(int a, int b, int parity, int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (fib(a,b,i) % 2 == parity) sum += fib(a,b,i);
		}
		return sum;
	}


}