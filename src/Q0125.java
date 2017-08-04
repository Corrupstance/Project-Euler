import java.math.BigDecimal;
import java.util.ArrayList;

public class Q0125 extends Library {
	
	/*
	 * Use the formula sum(k^2) from k = 1 to n is equal to n * (n+1) * (2n+1) / 6. Then loop and subtract through
	 * squares to check if they are palindromes. Note we have to check if we have already counted a number 
	 * as there may be multiple ways of writing a number as a sum of squares.
	 */
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static BigDecimal solve() {
		
		BigDecimal totalSum = BigDecimal.ZERO;
		BigDecimal end = new BigDecimal(100000000);
		ArrayList<BigDecimal> list = new ArrayList<BigDecimal>();
		for (int n = 2; n < 10000; n++) {
			BigDecimal first = new BigDecimal(n);
			BigDecimal second = new BigDecimal(n+1);
			BigDecimal third = new BigDecimal((2 * n) + 1);
			BigDecimal sumSq = first.multiply(second).multiply(third).divide(new BigDecimal(6));
			for (int k = 0; k < n - 1; k++) {	
				BigDecimal minusSq = new BigDecimal(k * k);
				sumSq = sumSq.subtract(minusSq);
				if (sumSq.compareTo(end) > 0) continue;
				else if (palindrome(sumSq.toString()) && !list.contains(sumSq)) {
					totalSum = totalSum.add(sumSq);
					list.add(sumSq);
				}
			}
		}
		return totalSum;
	}
	
	
	
	
}