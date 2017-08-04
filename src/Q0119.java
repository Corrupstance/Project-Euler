import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Q0119 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static BigInteger solve() {
		
		/*
		 * We try 2^2, 2^3, 2^4, ... , 500^100.
		 */

		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		for (int x = 2; x < 500; x++) {
			BigInteger bigX = new BigInteger(String.valueOf(x));
			BigInteger tmp = bigX;
			for (int y = 2; y < 100; y++) {
				bigX = bigX.multiply(tmp);
				BigInteger sumDigits = sumDigits(bigX);
				if (sumDigits.equals(tmp)) list.add(bigX);
			}                  
			if (list.size() == 100) {
				Collections.sort(list);
				return list.get(29);
			}
		}
		return BigInteger.ZERO;
	}

	public static BigInteger sumDigits(BigInteger n) {
		BigInteger sum = BigInteger.ZERO;
		while (n.compareTo(BigInteger.ZERO) > 0) {
			sum = sum.add(n.mod(BigInteger.TEN));
			n = n.divide(BigInteger.TEN);
		}
		return sum;

	}
	
	/*	First attempt:	
	 * int counter = 0;
		BigInteger i = BigInteger.TEN;
		while (true) {
			BigInteger sumDigits = sumDigits(i);
			if (sumDigits.equals(BigInteger.ONE)) {
				i = i.add(BigInteger.ONE);	
				continue;
			}
			BigInteger tmp = sumDigits; 
			while (true) {
				if (sumDigits.equals(i)) {
					counter++;
					System.out.println(counter + " : " + i);
					break;
				}
				else if (sumDigits.compareTo(i) < 0) {
					sumDigits = sumDigits.multiply(sumDigits);
				}
				else {
					sumDigits = sumDigits.divide(tmp);
					if (sumDigits.compareTo(i) < 0) break;
				}
			}
			if (counter == 30) break;
			i = i.add(BigInteger.ONE);	
		}

	}
	 */


}