import java.math.BigDecimal;
import java.math.RoundingMode;

public class Q0080 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		
		/*
		 * Babylonian method: https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Babylonian_method
		 * Slightly misleading question; note that the digital sum includes the 
		 * digit(s) before the decimal point as well. We use j as a check for perfect squares (which we don't want),
		 * and we use the big decimal class with rounding mode to obtain an approximation that is at least 100 decimal places accurate.
		 * The loop for k is set to 101 times to ensure the calculation is correct to at least 100 decimal places; then it
		 * remains to add the digit sum together.
		 */
				
		int sum = 0;
		int j = 2;
		for (int i = 2; i <= 100; i++) {
			BigDecimal a = new BigDecimal(i+1);
			if (j * j != i) {
				for (int k = 0; k <= 100; k++) {
					BigDecimal div = new BigDecimal(i).divide(a,150,RoundingMode.HALF_EVEN);
					BigDecimal tmp = new BigDecimal(0.5).multiply(div.add(a));
					a = tmp;
				}
				String s = String.valueOf(a);
				int index = s.indexOf(".");
				int digitSum = 0;
				digitSum += Integer.valueOf(s.substring(0,1));
				String substr = s.substring(index + 1, index + 100);
				for (int p = 0; p < 99; p++) {
					digitSum += Integer.valueOf(substr.substring(p, p+1));
				}
				sum += digitSum;		
			}
			else j++;
		}
		return sum;
	}
	
	
	
}