import java.util.ArrayList;

public class Q0187 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {
		
		/*
		 * Let p1, p2 be primes under 10^8. Then s = p1 * p2 is semi prime. We allow p1 = p2.
		 */

		int end = 100000000;
		int total = 0; 
		ArrayList<Integer> primeList = primeList(end);
		for (int i = 0; i < primeList.size(); i++) {
			for (int j = 0; j <= i; j++) {
				long prod = (long) primeList.get(i) * primeList.get(j);
				if (prod > 0 && prod < end) total++;
				else break;
			}
		}
		return total;
	}


	/*
	 * OLD SOLUTION (SLOW):
	 * 	  int total = 1 //To include 4, first even semiprime. All others are 2 * odd prime.
		  for (int n = 1; n < end; n+=2) {
		    int counter = 0;
			if (prime[n] && (int) end/2 > n) {
				total++;
				continue;
			}
			else if (prime[n]) continue;
			else {
				for (int i = 1; i <= Math.sqrt(n); i++) {
					if (counter >= 3) break;
					if (n % i == 0) {
						if (prime[i]) counter++;
						if (prime[n/i]) counter++;
					}
				}
				if (counter == 2) total++;
			}
			System.out.println(n);
		}*/

}