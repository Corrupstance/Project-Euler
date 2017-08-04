import java.math.BigInteger;

public class Q0056 extends Library {
	
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static BigInteger solve() {
		BigInteger max = BigInteger.ZERO;

		for (int a = 2; a < 100; a++) {
			for (int b = 2; b < 100; b++) {
				BigInteger num = new BigInteger(String.valueOf(a)).pow(b);
				String s = num.toString();
				BigInteger sum = BigInteger.ZERO;
				for (int i = 0; i < s.length(); i++) {
					int k = Integer.valueOf(s.substring(i, i+1));
					sum = sum.add(new BigInteger(String.valueOf(k)));
				}
				if (sum.compareTo(max) > 0) max = sum;
			}
		}
		return max;
	}
	
}