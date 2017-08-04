import java.math.BigInteger;

public class Q0020 extends Library {

	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static long solve() {
		BigInteger fac = BigInteger.ONE;
		BigInteger counter = new BigInteger("2");

		while (counter.compareTo(new BigInteger("100")) <= 0) {
			fac = fac.multiply(counter);
			counter = counter.add(BigInteger.ONE);
		}

		String s = String.valueOf(fac);
		long sum = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int digit = Character.getNumericValue(c); 
			sum+=digit;
		}

		return sum;
	}

}