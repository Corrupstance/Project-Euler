import java.math.BigInteger;

public class Q0057 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static int solve() {
		/*
		 * Notice that
		 * 3	7	17	41	99	239	
		 * -	-	--	--	--	---
		 * 2	5	12	29	70	169
		 * 
		 * Denote the numerator as a_k, the denominator b_k.
		 * Then for k > 2, a_k = 2a_{k-1} + a_{k-2} and b_k = 2b_{k-1} + b_{k-2}.
		 */
		
		BigInteger a1 = new BigInteger("3");
		BigInteger a2 = new BigInteger("7");
		BigInteger b1 = new BigInteger("2");
		BigInteger b2 = new BigInteger("5");
		
		int counter = 0;
		
		for (int k = 3; k <= 1000; k++) {
			BigInteger a3 = a2.multiply(new BigInteger("2")).add(a1);
			BigInteger b3 = b2.multiply(new BigInteger("2")).add(b1);
			if (String.valueOf(a3).length() > String.valueOf(b3).length()) counter++;
			a1 = a2;
			a2 = a3;
			b1 = b2;
			b2 = b3;
		}
		
		return counter;
	}
	
	
}