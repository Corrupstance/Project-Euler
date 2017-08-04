import java.math.BigInteger;

public class Q0053 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		/*
		 * We generate the binomial coefficients using Pascal's Triangle. See Library.java.
		 */
		
		BigInteger[][] binomial = binomial(100);
		int counter = 0;
		
		for (int n = 0; n <= 100; n++) {
			for (int r = 0; r <= n; r++) {
				if (binomial[n][r].compareTo(new BigInteger("1000000")) > 0) counter++;
			}
		}
		return counter;
		
	}
}