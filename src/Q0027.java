public class Q0027 extends Library {


	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		int maxn = 0;
		int maxa = 0;
		int maxb = 0;

		for (int a = -999; a <= 999; a++) {
			for (int b = -1000; b <= 1000; b++) {
				int n = 0;
				while (isPrime(Math.abs(n * n + a * n + b))) {
					n++;
					if (n > maxn) {
						maxn = n;
						maxa = a;
						maxb = b;
					}
				}
			}
		}	
		return maxa * maxb;

	}
	
	public static boolean isPrime(int n) {
		boolean prime = true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0)	{
				prime = false;
				break;
			}
		}
		return prime;
	}




}